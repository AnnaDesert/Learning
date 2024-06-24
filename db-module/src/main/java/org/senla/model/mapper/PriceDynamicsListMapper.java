package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.senla.model.PriceDynamics;
import org.senla.swagger.model.PriceDynamicsResponseDTO;

import java.util.List;

@Mapper(componentModel = "spring", uses = PriceDynamicsMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PriceDynamicsListMapper {
    public List<PriceDynamicsResponseDTO> toDtoList(List<PriceDynamics> priceDynamics);
    public List<PriceDynamics> toPriceDynamicsList(List<PriceDynamicsResponseDTO> priceDynamicsResponseDTO);
}
