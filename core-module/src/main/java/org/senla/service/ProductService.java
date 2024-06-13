package org.senla.service;

import org.senla.model.Product;
import org.springframework.data.repository.query.Param;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(Product product);
    List<Product> saveCSV(String fileName) throws IOException;
    void remove(Long id);
    Optional<Product> getById(Long id);
    List<Product> getByName(String name);
    List<Product> getAll();
    Optional<Product> update(Product product, Long id);
    List<Product> findByCategory(String category);
}
