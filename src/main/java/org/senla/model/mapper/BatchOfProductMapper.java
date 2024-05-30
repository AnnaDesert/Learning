package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.senla.model.BatchOfProduct;
import org.senla.model.dto.BatchOfProductCreationDTO;
import org.senla.model.dto.BatchOfProductDTO;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BatchOfProductMapper {
    public BatchOfProductDTO toDto(BatchOfProduct batchOfProduct);
    public BatchOfProduct toBatchOfProduct(BatchOfProductCreationDTO batchOfProductDTO);
}