package org.senla.model.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.senla.model.ProductCategory;
import org.senla.swagger.model.ProductCategoryCreationDTO;
import org.senla.swagger.model.ProductCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T09:46:27+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProductCategoryListMapperImpl implements ProductCategoryListMapper {

    private final ProductCategoryMapper productCategoryMapper;

    @Autowired
    public ProductCategoryListMapperImpl(ProductCategoryMapper productCategoryMapper) {

        this.productCategoryMapper = productCategoryMapper;
    }

    @Override
    public List<ProductCategoryDTO> toDtoList(List<ProductCategory> productCategory) {
        if ( productCategory == null ) {
            return null;
        }

        List<ProductCategoryDTO> list = new ArrayList<ProductCategoryDTO>( productCategory.size() );
        for ( ProductCategory productCategory1 : productCategory ) {
            list.add( productCategoryMapper.toDto( productCategory1 ) );
        }

        return list;
    }

    @Override
    public List<ProductCategory> toProductCategoryList(List<ProductCategoryCreationDTO> productCategoryDTO) {
        if ( productCategoryDTO == null ) {
            return null;
        }

        List<ProductCategory> list = new ArrayList<ProductCategory>( productCategoryDTO.size() );
        for ( ProductCategoryCreationDTO productCategoryCreationDTO : productCategoryDTO ) {
            list.add( productCategoryMapper.toProductCategory( productCategoryCreationDTO ) );
        }

        return list;
    }
}
