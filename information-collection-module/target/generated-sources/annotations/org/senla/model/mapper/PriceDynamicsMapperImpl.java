package org.senla.model.mapper;

import javax.annotation.processing.Generated;
import org.senla.model.PriceDynamics;
import org.senla.model.dto.PriceDynamicsDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-13T17:37:59+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PriceDynamicsMapperImpl implements PriceDynamicsMapper {

    @Override
    public PriceDynamicsDTO toDto(PriceDynamics priceDynamics) {
        if ( priceDynamics == null ) {
            return null;
        }

        PriceDynamicsDTO.PriceDynamicsDTOBuilder priceDynamicsDTO = PriceDynamicsDTO.builder();

        priceDynamicsDTO.idShop( priceDynamics.getIdShop() );
        priceDynamicsDTO.idBatch( priceDynamics.getIdBatch() );
        priceDynamicsDTO.price( priceDynamics.getPrice() );
        priceDynamicsDTO.date( priceDynamics.getDate() );

        return priceDynamicsDTO.build();
    }

    @Override
    public PriceDynamics toPriceDynamics(PriceDynamicsDTO priceDynamicsDTO) {
        if ( priceDynamicsDTO == null ) {
            return null;
        }

        PriceDynamics.PriceDynamicsBuilder priceDynamics = PriceDynamics.builder();

        priceDynamics.price( priceDynamicsDTO.getPrice() );
        priceDynamics.date( priceDynamicsDTO.getDate() );

        priceDynamics.idShop( priceDynamicsDTO.getIdShop() );
        priceDynamics.idBatch( priceDynamicsDTO.getIdBatch() );

        return priceDynamics.build();
    }
}
