package org.senla.api;


import org.senla.model.ProductCatalog;
import org.senla.model.dto.ProductCatalogDTO;
import org.senla.model.dto.ProductCatalogMapper;
import org.senla.service.ProductCatalogService;
import org.senla.service.impl.ProductCatalogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import jakarta.annotation.Generated;

import static java.util.stream.Collectors.toList;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-05T16:09:04.794912+03:00[Europe/Moscow]", comments = "Generator version: 7.5.0")
@RestController
@RequestMapping("${openapi.openAPI30.base-path:}")
public class CatalogApiController implements CatalogApi {

    private final NativeWebRequest request;
    private final ProductCatalogService productCatalogService;
    private final ProductCatalogMapper productCatalogMapper;

    @Autowired
    public CatalogApiController(NativeWebRequest request, ProductCatalogServiceImpl productCatalogService, ProductCatalogMapper productCatalogMapper) {
        this.request = request;
        this.productCatalogService = productCatalogService;
        this.productCatalogMapper = productCatalogMapper;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    @PostMapping("/catalog")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCatalog(@RequestBody ProductCatalogDTO productCatalogDTO) {
        ProductCatalog productCatalog = productCatalogMapper.toCatalog(productCatalogDTO);
        productCatalogService.save(productCatalog);
    }

    @Override
    @GetMapping("/catalog")
    public List<ProductCatalogDTO> allCatalog() {
        return productCatalogService.getAll()
                .stream()
                .map(productCatalogMapper::toDto)
                .collect(toList());
    }

    @Override
    @GetMapping("/catalog/{id_shop}")
    public Optional<ProductCatalogDTO> getCatalogByIdShop(@PathVariable Long idShop) {
        return productCatalogService.getById(idShop).map(productCatalogMapper::toDto);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/catalog/{id_shop}")
    public void removeCatalogByIdShop(@PathVariable Long idShop) {
        productCatalogService.remove(idShop);
    }

    @Override
    @PatchMapping("/catalog/{id_shop}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCatalog(@RequestBody ProductCatalogDTO productCatalogDTO, @PathVariable Long idShop) {
        ProductCatalog productCatalog = productCatalogMapper.toCatalog(productCatalogDTO);
        productCatalogService.update(productCatalog, idShop);
    }
}