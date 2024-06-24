package org.senla.service;

import org.senla.model.BatchOfProduct;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BatchOfProductService {
    BatchOfProduct save(BatchOfProduct batchOfProduct);
    void remove(Long id);
    BatchOfProduct getById(Long id);
    List<BatchOfProduct> getAll();
    BatchOfProduct update(BatchOfProduct batchOfProduct, Long id);
    List<BatchOfProduct> findByProductCategory(String productCategory);
}
