package org.senla.model.mapper;

import javax.annotation.processing.Generated;
import org.senla.model.PriceDynamics;
import org.senla.swagger.model.PriceDynamicsResponseDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T09:46:27+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PriceDynamicsMapperImpl implements PriceDynamicsMapper {

    @Override
    public PriceDynamicsResponseDTO toDto(PriceDynamics priceDynamics) {
        if ( priceDynamics == null ) {
            return null;
        }

        PriceDynamicsResponseDTO priceDynamicsResponseDTO = new PriceDynamicsResponseDTO();

        priceDynamicsResponseDTO.setDate( priceDynamics.getDate() );
        priceDynamicsResponseDTO.setPrice( priceDynamics.getPrice() );

        return priceDynamicsResponseDTO;
    }

    @Override
    public PriceDynamics toPriceDynamics(PriceDynamicsResponseDTO priceDynamicsResponseDTO) {
        if ( priceDynamicsResponseDTO == null ) {
            return null;
        }

        PriceDynamics.PriceDynamicsBuilder priceDynamics = PriceDynamics.builder();

        priceDynamics.price( priceDynamicsResponseDTO.getPrice() );
        priceDynamics.date( priceDynamicsResponseDTO.getDate() );

        return priceDynamics.build();
    }
}
