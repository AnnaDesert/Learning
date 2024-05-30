package org.senla.model.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.senla.model.ProductCatalog;
import org.senla.model.dto.ProductCatalogCreationDTO;
import org.senla.model.dto.ProductCatalogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductCatalogMapperTest {
    @Autowired
    ProductCatalogMapper productCatalogMapper;

    @Test
    void toDto() {
        ProductCatalog productCatalog = new ProductCatalog();
        productCatalog.setIdShop(1L);
        productCatalog.setIdBatch(2L);
        productCatalog.setPrice(30.56F);
        productCatalog.setCount(50);

        ProductCatalogDTO productCatalogDTO = productCatalogMapper.toDto(productCatalog);

        Assertions.assertNotNull(productCatalogDTO);
        assertThat(productCatalogDTO.getIdShop()).isEqualTo(productCatalog.getIdShop());
        assertThat(productCatalogDTO.getIdBatch()).isEqualTo(productCatalog.getIdBatch());
        assertThat(productCatalogDTO.getPrice()).isEqualTo(productCatalog.getPrice());
        assertThat(productCatalogDTO.getCount()).isEqualTo(productCatalog.getCount());
    }

    @Test
    void toCatalog() {
        ProductCatalogCreationDTO productCatalogDTO = new ProductCatalogCreationDTO();
        productCatalogDTO.setIdBatch(2L);
        productCatalogDTO.setPrice(30.56F);
        productCatalogDTO.setCount(50);

        ProductCatalog productCatalog = productCatalogMapper.toCatalog(productCatalogDTO);

        Assertions.assertNotNull(productCatalog);
        assertThat(productCatalogDTO.getIdBatch()).isEqualTo(productCatalog.getIdBatch());
        assertThat(productCatalogDTO.getPrice()).isEqualTo(productCatalog.getPrice());
        assertThat(productCatalogDTO.getCount()).isEqualTo(productCatalog.getCount());
    }
}