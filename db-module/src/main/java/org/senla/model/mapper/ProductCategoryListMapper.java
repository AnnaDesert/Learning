package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.senla.model.ProductCategory;
import org.senla.swagger.model.ProductCategoryCreationDTO;
import org.senla.swagger.model.ProductCategoryDTO;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductCategoryMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductCategoryListMapper {
    public List<ProductCategoryDTO> toDtoList(List<ProductCategory> productCategory);
    public List<ProductCategory> toProductCategoryList(List<ProductCategoryCreationDTO> productCategoryDTO);
}
