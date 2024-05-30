package org.senla.model.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.senla.model.BatchOfProduct;
import org.senla.model.dto.BatchOfProductCreationDTO;
import org.senla.model.dto.BatchOfProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class BatchOfProductMapperTest {

    @Autowired
    BatchOfProductMapper batchOfProductMapper;

    @Test
    void toDto() {
        BatchOfProduct batchOfProduct = new BatchOfProduct();
        batchOfProduct.setId(1L);
        batchOfProduct.setExpirationDateStart(LocalDateTime.of(2024, 12, 23,15, 30));
        batchOfProduct.setExpirationDateEnd(LocalDateTime.of(2024, 12, 27,15, 30));
        batchOfProduct.setIdProduct(3L);
        batchOfProduct.setCount(24);

        BatchOfProductDTO batchOfProductDTO = batchOfProductMapper.toDto(batchOfProduct);

        Assertions.assertNotNull(batchOfProductDTO);
        assertThat(batchOfProductDTO.getId()).isEqualTo(batchOfProduct.getId());
        assertThat(batchOfProductDTO.getExpirationDateStart()).isEqualTo(batchOfProduct.getExpirationDateStart());
        assertThat(batchOfProductDTO.getExpirationDateEnd()).isEqualTo(batchOfProduct.getExpirationDateEnd());
        assertThat(batchOfProductDTO.getIdProduct()).isEqualTo(batchOfProduct.getIdProduct());
        assertThat(batchOfProductDTO.getCount()).isEqualTo(batchOfProduct.getCount());
    }

    @Test
    void toBatchOfProduct() {
        BatchOfProductCreationDTO batchOfProductDTO = new BatchOfProductCreationDTO();
        batchOfProductDTO.setExpirationDateStart(LocalDateTime.of(2024, 12, 23,15, 30));
        batchOfProductDTO.setExpirationDateEnd(LocalDateTime.of(2024, 12, 27,15, 30));
        batchOfProductDTO.setIdProduct(3L);
        batchOfProductDTO.setCount(24);

        BatchOfProduct batchOfProduct = batchOfProductMapper.toBatchOfProduct(batchOfProductDTO);

        Assertions.assertNotNull(batchOfProduct);
        assertThat(batchOfProductDTO.getExpirationDateStart()).isEqualTo(batchOfProduct.getExpirationDateStart());
        assertThat(batchOfProductDTO.getExpirationDateEnd()).isEqualTo(batchOfProduct.getExpirationDateEnd());
        assertThat(batchOfProductDTO.getIdProduct()).isEqualTo(batchOfProduct.getIdProduct());
        assertThat(batchOfProductDTO.getCount()).isEqualTo(batchOfProduct.getCount());
    }
}