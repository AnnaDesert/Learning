package org.senla.service.impl;

import lombok.RequiredArgsConstructor;
import org.senla.exception.NotFoundResourceException;
import org.senla.model.BatchOfProduct;
import org.senla.repository.BatchOfProductRepository;
import org.senla.service.BatchOfProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

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
    public Optional<BatchOfProduct> getById(Long id) {
        Optional<BatchOfProduct> data = batchOfProductRepository.findById(id);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found batchOfProduct on ID="+id);
        }
        return data;
    }

    @Override
    public List<BatchOfProduct> getAll() {
        return new ArrayList<>(batchOfProductRepository.findAll());
    }

    @Override
    public Optional<BatchOfProduct> update(BatchOfProduct updateBatchOfProduct, Long id) {
        Optional<BatchOfProduct> data = batchOfProductRepository.findById(id);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found batchOfProduct on ID="+id);
        }
        return data
                .map(batchOfProduct -> {
                    updateBatchOfProduct.setId(batchOfProduct.getId());
                    return batchOfProductRepository.save(updateBatchOfProduct);
                });
    }

    @Override
    public List<BatchOfProduct> findByProductCategory(String productCategory) {
        return batchOfProductRepository.findByProductCategory(productCategory);
    }
}