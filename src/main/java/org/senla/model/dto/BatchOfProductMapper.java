package org.senla.model.dto;

import org.senla.model.BatchOfProduct;
import org.springframework.stereotype.Component;

@Component
public class BatchOfProductMapper {
    public BatchOfProductDTO toDto(BatchOfProduct batchOfProduct) {
        BatchOfProductDTO batchOfProductDTO = new BatchOfProductDTO();
        batchOfProductDTO.setIdProduct(batchOfProduct.getIdProduct());
        batchOfProductDTO.setCount(batchOfProduct.getCount());
        batchOfProductDTO.setExpirationDateEnd(batchOfProduct.getExpirationDateEnd());
        batchOfProductDTO.setExpirationDateStart(batchOfProduct.getExpirationDateStart());
        return batchOfProductDTO;
    }
    public BatchOfProduct toBatchOfProduct(BatchOfProductDTO batchOfProductDTO) {
        BatchOfProduct batchOfProduct = new BatchOfProduct();
        batchOfProduct.setIdProduct(batchOfProductDTO.getIdProduct());
        batchOfProduct.setCount(batchOfProductDTO.getCount());
        batchOfProduct.setExpirationDateEnd(batchOfProductDTO.getExpirationDateEnd());
        batchOfProduct.setExpirationDateStart(batchOfProductDTO.getExpirationDateStart());
        return batchOfProduct;
    }
}