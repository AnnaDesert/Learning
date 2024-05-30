package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.senla.model.Product;
import org.senla.model.dto.ProductCreationDTO;
import org.senla.model.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductMapper {
    public ProductDTO toDto(Product product);
    public Product toProduct(ProductCreationDTO productDTO);
}