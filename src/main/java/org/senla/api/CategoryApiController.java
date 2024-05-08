package org.senla.api;


import org.senla.model.ProductCategory;
import org.senla.model.dto.ProductCategoryDTO;
import org.senla.model.dto.ProductCategoryMapper;
import org.senla.service.ProductCategoryService;
import org.senla.service.impl.ProductCategoryServiceImpl;
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
public class CategoryApiController implements CategoryApi {

    private final NativeWebRequest request;
    private final ProductCategoryService productCategoryService;
    private final ProductCategoryMapper productCategoryMapper;

    @Autowired
    public CategoryApiController(NativeWebRequest request, ProductCategoryServiceImpl productCategoryService, ProductCategoryMapper productCategoryMapper) {
        this.request = request;
        this.productCategoryService = productCategoryService;
        this.productCategoryMapper = productCategoryMapper;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    @PostMapping("/category")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCategory(@RequestBody ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = productCategoryMapper.toProductCategory(productCategoryDTO);
        productCategoryService.save(productCategory);
    }

    @Override
    @GetMapping("/category")
    public List<ProductCategoryDTO> allCategory() {
        return productCategoryService.getAll()
                .stream()
                .map(productCategoryMapper::toDto)
                .collect(toList());
    }

    @Override
    @GetMapping("/category/{id}")
    public Optional<ProductCategoryDTO> getCategoryById(@PathVariable Long id) {
        return productCategoryService.getById(id).map(productCategoryMapper::toDto);
    }

    @Override
    @GetMapping("/category/name/{name}")
    public Optional<ProductCategoryDTO> getCategoryByName(@PathVariable String name) {
        return productCategoryService.getByName(name).map(productCategoryMapper::toDto);
    }

    @Override
    @DeleteMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeCategoryById(@PathVariable Long id) {
        productCategoryService.remove(id);
    }

    @Override
    @PatchMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCategory(@RequestBody ProductCategoryDTO productCategoryDTO, @PathVariable Long id) {
        ProductCategory productCategory = productCategoryMapper.toProductCategory(productCategoryDTO);
        productCategoryService.update(productCategory, id);
    }
}