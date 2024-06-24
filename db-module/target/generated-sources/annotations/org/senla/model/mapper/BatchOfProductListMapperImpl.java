package org.senla.model.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.senla.model.BatchOfProduct;
import org.senla.swagger.model.BatchOfProductCreationDTO;
import org.senla.swagger.model.BatchOfProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T09:46:27+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class BatchOfProductListMapperImpl implements BatchOfProductListMapper {

    private final BatchOfProductMapper batchOfProductMapper;

    @Autowired
    public BatchOfProductListMapperImpl(BatchOfProductMapper batchOfProductMapper) {

        this.batchOfProductMapper = batchOfProductMapper;
    }

    @Override
    public List<BatchOfProductDTO> toDtoList(List<BatchOfProduct> batchOfProduct) {
        if ( batchOfProduct == null ) {
            return null;
        }

        List<BatchOfProductDTO> list = new ArrayList<BatchOfProductDTO>( batchOfProduct.size() );
        for ( BatchOfProduct batchOfProduct1 : batchOfProduct ) {
            list.add( batchOfProductMapper.toDto( batchOfProduct1 ) );
        }

        return list;
    }

    @Override
    public List<BatchOfProduct> toBatchOfProductList(List<BatchOfProductCreationDTO> batchOfProductDTO) {
        if ( batchOfProductDTO == null ) {
            return null;
        }

        List<BatchOfProduct> list = new ArrayList<BatchOfProduct>( batchOfProductDTO.size() );
        for ( BatchOfProductCreationDTO batchOfProductCreationDTO : batchOfProductDTO ) {
            list.add( batchOfProductMapper.toBatchOfProduct( batchOfProductCreationDTO ) );
        }

        return list;
    }
}
