package org.senla.model.mapper;

import javax.annotation.processing.Generated;
import org.senla.model.ProductCatalog;
import org.senla.swagger.model.ProductCatalogCreationDTO;
import org.senla.swagger.model.ProductCatalogDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T09:46:27+0300",
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

        return productCatalog.build();
    }
}
