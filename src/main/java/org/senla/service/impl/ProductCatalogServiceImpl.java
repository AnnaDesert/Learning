package org.senla.service.impl;

import org.senla.exception.NotFoundResourceException;
import org.senla.model.ProductCatalog;
import org.senla.repository.ProductCatalogRepository;
import org.senla.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {
    private final ProductCatalogRepository productCatalogRepository;

    @Autowired
    public ProductCatalogServiceImpl(ProductCatalogRepository productCatalogRepository) {
        this.productCatalogRepository = productCatalogRepository;
    }

    @Override
    public ProductCatalog save(ProductCatalog productCatalog) {
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
        return data
                .map(productCatalog -> {
                    updateProductCatalog.setId(productCatalog.getId());
                    return productCatalogRepository.save(updateProductCatalog);
                });
    }
}