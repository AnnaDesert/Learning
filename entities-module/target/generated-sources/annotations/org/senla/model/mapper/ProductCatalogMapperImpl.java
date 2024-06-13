package org.senla.model.mapper;

import javax.annotation.processing.Generated;
import org.senla.model.ProductCatalog;
import org.senla.model.dto.ProductCatalogCreationDTO;
import org.senla.model.dto.ProductCatalogDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-13T17:37:49+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProductCatalogMapperImpl implements ProductCatalogMapper {

    @Override
    public ProductCatalogDTO toDto(ProductCatalog productCatalog) {
        if ( productCatalog == null ) {
            return null;
        }

        ProductCatalogDTO productCatalogDTO = new ProductCatalogDTO();

        productCatalogDTO.setId( productCatalog.getId() );
        productCatalogDTO.setIdShop( productCatalog.getIdShop() );
        productCatalogDTO.setIdBatch( productCatalog.getIdBatch() );
        productCatalogDTO.setCount( productCatalog.getCount() );
        productCatalogDTO.setPrice( productCatalog.getPrice() );
        productCatalogDTO.setDate( productCatalog.getDate() );

        return productCatalogDTO;
    }

    @Override
    public ProductCatalog toCatalog(ProductCatalogCreationDTO productCatalogDTO) {
        if ( productCatalogDTO == null ) {
            return null;
        }

        ProductCatalog.ProductCatalogBuilder productCatalog = ProductCatalog.builder();

        productCatalog.idShop( productCatalogDTO.getIdShop() );
        productCatalog.idBatch( productCatalogDTO.getIdBatch() );
        productCatalog.count( productCatalogDTO.getCount() );
        productCatalog.price( productCatalogDTO.getPrice() );
        productCatalog.date( productCatalogDTO.getDate() );

        return productCatalog.build();
    }
}
