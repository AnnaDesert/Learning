package org.senla.model.mapper;

import javax.annotation.processing.Generated;
import org.senla.model.Shop;
import org.senla.swagger.model.ShopCreationDTO;
import org.senla.swagger.model.ShopDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T09:46:27+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ShopMapperImpl implements ShopMapper {

    @Override
    public ShopDTO toDto(Shop shop) {
        if ( shop == null ) {
            return null;
        }

        ShopDTO shopDTO = new ShopDTO();

        shopDTO.setId( shop.getId() );
        shopDTO.setName( shop.getName() );
        shopDTO.setAddress( shop.getAddress() );
        shopDTO.setIdAdmin( shop.getIdAdmin() );

        return shopDTO;
    }

    @Override
    public Shop toShop(ShopCreationDTO shopDTO) {
        if ( shopDTO == null ) {
            return null;
        }

        Shop.ShopBuilder shop = Shop.builder();

        shop.name( shopDTO.getName() );
        shop.address( shopDTO.getAddress() );
        shop.idAdmin( shopDTO.getIdAdmin() );

        return shop.build();
    }
}
