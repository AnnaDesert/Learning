package org.senla.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.senla.model.ProductCategory;
import org.senla.repository.ProductCategoryRepository;
import org.senla.service.ProductCategoryService;
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
class ProductCategoryServiceImplTest {
    @Autowired
    private ProductCategoryService productCategoryService;

    @MockBean
    private ProductCategoryRepository productCategoryRepository;

    @Test
    void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(1L);
        productCategory.setName("Молочная продукция");

        Assertions.assertNotNull(productCategory);
        productCategoryService.save(productCategory);
        verify(productCategoryRepository, times(1)).save(productCategory);
    }

    @Test
    void remove() {
        productCategoryService.remove(2L);
        verify(productCategoryRepository, times(1)).deleteById(2L);
    }

    @Test
    void getById() {
        productCategoryService.getById(3L);
        verify(productCategoryRepository, times(1)).findById(3L);
    }

    @Test
    void getByName() {
        productCategoryService.getByName("Молочная продукция");
        verify(productCategoryRepository, times(1)).findByName("Молочная продукция");
    }

    @Test
    void getAll() {
        productCategoryService.getAll();
        verify(productCategoryRepository, times(1)).findAll();
    }

    @Test
    void update() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName("Молочная продукция");

        ProductCategory productCategoryIn = new ProductCategory();
        productCategoryIn.setId(2L);
        productCategoryIn.setName("Мясная продукция");

        given(productCategoryRepository.findById(2L)).willReturn(Optional.of(productCategoryIn));

        Assertions.assertNotNull(productCategory);
        productCategoryService.update(productCategory, 2L);
        verify(productCategoryRepository, times(1)).findById(2L);
        Assertions.assertNotNull(productCategoryIn);
        assertThat(productCategory.getId()).isEqualTo(2L);
        verify(productCategoryRepository, times(1)).save(productCategory);
    }
}