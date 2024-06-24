package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.senla.model.BatchOfProduct;
import org.senla.swagger.model.BatchOfProductCreationDTO;
import org.senla.swagger.model.BatchOfProductDTO;

import java.util.List;

@Mapper(componentModel = "spring", uses = BatchOfProductMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BatchOfProductListMapper {
    public List<BatchOfProductDTO> toDtoList(List<BatchOfProduct> batchOfProduct);
    public List<BatchOfProduct> toBatchOfProductList(List<BatchOfProductCreationDTO> batchOfProductDTO);
}
