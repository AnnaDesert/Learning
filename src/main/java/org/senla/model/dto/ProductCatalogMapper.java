package org.senla.model.dto;

import org.senla.model.ProductCatalog;
import org.springframework.stereotype.Component;

@Component
public class ProductCatalogMapper {
    public ProductCatalogDTO toDto(ProductCatalog productCatalog) {
        ProductCatalogDTO productCatalogDTO = new ProductCatalogDTO();
        productCatalogDTO.setCount(productCatalog.getCount());
        productCatalogDTO.setPrice(productCatalog.getPrice());
        productCatalogDTO.setIdBatch(productCatalog.getIdBatch());
        return productCatalogDTO;
    }
    public ProductCatalog toCatalog(ProductCatalogDTO productCatalogDTO) {
        ProductCatalog productCatalog = new ProductCatalog();
        productCatalog.setCount(productCatalogDTO.getCount());
        productCatalog.setPrice(productCatalogDTO.getPrice());
        productCatalog.setIdBatch(productCatalogDTO.getIdBatch());
        return productCatalog;
    }
}