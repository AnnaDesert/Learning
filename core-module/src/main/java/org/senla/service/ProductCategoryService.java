package org.senla.service;

import org.senla.model.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryService {
    ProductCategory save(ProductCategory productCategory);
    void remove(Long id);
    Optional<ProductCategory> getById(Long id);
    Optional<ProductCategory> getByName(String name);
    List<ProductCategory> getAll();
    Optional<ProductCategory> update(ProductCategory productCategory, Long id);
}
