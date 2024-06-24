//package org.senla.model.mapper;
//
//import org.mapstruct.InjectionStrategy;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.senla.model.PriceDynamics;
//import org.senla.model.dto.PriceDynamicsDTO;
//
//@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
//public interface PriceDynamicsMapper {
//    public PriceDynamicsDTO toDto(PriceDynamics priceDynamics);
//    @Mapping(target = "idShop", expression = "java(priceDynamicsDTO.getIdShop())")
//    @Mapping(target = "idBatch", expression = "java(priceDynamicsDTO.getIdBatch())")
//    public PriceDynamics toPriceDynamics(PriceDynamicsDTO priceDynamicsDTO);
//}