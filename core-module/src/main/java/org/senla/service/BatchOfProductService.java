package org.senla.service;

import org.senla.model.BatchOfProduct;

import java.util.List;
import java.util.Optional;

public interface BatchOfProductService {
    BatchOfProduct save(BatchOfProduct batchOfProduct);
    void remove(Long id);
    Optional<BatchOfProduct> getById(Long id);
    List<BatchOfProduct> getAll();
    Optional<BatchOfProduct> update(BatchOfProduct batchOfProduct, Long id);
    List<BatchOfProduct> findByProductCategory(String productCategory);
}
