package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.senla.model.ProductCatalog;
import org.senla.swagger.model.ProductCatalogDTO;
import org.senla.swagger.model.ProductCatalogCreationDTO;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductCatalogMapper {
    public ProductCatalogDTO toDto(ProductCatalog productCatalog);
    public ProductCatalog toCatalog(ProductCatalogCreationDTO productCatalogDTO);
}