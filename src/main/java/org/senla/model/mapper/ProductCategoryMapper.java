package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.senla.model.ProductCategory;
import org.senla.model.dto.ProductCategoryCreationDTO;
import org.senla.model.dto.ProductCategoryDTO;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductCategoryMapper {
    public ProductCategoryDTO toDto(ProductCategory productCategory);
    public ProductCategory toProductCategory(ProductCategoryCreationDTO productCategoryDTO);
}