package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.senla.model.Shop;
import org.senla.model.dto.ShopCreationDTO;
import org.senla.model.dto.ShopDTO;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ShopMapper {
    public ShopDTO toDto(Shop shop);
    public Shop toShop(ShopCreationDTO shopDTO);
}