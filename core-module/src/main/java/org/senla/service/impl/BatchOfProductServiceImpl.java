package org.senla.service.impl;

import lombok.RequiredArgsConstructor;
import org.senla.exception.NotFoundResourceException;
import org.senla.model.BatchOfProduct;
import org.senla.repository.BatchOfProductRepository;
import org.senla.service.BatchOfProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BatchOfProductServiceImpl implements BatchOfProductService {
    private final BatchOfProductRepository batchOfProductRepository;

    @Override
    public BatchOfProduct save(BatchOfProduct batchOfProduct) {
        return batchOfProductRepository.save(batchOfProduct);
    }

    @Override
    public void remove(Long id) {
        Optional<BatchOfProduct> data = batchOfProductRepository.findById(id);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found batchOfProduct on ID="+id);
        }
        batchOfProductRepository.deleteById(id);
    }

    @Override
    public BatchOfProduct getById(Long id) {
        Optional<BatchOfProduct> data = batchOfProductRepository.findById(id);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found batchOfProduct on ID="+id);
        }
        return data.get();
    }

    @Override
    public List<BatchOfProduct> getAll() {
        return new ArrayList<>(batchOfProductRepository.findAll());
    }

    @Override
    public BatchOfProduct update(BatchOfProduct updateBatchOfProduct, Long id) {
        Optional<BatchOfProduct> data = batchOfProductRepository.findById(id);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found batchOfProduct on ID="+id);
        }
        return data
                .map(batchOfProduct -> {
                    updateBatchOfProduct.setId(batchOfProduct.getId());
                    return batchOfProductRepository.save(updateBatchOfProduct);
                }).get();
    }

    @Override
    public List<BatchOfProduct> findByProductCategory(String productCategory) {
        return batchOfProductRepository.findByProductCategory(productCategory);
    }
}