package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.senla.model.BatchOfProduct;
import org.senla.swagger.model.BatchOfProductDTO;
import org.senla.swagger.model.BatchOfProductCreationDTO;

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