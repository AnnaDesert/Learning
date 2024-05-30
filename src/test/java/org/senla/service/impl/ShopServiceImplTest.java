package org.senla.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.senla.model.Shop;
import org.senla.repository.ShopRepository;
import org.senla.service.ShopService;
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
class ShopServiceImplTest {
    @Autowired
    private ShopService shopService;

    @MockBean
    private ShopRepository shopRepository;

    @Test
    void save() {
        Shop shop = new Shop();
        shop.setId(1L);
        shop.setName("Произвольный");
        shop.setAddress("ул. Произвольная 32");
        shop.setIdAdmin(3L);

        Assertions.assertNotNull(shop);
        shopService.save(shop);
        verify(shopRepository, times(1)).save(shop);
    }

    @Test
    void remove() {
        shopService.remove(2L);
        verify(shopRepository, times(1)).deleteById(2L);
    }

    @Test
    void getById() {
        shopService.getById(3L);
        verify(shopRepository, times(1)).findById(3L);
    }

    @Test
    void getByName() {
        shopService.getByName("Произвольный");
        verify(shopRepository, times(1)).findByName("Произвольный");
    }

    @Test
    void getByAddress() {
        shopService.getByAddress("ул. Произвольная 32");
        verify(shopRepository, times(1)).findByAddress("ул. Произвольная 32");
    }

    @Test
    void getAll() {
        shopService.getAll();
        verify(shopRepository, times(1)).findAll();
    }

    @Test
    void update() {
        Shop shop = new Shop();
        shop.setName("Произвольный");
        shop.setAddress("ул. Произвольная 32");
        shop.setIdAdmin(3L);

        Shop shopIn = new Shop();
        shopIn.setId(2L);
        shop.setName("Произвольный Оптовый");
        shop.setAddress("ул. Произвольная 35");
        shop.setIdAdmin(3L);

        given(shopRepository.findById(2L)).willReturn(Optional.of(shopIn));

        Assertions.assertNotNull(shop);
        shopService.update(shop, 2L);
        verify(shopRepository, times(1)).findById(2L);
        Assertions.assertNotNull(shopIn);
        assertThat(shop.getId()).isEqualTo(2L);
        verify(shopRepository, times(1)).save(shop);
    }
}