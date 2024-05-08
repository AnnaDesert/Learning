package org.senla.service.impl;

import org.senla.exception.NotFoundResourceProductCatalogException;
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
    public Optional<ProductCatalog> save(ProductCatalog productCatalog) {
        return Optional.ofNullable(Optional.of(productCatalogRepository.save(productCatalog))
                .orElseThrow(() ->
                        new NotFoundResourceProductCatalogException("The productCatalog cannot be saved")));
    }

    @Override
    public void remove(Long id) {
        productCatalogRepository.deleteById(id);
    }

    @Override
    public Optional<ProductCatalog> getById(Long id) {
        return Optional.ofNullable(Optional.of(productCatalogRepository.findById(id).get())
                .orElseThrow(() ->
                        new NotFoundResourceProductCatalogException("The productCatalog with id " + id + " not found")));
    }

    @Override
    public List<ProductCatalog> getAll() {
        return new ArrayList<>(productCatalogRepository.findAll());
    }

    @Override
    public Optional<ProductCatalog> update(ProductCatalog updateProductCatalog, Long id) {
        return Optional.ofNullable(Optional.of(productCatalogRepository.findById(id).get())
                .map(productCatalog -> {
                    productCatalog.setCount(updateProductCatalog.getCount());
                    productCatalog.setPrice(updateProductCatalog.getPrice());
                    productCatalog.setIdBatch(updateProductCatalog.getIdBatch());
                    return productCatalogRepository.save(updateProductCatalog);
                })
                .orElseThrow(() ->
                        new NotFoundResourceProductCatalogException("The productCatalog cannot be updated")));
    }
}