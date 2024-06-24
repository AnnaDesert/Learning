package org.senla.model.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.senla.model.PriceDynamics;
import org.senla.swagger.model.PriceDynamicsResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T09:46:27+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PriceDynamicsListMapperImpl implements PriceDynamicsListMapper {

    private final PriceDynamicsMapper priceDynamicsMapper;

    @Autowired
    public PriceDynamicsListMapperImpl(PriceDynamicsMapper priceDynamicsMapper) {

        this.priceDynamicsMapper = priceDynamicsMapper;
    }

    @Override
    public List<PriceDynamicsResponseDTO> toDtoList(List<PriceDynamics> priceDynamics) {
        if ( priceDynamics == null ) {
            return null;
        }

        List<PriceDynamicsResponseDTO> list = new ArrayList<PriceDynamicsResponseDTO>( priceDynamics.size() );
        for ( PriceDynamics priceDynamics1 : priceDynamics ) {
            list.add( priceDynamicsMapper.toDto( priceDynamics1 ) );
        }

        return list;
    }

    @Override
    public List<PriceDynamics> toPriceDynamicsList(List<PriceDynamicsResponseDTO> priceDynamicsResponseDTO) {
        if ( priceDynamicsResponseDTO == null ) {
            return null;
        }

        List<PriceDynamics> list = new ArrayList<PriceDynamics>( priceDynamicsResponseDTO.size() );
        for ( PriceDynamicsResponseDTO priceDynamicsResponseDTO1 : priceDynamicsResponseDTO ) {
            list.add( priceDynamicsMapper.toPriceDynamics( priceDynamicsResponseDTO1 ) );
        }

        return list;
    }
}
