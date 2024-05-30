package org.senla.service.impl;

import org.senla.exception.NotFoundResourceException;
import org.senla.model.ProductCategory;
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
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public void remove(Long id) {
        Optional<ProductCategory> data = productCategoryRepository.findById(id);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found productCategory on ID="+id);
        }
        productCategoryRepository.deleteById(id);
    }

    @Override
    public Optional<ProductCategory> getById(Long id) {
        Optional<ProductCategory> data = productCategoryRepository.findById(id);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found productCategory on ID="+id);
        }
        return data;
    }

    @Override
    public Optional<ProductCategory> getByName(String name) {
        Optional<ProductCategory> data = productCategoryRepository.findByName(name);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found productCategory on name="+name);
        }
        return productCategoryRepository.findByName(name);
    }

    @Override
    public List<ProductCategory> getAll() {
        return new ArrayList<>(productCategoryRepository.findAll());
    }

    @Override
    public Optional<ProductCategory> update(ProductCategory updateProductCategory, Long id) {
        Optional<ProductCategory> data = productCategoryRepository.findById(id);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found productCategory on ID="+id);
        }
        return data
                .map(productCategory -> {
                    updateProductCategory.setId(productCategory.getId());
                    return productCategoryRepository.save(updateProductCategory);
                });
    }
}