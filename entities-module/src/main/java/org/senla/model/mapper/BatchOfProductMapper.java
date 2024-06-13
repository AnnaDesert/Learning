package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.senla.model.BatchOfProduct;
import org.senla.model.dto.BatchOfProductCreationDTO;
import org.senla.model.dto.BatchOfProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
//public abstract class BatchOfProductMapper {
//    @Autowired
//    protected ProductMapper productMapper;
//    @Mappings({
//            @Mapping(target = "idProduct", expression = "java(batchOfProduct.getIdProduct())"),
//            @Mapping(target = "product", expression = "java(productMapper.toDto(batchOfProduct.getProduct()))")
//    })
//    public abstract BatchOfProductDTO toDto(BatchOfProduct batchOfProduct);
//    public abstract BatchOfProduct toBatchOfProduct(BatchOfProductCreationDTO batchOfProductDTO);
//}
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BatchOfProductMapper {
    public BatchOfProductDTO toDto(BatchOfProduct batchOfProduct);
    public BatchOfProduct toBatchOfProduct(BatchOfProductCreationDTO batchOfProductDTO);
}