package org.senla.api;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.senla.model.Product;
import org.senla.model.dto.ProductCreationDTO;
import org.senla.model.dto.ProductDTO;
import org.senla.model.mapper.ProductMapper;
import org.senla.service.ProductService;
import org.senla.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;
@RestController
@Validated
@RequestMapping("/api/v1")
@Tag(name = "product", description = "Запросы для product")
@RequiredArgsConstructor
public class ProductApiController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductCreationDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        productService.save(product);
    }

    @PostMapping("/product/{fileName}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProductCSV(@PathVariable String fileName) throws IOException {
        productService.saveCSV(new String(Base64.encodeBase64(fileName.getBytes())));
    }
    
    @GetMapping("/product")
    public List<ProductDTO> allProducts() {
        return productService.getAll()

                .stream()

                .map(productMapper::toDto)

                .collect(toList());
    }

    
    @GetMapping("/product/{id}")
    public ProductDTO getProductById(@PathVariable @Min(1) Long id) {
            return productService.getById(id).map(productMapper::toDto).get();
    }

    
    @GetMapping("/product/name/{name}")
    public List<ProductDTO> getProductByName(@PathVariable String name) {
        return productService.getByName(name)

                .stream()

                .map(productMapper::toDto)

                .collect(toList());
    }

    
    @DeleteMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeProductById(@PathVariable @Min(1) Long id) {
        productService.remove(id);
    }

    
    @PatchMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(
            @RequestBody ProductCreationDTO productDTO,
            @PathVariable @Min(1) Long id) {
        Product product = productMapper.toProduct(productDTO);
        productService.update(product, id);
    }

    @GetMapping("/product/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> findByCategory(@PathVariable String category) {
        return productService.findByCategory(category)

                .stream()

                .map(productMapper::toDto)

                .collect(toList());
    }
}
