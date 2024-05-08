package org.senla.model.dto;

import org.senla.model.Shop;
import org.springframework.stereotype.Component;

@Component
public class ShopMapper {
    public ShopDTO toDto(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setName(shop.getName());
        shopDTO.setAddress(shop.getAddress());
        shopDTO.setIdAdmin(shop.getIdAdmin());
        return shopDTO;
    }
    public Shop toShop(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setName(shopDTO.getName());
        shop.setAddress(shopDTO.getAddress());
        shop.setIdAdmin(shopDTO.getIdAdmin());
        return shop;
    }
}