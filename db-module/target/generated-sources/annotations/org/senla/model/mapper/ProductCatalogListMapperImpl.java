package org.senla.model.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.senla.model.ProductCatalog;
import org.senla.swagger.model.ProductCatalogCreationDTO;
import org.senla.swagger.model.ProductCatalogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T09:46:27+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProductCatalogListMapperImpl implements ProductCatalogListMapper {

    private final ProductCatalogMapper productCatalogMapper;

    @Autowired
    public ProductCatalogListMapperImpl(ProductCatalogMapper productCatalogMapper) {

        this.productCatalogMapper = productCatalogMapper;
    }

    @Override
    public List<ProductCatalogDTO> toDtoList(List<ProductCatalog> productCatalog) {
        if ( productCatalog == null ) {
            return null;
        }

        List<ProductCatalogDTO> list = new ArrayList<ProductCatalogDTO>( productCatalog.size() );
        for ( ProductCatalog productCatalog1 : productCatalog ) {
            list.add( productCatalogMapper.toDto( productCatalog1 ) );
        }

        return list;
    }

    @Override
    public List<ProductCatalog> toCatalogList(List<ProductCatalogCreationDTO> productCatalogDTO) {
        if ( productCatalogDTO == null ) {
            return null;
        }

        List<ProductCatalog> list = new ArrayList<ProductCatalog>( productCatalogDTO.size() );
        for ( ProductCatalogCreationDTO productCatalogCreationDTO : productCatalogDTO ) {
            list.add( productCatalogMapper.toCatalog( productCatalogCreationDTO ) );
        }

        return list;
    }
}
