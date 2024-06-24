package org.senla.service.impl;

import lombok.RequiredArgsConstructor;
import org.senla.exception.NotFoundResourceException;
import org.senla.model.ProductCatalog;
import org.senla.model.dto.PriceDynamicsDTO;
import org.senla.repository.ProductCatalogRepository;
import org.senla.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class ProductCatalogServiceImpl implements ProductCatalogService {
    private final ProductCatalogRepository productCatalogRepository;
    private final KafkaTemplate<String,Object> template;

    @Value("${kafka.topic}")
    private String kafkaTopic;

    @Override
    public ProductCatalog save(ProductCatalog productCatalog) {
        sendEventsToTopic(PriceDynamicsDTO.builder()
                .price(productCatalog.getPrice())
                .idBatch(productCatalog.getIdBatch())
                .idShop(productCatalog.getIdShop())
                .date(LocalDateTime.now())
                .build()
        );
        return productCatalogRepository.save(productCatalog);
    }

    @Override
    public void remove(Long id) {
        Optional<ProductCatalog> data = productCatalogRepository.findById(id);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found productCatalog on ID="+id);
        }
        productCatalogRepository.deleteById(id);
    }

    @Override
    public Optional<ProductCatalog> getById(Long id) {
        Optional<ProductCatalog> data = productCatalogRepository.findById(id);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found productCatalog on ID="+id);
        }
        return data;
    }

    @Override
    public List<ProductCatalog> getAll() {
        return new ArrayList<>(productCatalogRepository.findAll());
    }

    @Override
    public List<ProductCatalog> comparePrices(Long id) {
        Optional<ProductCatalog> compareProductCatalog = productCatalogRepository.findById(id);
        if(!compareProductCatalog.isPresent()) {
            throw new NotFoundResourceException("Not found productCatalog on ID="+id);
        }
        List<ProductCatalog> sortedProductCatalogByPrice = productCatalogRepository.findAllOrderedByPrice(
                compareProductCatalog.get().getIdBatch()
        );
        List<ProductCatalog> compareByPricesForProductCatalog = new ArrayList<>();
        for(ProductCatalog productCatalog: sortedProductCatalogByPrice) {
            if(compareProductCatalog.get().getId() == productCatalog.getId()) {
                continue;
            }
            float comparePrices = 0;
            if(productCatalog.getPrice() > compareProductCatalog.get().getPrice()) {
                comparePrices = ((productCatalog.getPrice()-compareProductCatalog.get().getPrice())/productCatalog.getPrice())*100;
            } else {
                comparePrices = -((compareProductCatalog.get().getPrice() - productCatalog.getPrice())/compareProductCatalog.get().getPrice())*100;
            }
            compareByPricesForProductCatalog.add(new ProductCatalog(
                    productCatalog.getId(),
                    productCatalog.getIdShop(),
                    productCatalog.getIdBatch(),
                    productCatalog.getCount(),
                    comparePrices,
                    productCatalog.getDate(),
                    productCatalog.getShop(),
                    productCatalog.getBatchOfProduct()
            ));
        }
        return compareByPricesForProductCatalog;
    }

    @Override
    public Optional<ProductCatalog> update(ProductCatalog updateProductCatalog, Long id) {
        Optional<ProductCatalog> data = productCatalogRepository.findById(id);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found productCatalog on ID="+id);
        }
        sendEventsToTopic(PriceDynamicsDTO.builder()
                .price(updateProductCatalog.getPrice())
                .idBatch(updateProductCatalog.getIdBatch())
                .idShop(updateProductCatalog.getIdShop())
                .date(LocalDateTime.now())
                .build()
        );
        return data
                .map(productCatalog -> {
                    updateProductCatalog.setId(productCatalog.getId());
                    return productCatalogRepository.save(updateProductCatalog);
                });
    }

    public void sendEventsToTopic(PriceDynamicsDTO priceDynamicsDTO) {
        try {
            CompletableFuture<SendResult<String, Object>> future = template.send(kafkaTopic, priceDynamicsDTO);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent message=[" + priceDynamicsDTO.toString() +
                            "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" +
                            priceDynamicsDTO.toString() + "] due to : " + ex.getMessage());
                }
            });

        } catch (Exception ex) {
            System.out.println("ERROR : "+ ex.getMessage());
        }
    }
}