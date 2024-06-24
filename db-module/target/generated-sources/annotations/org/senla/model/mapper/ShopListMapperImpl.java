package org.senla.model.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.senla.model.Shop;
import org.senla.swagger.model.ShopCreationDTO;
import org.senla.swagger.model.ShopDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T09:46:27+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ShopListMapperImpl implements ShopListMapper {

    private final ShopMapper shopMapper;

    @Autowired
    public ShopListMapperImpl(ShopMapper shopMapper) {

        this.shopMapper = shopMapper;
    }

    @Override
    public List<ShopDTO> toDtoList(List<Shop> shop) {
        if ( shop == null ) {
            return null;
        }

        List<ShopDTO> list = new ArrayList<ShopDTO>( shop.size() );
        for ( Shop shop1 : shop ) {
            list.add( shopMapper.toDto( shop1 ) );
        }

        return list;
    }

    @Override
    public List<Shop> toShopList(List<ShopCreationDTO> shopDTO) {
        if ( shopDTO == null ) {
            return null;
        }

        List<Shop> list = new ArrayList<Shop>( shopDTO.size() );
        for ( ShopCreationDTO shopCreationDTO : shopDTO ) {
            list.add( shopMapper.toShop( shopCreationDTO ) );
        }

        return list;
    }
}
