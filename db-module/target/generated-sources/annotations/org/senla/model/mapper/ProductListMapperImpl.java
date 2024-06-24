package org.senla.model.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.senla.model.Product;
import org.senla.swagger.model.ProductCreationDTO;
import org.senla.swagger.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T09:46:27+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProductListMapperImpl implements ProductListMapper {

    private final ProductMapper productMapper;

    @Autowired
    public ProductListMapperImpl(ProductMapper productMapper) {

        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDTO> toDtoList(List<Product> product) {
        if ( product == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( product.size() );
        for ( Product product1 : product ) {
            list.add( productMapper.toDto( product1 ) );
        }

        return list;
    }

    @Override
    public List<Product> toProductList(List<ProductCreationDTO> productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productDTO.size() );
        for ( ProductCreationDTO productCreationDTO : productDTO ) {
            list.add( productMapper.toProduct( productCreationDTO ) );
        }

        return list;
    }
}
