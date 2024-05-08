package org.senla.service.impl;

import org.senla.exception.NotFoundResourceBatchOfProductException;
import org.senla.model.BatchOfProduct;
import org.senla.repository.BatchOfProductRepository;
import org.senla.service.BatchOfProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BatchOfProductServiceImpl implements BatchOfProductService {
    private final BatchOfProductRepository batchOfProductRepository;

    @Autowired
    public BatchOfProductServiceImpl(BatchOfProductRepository batchOfProductRepository) {
        this.batchOfProductRepository = batchOfProductRepository;
    }

    @Override
    public Optional<BatchOfProduct> save(BatchOfProduct batchOfProduct) {
        return Optional.ofNullable(Optional.of(batchOfProductRepository.save(batchOfProduct))
                .orElseThrow(() ->
                        new NotFoundResourceBatchOfProductException("The batchOfProduct cannot be saved")));
    }

    @Override
    public void remove(Long id) {
        batchOfProductRepository.deleteById(id);
    }

    @Override
    public Optional<BatchOfProduct> getById(Long id) {
        return Optional.ofNullable(Optional.of(batchOfProductRepository.findById(id).get())
                .orElseThrow(() ->
                        new NotFoundResourceBatchOfProductException("The batchOfProduct with id " + id + " not found")));
    }

    @Override
    public List<BatchOfProduct> getAll() {
        return new ArrayList<>(batchOfProductRepository.findAll());
    }

    @Override
    public Optional<BatchOfProduct> update(BatchOfProduct updateBatchOfProduct, Long id) {
        return Optional.ofNullable(Optional.of(batchOfProductRepository.findById(id).get())
                .map(batchOfProduct -> {
                    batchOfProduct.setIdProduct(updateBatchOfProduct.getIdProduct());
                    batchOfProduct.setExpirationDateStart(updateBatchOfProduct.getExpirationDateStart());
                    batchOfProduct.setExpirationDateEnd(updateBatchOfProduct.getExpirationDateEnd());
                    batchOfProduct.setCount(updateBatchOfProduct.getCount());
                    return batchOfProductRepository.save(updateBatchOfProduct);
                })
                .orElseThrow(() ->
                        new NotFoundResourceBatchOfProductException("The batchOfProduct cannot be updated")));
    }
}