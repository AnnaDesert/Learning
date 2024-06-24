package org.senla.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.senla.model.Product;
import org.senla.model.mapper.ProductListMapper;
import org.senla.swagger.model.ProductCreationDTO;
import org.senla.swagger.model.ProductDTO;
import org.senla.model.mapper.ProductMapper;
import org.senla.service.ProductService;
import org.senla.swagger.api.ProductApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
@RestController
@Validated
@RequestMapping("/api/v1")
@Tag(name = "product", description = "Запросы для product")
@RequiredArgsConstructor
public class ProductApiController implements ProductApi {
    private final ProductService productService;
    private final ProductMapper productMapper;
    private final ProductListMapper productListMapper;

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    //    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ResponseEntity<Void> addProduct(@RequestBody ProductCreationDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        productService.save(product);
        return null;
    }

//    @PostMapping("/product/{fileName}")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ResponseEntity<Void> addProductFromCSV(@PathVariable String fileName) {
        productService.saveCSV(new String(Base64.encodeBase64(fileName.getBytes())));
        return null;
    }
    
//    @GetMapping("/product")
    @Override
    public ResponseEntity<List<ProductDTO>> allProducts() {
        return ResponseEntity.ok(productListMapper.toDtoList(productService.getAll()));
    }

//    @GetMapping("/product/{id}")
    @Override
    public ResponseEntity<ProductDTO> getProductById(@PathVariable @Min(1) Long id) {
        return ResponseEntity.ok(productMapper.toDto(productService.getById(id).get()));
    }
    
//    @GetMapping("/product/name/{name}")
    @Override
    public ResponseEntity<List<ProductDTO>> getProductByName(@PathVariable String name) {
        return ResponseEntity.ok(productListMapper.toDtoList(productService.getByName(name)));
    }

//    @DeleteMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public ResponseEntity<Void> removeProductById(@PathVariable @Min(1) Long id) {
        productService.remove(id);
        return null;
    }
    
//    @PatchMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public ResponseEntity<Void> updateProduct(
            @PathVariable @Min(1) Long id,
            @RequestBody ProductCreationDTO productDTO
            ) {
        Product product = productMapper.toProduct(productDTO);
        productService.update(product, id);
        return null;
    }

//    @GetMapping("/product/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public ResponseEntity<List<ProductDTO>> getProductByCategory(@PathVariable String category) {
        return ResponseEntity.ok(productListMapper.toDtoList(productService.findByCategory(category)));
    }
}