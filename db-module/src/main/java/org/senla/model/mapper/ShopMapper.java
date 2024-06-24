package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.senla.model.Shop;
import org.senla.swagger.model.ShopCreationDTO;
import org.senla.swagger.model.ShopDTO;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ShopMapper {
    public ShopDTO toDto(Shop shop);
    public Shop toShop(ShopCreationDTO shopDTO);
}