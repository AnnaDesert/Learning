package org.senla.api;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.senla.model.ProductCatalog;
import org.senla.model.dto.ProductCatalogCreationDTO;
import org.senla.model.dto.ProductCatalogDTO;
import org.senla.model.mapper.ProductCatalogMapper;
import org.senla.service.ProductCatalogService;
import org.senla.service.impl.ProductCatalogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@Validated
@RequestMapping("/api/v1")
@Tag(name = "catalog", description = "Запросы для product_catalog")
public class CatalogApiController {
    private final ProductCatalogService productCatalogService;
    private final ProductCatalogMapper productCatalogMapper;

    @Autowired
    public CatalogApiController(ProductCatalogServiceImpl productCatalogService, ProductCatalogMapper productCatalogMapper) {
        this.productCatalogService = productCatalogService;
        this.productCatalogMapper = productCatalogMapper;
    }
    
    @PostMapping("/catalog")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCatalog(@RequestBody ProductCatalogCreationDTO productCatalogDTO) {
        ProductCatalog productCatalog = productCatalogMapper.toCatalog(productCatalogDTO);
        productCatalogService.save(productCatalog);
    }

    
    @GetMapping("/catalog")
    public List<ProductCatalogDTO> allCatalog() {
        return productCatalogService.getAll()
                .stream()
                .map(productCatalogMapper::toDto)
                .collect(toList());
    }

    
    @GetMapping("/catalog/{id}")
    public Optional<ProductCatalogDTO> getCatalogByIdShop(@PathVariable @Min(1) Long id) {
        return productCatalogService.getById(id).map(productCatalogMapper::toDto);
    }

    @GetMapping("/catalog/compareByPrice/{id}")
    public List<ProductCatalogDTO> comparePrices(@PathVariable @Min(1) Long id) {
        return productCatalogService.comparePrices(id)
                .stream()
                .map(productCatalogMapper::toDto)
                .collect(toList());
    }
    
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/catalog/{id}")
    public void removeCatalogByIdShop(@PathVariable @Min(1) Long id) {
        productCatalogService.remove(id);
    }

    
    @PatchMapping("/catalog/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCatalog(
            @RequestBody ProductCatalogCreationDTO productCatalogDTO,
            @PathVariable @Min(1) Long id) {
        ProductCatalog productCatalog = productCatalogMapper.toCatalog(productCatalogDTO);
        productCatalogService.update(productCatalog, id);
    }
}