package org.senla.service;

import org.senla.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> save(Product product);
    void remove(Long id);
    Optional<Product> getById(Long id);
    List<Product> getByName(String name);
    List<Product> getAll();
    Optional<Product> update(Product product, Long id);
}
