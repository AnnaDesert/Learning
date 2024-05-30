package org.senla.api;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.senla.model.ProductCategory;
import org.senla.model.dto.ProductCategoryCreationDTO;
import org.senla.model.dto.ProductCategoryDTO;
import org.senla.model.mapper.ProductCategoryMapper;
import org.senla.service.ProductCategoryService;
import org.senla.service.impl.ProductCategoryServiceImpl;
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
@Tag(name = "category", description = "Запросы для product_category")
public class CategoryApiController {
    private final ProductCategoryService productCategoryService;
    private final ProductCategoryMapper productCategoryMapper;

    @Autowired
    public CategoryApiController(ProductCategoryServiceImpl productCategoryService, ProductCategoryMapper productCategoryMapper) {
        this.productCategoryService = productCategoryService;
        this.productCategoryMapper = productCategoryMapper;
    }

    @PostMapping("/category")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCategory(@RequestBody ProductCategoryCreationDTO productCategoryDTO) {
        ProductCategory productCategory = productCategoryMapper.toProductCategory(productCategoryDTO);
        productCategoryService.save(productCategory);
    }

    
    @GetMapping("/category")
    public List<ProductCategoryDTO> allCategory() {
        return productCategoryService.getAll()
                .stream()
                .map(productCategoryMapper::toDto)
                .collect(toList());
    }

    
    @GetMapping("/category/{id}")
    public Optional<ProductCategoryDTO> getCategoryById(@PathVariable @Min(1) Long id) {
        return productCategoryService.getById(id).map(productCategoryMapper::toDto);
    }

    
    @GetMapping("/category/name/{name}")
    public Optional<ProductCategoryDTO> getCategoryByName(@PathVariable String name) {
        return productCategoryService.getByName(name).map(productCategoryMapper::toDto);
    }

    
    @DeleteMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeCategoryById(@PathVariable @Min(1) Long id) {
        productCategoryService.remove(id);
    }

    
    @PatchMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCategory(
            @RequestBody ProductCategoryCreationDTO productCategoryDTO,
            @PathVariable @Min(1) Long id) {
        ProductCategory productCategory = productCategoryMapper.toProductCategory(productCategoryDTO);
        productCategoryService.update(productCategory, id);
    }
}