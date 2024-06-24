package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.senla.model.ProductCategory;
import org.senla.swagger.model.ProductCategoryCreationDTO;
import org.senla.swagger.model.ProductCategoryDTO;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductCategoryMapper {
    public ProductCategoryDTO toDto(ProductCategory productCategory);
    public ProductCategory toProductCategory(ProductCategoryCreationDTO productCategoryDTO);
}