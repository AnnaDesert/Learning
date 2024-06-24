package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.senla.model.Product;
import org.senla.swagger.model.ProductCreationDTO;
import org.senla.swagger.model.ProductDTO;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductListMapper {
    public List<ProductDTO> toDtoList(List<Product> product);
    public List<Product> toProductList(List<ProductCreationDTO> productDTO);
}
