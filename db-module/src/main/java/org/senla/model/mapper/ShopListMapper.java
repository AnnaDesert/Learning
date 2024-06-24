package org.senla.model.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.senla.model.Shop;
import org.senla.swagger.model.ShopCreationDTO;
import org.senla.swagger.model.ShopDTO;

import java.util.List;

@Mapper(componentModel = "spring", uses = ShopMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ShopListMapper {
    public List<ShopDTO> toDtoList(List<Shop> shop);
    public List<Shop> toShopList(List<ShopCreationDTO> shopDTO);
}
