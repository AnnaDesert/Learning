package org.senla.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.senla.model.Product;
import org.senla.repository.ProductRepository;
import org.senla.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    void save() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Молоко");

        Assertions.assertNotNull(product);
        productService.save(product);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void remove() {
        productService.remove(2L);
        verify(productRepository, times(1)).deleteById(2L);
    }

    @Test
    void getById() {
        productService.getById(3L);
        verify(productRepository, times(1)).findById(3L);
    }

    @Test
    void getByName() {
        productService.getByName("Молоко");
        verify(productRepository, times(1)).findByName("Молоко");
    }

    @Test
    void getAll() {
        productService.getAll();
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void update() {
        Product product = new Product();
        product.setName("Молоко");

        Product productIn = new Product();
        productIn.setId(2L);
        productIn.setName("Кефир");

        given(productRepository.findById(2L)).willReturn(Optional.of(productIn));

        Assertions.assertNotNull(product);
        productService.update(product, 2L);
        verify(productRepository, times(1)).findById(2L);
        Assertions.assertNotNull(productIn);
        assertThat(product.getId()).isEqualTo(2L);
        verify(productRepository, times(1)).save(product);
    }
}