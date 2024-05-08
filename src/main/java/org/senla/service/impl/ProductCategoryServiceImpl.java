package org.senla.service.impl;

import org.senla.exception.NotFoundResourceProductCategoryException;
import org.senla.model.ProductCategory;
import org.senla.repository.ProductCategoryRepository;
import org.senla.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public Optional<ProductCategory> save(ProductCategory productCategory) {
        return Optional.ofNullable(Optional.of(productCategoryRepository.save(productCategory))
                .orElseThrow(() ->
                        new NotFoundResourceProductCategoryException("The productCategory cannot be saved")));
    }

    @Override
    public void remove(Long id) {
        productCategoryRepository.deleteById(id);
    }

    @Override
    public Optional<ProductCategory> getById(Long id) {
        return Optional.ofNullable(Optional.of(productCategoryRepository.findById(id).get())
                .orElseThrow(() ->
                        new NotFoundResourceProductCategoryException("The productCategory with id " + id + " not found")));
    }

    @Override
    public Optional<ProductCategory> getByName(String name) {
        return Optional.ofNullable(productCategoryRepository.findByName(name))
                .orElseThrow(() ->
                        new NotFoundResourceProductCategoryException("The productCategory name id " + name + " not found"));
    }

    @Override
    public List<ProductCategory> getAll() {
        return new ArrayList<>(productCategoryRepository.findAll());
    }

    @Override
    public Optional<ProductCategory> update(ProductCategory updateProductCategory, Long id) {
        return Optional.ofNullable(Optional.of(productCategoryRepository.findById(id).get())
                .map(productCategory -> {
                    productCategory.setName(updateProductCategory.getName());
                    return productCategoryRepository.save(updateProductCategory);
                })
                .orElseThrow(() ->
                        new NotFoundResourceProductCategoryException("The productCategory cannot be updated")));
    }
}