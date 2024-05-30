package org.senla.model.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.senla.model.Shop;
import org.senla.model.dto.ShopCreationDTO;
import org.senla.model.dto.ShopDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShopMapperTest {
    @Autowired
    ShopMapper shopMapper;

    @Test
    void toDto() {
        Shop shop = new Shop();
        shop.setId(1L);
        shop.setName("Произвольный");
        shop.setAddress("ул. Произвольная 32");
        shop.setIdAdmin(3L);

        ShopDTO shopDTO = shopMapper.toDto(shop);

        Assertions.assertNotNull(shopDTO);
        assertThat(shopDTO.getId()).isEqualTo(shop.getId());
        assertThat(shopDTO.getName()).isEqualTo(shop.getName());
        assertThat(shopDTO.getAddress()).isEqualTo(shop.getAddress());
        assertThat(shopDTO.getIdAdmin()).isEqualTo(shop.getIdAdmin());
    }

    @Test
    void toShop() {
        ShopCreationDTO shopDTO = new ShopCreationDTO();
        shopDTO.setName("Произвольный");
        shopDTO.setAddress("ул. Произвольная 32");
        shopDTO.setIdAdmin(3L);

        Shop shop = shopMapper.toShop(shopDTO);

        Assertions.assertNotNull(shop);
        assertThat(shopDTO.getName()).isEqualTo(shop.getName());
        assertThat(shopDTO.getAddress()).isEqualTo(shop.getAddress());
        assertThat(shopDTO.getIdAdmin()).isEqualTo(shop.getIdAdmin());
    }
}