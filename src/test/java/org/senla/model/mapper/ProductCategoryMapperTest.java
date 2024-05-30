package org.senla.model.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.senla.model.ProductCategory;
import org.senla.model.dto.ProductCategoryCreationDTO;
import org.senla.model.dto.ProductCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductCategoryMapperTest {
    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Test
    void toDto() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(1L);
        productCategory.setName("Молочная продукция");

        ProductCategoryDTO productCategoryDTO = productCategoryMapper.toDto(productCategory);

        Assertions.assertNotNull(productCategoryDTO);
        assertThat(productCategoryDTO.getId()).isEqualTo(productCategory.getId());
        assertThat(productCategoryDTO.getName()).isEqualTo(productCategory.getName());
    }

    @Test
    void toProductCategory() {
        ProductCategoryCreationDTO productCategoryDTO = new ProductCategoryCreationDTO();
        productCategoryDTO.setName("Молочная продукция");

        ProductCategory productCategory = productCategoryMapper.toProductCategory(productCategoryDTO);

        Assertions.assertNotNull(productCategory);
        assertThat(productCategoryDTO.getName()).isEqualTo(productCategory.getName());
    }
}