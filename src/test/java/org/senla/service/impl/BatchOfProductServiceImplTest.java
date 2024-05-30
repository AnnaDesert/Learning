package org.senla.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.senla.model.BatchOfProduct;
import org.senla.repository.BatchOfProductRepository;
import org.senla.service.BatchOfProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
class BatchOfProductServiceImplTest {
    @Autowired
    private BatchOfProductService batchOfProductService;

    @MockBean
    private BatchOfProductRepository batchOfProductRepository;

    @Test
    void save() {
        BatchOfProduct batchOfProduct = new BatchOfProduct();
        batchOfProduct.setId(1L);
        batchOfProduct.setExpirationDateStart(LocalDateTime.of(2024, 12, 23,15, 30));
        batchOfProduct.setExpirationDateEnd(LocalDateTime.of(2024, 12, 27,15, 30));
        batchOfProduct.setIdProduct(3L);
        batchOfProduct.setCount(24);

        Assert.assertNotNull(batchOfProduct);
        batchOfProductService.save(batchOfProduct);
        verify(batchOfProductRepository, times(1)).save(batchOfProduct);
    }

    @Test
    void remove() {
        batchOfProductService.remove(2L);
        verify(batchOfProductRepository, times(1)).deleteById(2L);
    }

    @Test
    void getById() {
        batchOfProductService.getById(3L);
        verify(batchOfProductRepository, times(1)).findById(3L);
    }

    @Test
    void getAll() {
        batchOfProductService.getAll();
        verify(batchOfProductRepository, times(1)).findAll();
    }

    @Test
    void update() {
        BatchOfProduct batchOfProduct = new BatchOfProduct();
        batchOfProduct.setExpirationDateStart(LocalDateTime.of(2024, 12, 23,15, 30));
        batchOfProduct.setExpirationDateEnd(LocalDateTime.of(2024, 12, 27,15, 30));
        batchOfProduct.setIdProduct(3L);
        batchOfProduct.setCount(24);

        BatchOfProduct batchOfProductIn = new BatchOfProduct();
        batchOfProductIn.setId(2L);
        batchOfProductIn.setExpirationDateStart(LocalDateTime.of(2024, 12, 23,15, 30));
        batchOfProductIn.setExpirationDateEnd(LocalDateTime.of(2024, 12, 27,15, 30));
        batchOfProductIn.setIdProduct(3L);
        batchOfProductIn.setCount(24);

        given(batchOfProductRepository.findById(2L)).willReturn(Optional.of(batchOfProductIn));

        Assert.assertNotNull(batchOfProduct);
        batchOfProductService.update(batchOfProduct, 2L);
        verify(batchOfProductRepository, times(1)).findById(2L);
        Assert.assertNotNull(batchOfProductIn);
        assertThat(batchOfProduct.getId()).isEqualTo(2L);
        verify(batchOfProductRepository, times(1)).save(batchOfProduct);
    }
}