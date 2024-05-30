package org.senla.model.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.senla.model.Product;
import org.senla.model.dto.ProductCreationDTO;
import org.senla.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductMapperTest {
    @Autowired
    ProductMapper productMapper;

    @Test
    void toDto() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Молоко");

        ProductDTO productDTO = productMapper.toDto(product);

        Assertions.assertNotNull(productDTO);
        assertThat(productDTO.getId()).isEqualTo(product.getId());
        assertThat(productDTO.getName()).isEqualTo(product.getName());
    }

    @Test
    void toProduct() {
        ProductCreationDTO productDTO = new ProductCreationDTO();
        productDTO.setName("Молоко");

        Product product = productMapper.toProduct(productDTO);

        Assertions.assertNotNull(product);
        assertThat(productDTO.getName()).isEqualTo(product.getName());
    }
}