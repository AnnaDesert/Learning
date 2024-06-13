package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.senla.model.ProductCatalog;
import org.senla.model.dto.ProductCatalogCreationDTO;
import org.senla.model.dto.ProductCatalogDTO;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductCatalogMapper {
    public ProductCatalogDTO toDto(ProductCatalog productCatalog);
    public ProductCatalog toCatalog(ProductCatalogCreationDTO productCatalogDTO);
}