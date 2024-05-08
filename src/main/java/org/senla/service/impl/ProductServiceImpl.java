package org.senla.service.impl;

import org.senla.exception.NotFoundResourceProductException;
import org.senla.model.Product;
import org.senla.repository.ProductRepository;
import org.senla.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> save(Product product) {
        return Optional.ofNullable(Optional.of(productRepository.save(product))
                .orElseThrow(() ->
                        new NotFoundResourceProductException("The product cannot be saved")));
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> getById(Long id) {
        return Optional.ofNullable(Optional.of(productRepository.findById(id).get())
                .orElseThrow(() ->
                        new NotFoundResourceProductException("The product with id " + id + " not found")));
    }

    @Override
    public List<Product> getByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(productRepository.findAll());
    }

    @Override
    public Optional<Product> update(Product updateProduct, Long id) {
        return Optional.ofNullable(Optional.of(productRepository.findById(id).get())
                .map(product -> {
                    product.setName(updateProduct.getName());
                    return productRepository.save(updateProduct);
                })
                .orElseThrow(() ->
                        new NotFoundResourceProductException("The product cannot be updated")));
    }
}