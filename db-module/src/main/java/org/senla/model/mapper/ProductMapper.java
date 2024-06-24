package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.senla.model.Product;
import org.senla.swagger.model.ProductDTO;
import org.senla.swagger.model.ProductCreationDTO;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapper {
    public ProductDTO toDto(Product product);
    public Product toProduct(ProductCreationDTO productDTO);
}