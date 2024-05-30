package org.senla.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.senla.model.ProductCatalog;
import org.senla.repository.ProductCatalogRepository;
import org.senla.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductCatalogServiceImplTest {
    @Autowired
    private ProductCatalogService productCatalogService;

    @MockBean
    private ProductCatalogRepository productCatalogRepository;

    @Test
    void save() {
        ProductCatalog productCatalog = new ProductCatalog();
        productCatalog.setIdShop(1L);
        productCatalog.setIdBatch(2L);
        productCatalog.setPrice(30.56F);
        productCatalog.setCount(50);

        Assertions.assertNotNull(productCatalog);
        productCatalogService.save(productCatalog);
        verify(productCatalogRepository, times(1)).save(productCatalog);
    }

    @Test
    void remove() {
        productCatalogService.remove(2L);
        verify(productCatalogRepository, times(1)).deleteById(2L);
    }

    @Test
    void getById() {
        productCatalogService.getById(3L);
        verify(productCatalogRepository, times(1)).findById(3L);
    }

    @Test
    void getAll() {
        productCatalogService.getAll();
        verify(productCatalogRepository, times(1)).findAll();
    }

    @Test
    void update() {
        ProductCatalog productCatalog = new ProductCatalog();
        productCatalog.setIdBatch(2L);
        productCatalog.setPrice(30.56F);
        productCatalog.setCount(50);

        ProductCatalog productCatalogIn = new ProductCatalog();
        productCatalogIn.setId(2L);
        productCatalogIn.setIdBatch(2L);
        productCatalogIn.setPrice(30.56F);
        productCatalogIn.setCount(50);

        given(productCatalogRepository.findById(2L)).willReturn(Optional.of(productCatalogIn));

        Assertions.assertNotNull(productCatalog);
        productCatalogService.update(productCatalog, 2L);
        verify(productCatalogRepository, times(1)).findById(2L);
        Assertions.assertNotNull(productCatalogIn);
        assertThat(productCatalog.getId()).isEqualTo(2L);
        verify(productCatalogRepository, times(1)).save(productCatalog);
    }
}