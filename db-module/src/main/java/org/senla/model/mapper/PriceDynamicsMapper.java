package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.senla.model.PriceDynamics;
import org.senla.swagger.model.PriceDynamicsResponseDTO;

// PriceDynamicsRequestDTO PriceDynamicsResponseDTO

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PriceDynamicsMapper {
    public PriceDynamicsResponseDTO toDto(PriceDynamics priceDynamics);
    public PriceDynamics toPriceDynamics(PriceDynamicsResponseDTO priceDynamicsResponseDTO);
}
