package org.senla.api;


import org.senla.model.Product;
import org.senla.model.dto.ProductDTO;
import org.senla.model.dto.ProductMapper;
import org.senla.service.ProductService;
import org.senla.service.impl.ProductServiceImpl;
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
public class ProductApiController implements ProductApi {

    private final NativeWebRequest request;
    private final ProductService productService;
    private final ProductMapper productMapper;
    @Autowired
    public ProductApiController(NativeWebRequest request, ProductServiceImpl productService, ProductMapper productMapper) {
        this.request = request;
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        productService.save(product);
    }

    @Override
    @GetMapping("/product")
    public List<ProductDTO> allProducts() {
        return productService.getAll()
                .stream()
                .map(productMapper::toDto)
                .collect(toList());
    }

    @Override
    @GetMapping("/product/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
            return productService.getById(id).map(productMapper::toDto).get();
    }

    @Override
    @GetMapping("/product/name/{name}")
    public List<ProductDTO> getProductByName(@PathVariable String name) {
        return productService.getByName(name)
                .stream()
                .map(productMapper::toDto)
                .collect(toList());
    }

    @Override
    @DeleteMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeProductById(@PathVariable() Long id) {
        productService.remove(id);
    }

    @Override
    @PatchMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@RequestBody ProductDTO productDTO, @PathVariable Long id) {
        Product product = productMapper.toProduct(productDTO);
        productService.update(product, id);
    }
}
