package org.senla.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.senla.model.ProductCatalog;
import org.senla.model.mapper.ProductCatalogListMapper;
import org.senla.swagger.model.ProductCatalogCreationDTO;
import org.senla.swagger.model.ProductCatalogDTO;
import org.senla.model.mapper.ProductCatalogMapper;
import org.senla.service.ProductCatalogService;
import org.senla.swagger.api.CatalogApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@Validated
@RequestMapping("/api/v1")
@Tag(name = "catalog", description = "Запросы для product_catalog")
@RequiredArgsConstructor
public class CatalogApiController implements CatalogApi {
    private final ProductCatalogService productCatalogService;
    private final ProductCatalogMapper productCatalogMapper;
    private final ProductCatalogListMapper productCatalogListMapper;

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    //    @PostMapping("/catalog")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ResponseEntity<Void> addCatalog(@RequestBody ProductCatalogCreationDTO productCatalogDTO) {
        ProductCatalog productCatalog = productCatalogMapper.toCatalog(productCatalogDTO);
        productCatalogService.save(productCatalog);
        return null;
    }

    
//    @GetMapping("/catalog")
    @Override
    public ResponseEntity<List<ProductCatalogDTO>> allCatalog() {
        return ResponseEntity.ok(productCatalogListMapper.toDtoList(productCatalogService.getAll()));
    }

    
//    @GetMapping("/catalog/{id}")
    @Override
    public ResponseEntity<ProductCatalogDTO> getCatalogByIdShop(@PathVariable @Min(1) Long id) {
        return ResponseEntity.ok(productCatalogMapper.toDto(productCatalogService.getById(id).get()));
    }

//    @GetMapping("/catalog/compareByPrice/{id}")
    @Override
    public ResponseEntity<List<ProductCatalogDTO>> comparePrices(@PathVariable @Min(1) Long id) {
        return ResponseEntity.ok(productCatalogListMapper.toDtoList(productCatalogService.comparePrices(id)));
    }
    
    @ResponseStatus(HttpStatus.OK)
//    @DeleteMapping("/catalog/{id}")
    @Override
    public ResponseEntity<Void> removeCatalogByIdShop(@PathVariable @Min(1) Long id) {
        productCatalogService.remove(id);
        return null;
    }

    
//    @PatchMapping("/catalog/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public ResponseEntity<Void> updateCatalog(
            @PathVariable @Min(1) Long id,
            @RequestBody ProductCatalogCreationDTO productCatalogDTO)
    {
        ProductCatalog productCatalog = productCatalogMapper.toCatalog(productCatalogDTO);
        productCatalogService.update(productCatalog, id);
        return null;
    }
}