package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.senla.model.ProductCatalog;
import org.senla.swagger.model.ProductCatalogCreationDTO;
import org.senla.swagger.model.ProductCatalogDTO;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductCatalogMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductCatalogListMapper {
    public List<ProductCatalogDTO> toDtoList(List<ProductCatalog> productCatalog);
    public List<ProductCatalog> toCatalogList(List<ProductCatalogCreationDTO> productCatalogDTO);
}
