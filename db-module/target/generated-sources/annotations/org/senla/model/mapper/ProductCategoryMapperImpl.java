package org.senla.model.mapper;

import javax.annotation.processing.Generated;
import org.senla.model.ProductCategory;
import org.senla.swagger.model.ProductCategoryCreationDTO;
import org.senla.swagger.model.ProductCategoryDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T09:46:27+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProductCategoryMapperImpl implements ProductCategoryMapper {

    @Override
    public ProductCategoryDTO toDto(ProductCategory productCategory) {
        if ( productCategory == null ) {
            return null;
        }

        ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();

        productCategoryDTO.setId( productCategory.getId() );
        productCategoryDTO.setName( productCategory.getName() );

        return productCategoryDTO;
    }

    @Override
    public ProductCategory toProductCategory(ProductCategoryCreationDTO productCategoryDTO) {
        if ( productCategoryDTO == null ) {
            return null;
        }

        ProductCategory.ProductCategoryBuilder productCategory = ProductCategory.builder();

        productCategory.name( productCategoryDTO.getName() );

        return productCategory.build();
    }
}
