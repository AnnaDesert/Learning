package org.senla.service;

import org.senla.model.ProductCatalog;

import java.util.List;
import java.util.Optional;

public interface ProductCatalogService {
    ProductCatalog save(ProductCatalog productCatalog);
    void remove(Long id);
    Optional<ProductCatalog> getById(Long id);
    List<ProductCatalog> getAll();
    List<ProductCatalog> comparePrices(Long id);
    Optional<ProductCatalog> update(ProductCatalog productCatalog, Long id);
}
