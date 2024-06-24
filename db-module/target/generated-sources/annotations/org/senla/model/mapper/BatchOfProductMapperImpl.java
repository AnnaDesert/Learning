package org.senla.model.mapper;

import javax.annotation.processing.Generated;
import org.senla.model.BatchOfProduct;
import org.senla.swagger.model.BatchOfProductCreationDTO;
import org.senla.swagger.model.BatchOfProductDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T09:46:27+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class BatchOfProductMapperImpl implements BatchOfProductMapper {

    @Override
    public BatchOfProductDTO toDto(BatchOfProduct batchOfProduct) {
        if ( batchOfProduct == null ) {
            return null;
        }

        BatchOfProductDTO batchOfProductDTO = new BatchOfProductDTO();

        batchOfProductDTO.setId( batchOfProduct.getId() );
        batchOfProductDTO.setExpirationDateStart( batchOfProduct.getExpirationDateStart() );
        batchOfProductDTO.setExpirationDateEnd( batchOfProduct.getExpirationDateEnd() );
        batchOfProductDTO.setCount( batchOfProduct.getCount() );

        return batchOfProductDTO;
    }

    @Override
    public BatchOfProduct toBatchOfProduct(BatchOfProductCreationDTO batchOfProductDTO) {
        if ( batchOfProductDTO == null ) {
            return null;
        }

        BatchOfProduct.BatchOfProductBuilder batchOfProduct = BatchOfProduct.builder();

        batchOfProduct.expirationDateStart( batchOfProductDTO.getExpirationDateStart() );
        batchOfProduct.expirationDateEnd( batchOfProductDTO.getExpirationDateEnd() );
        batchOfProduct.count( batchOfProductDTO.getCount() );

        return batchOfProduct.build();
    }
}
