package org.senla.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.senla.model.ProductCategory;
import org.senla.model.mapper.ProductCategoryListMapper;
import org.senla.swagger.model.ProductCategoryCreationDTO;
import org.senla.swagger.model.ProductCategoryDTO;
import org.senla.model.mapper.ProductCategoryMapper;
import org.senla.service.ProductCategoryService;
import org.senla.swagger.api.CategoryApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/api/v1")
@Tag(name = "category", description = "Запросы для product_category")
@RequiredArgsConstructor
public class CategoryApiController implements CategoryApi {
    private final ProductCategoryService productCategoryService;
    private final ProductCategoryMapper productCategoryMapper;
    private final ProductCategoryListMapper productCategoryListMapper;

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    //    @PostMapping("/category")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ResponseEntity<Void> addCategory(@RequestBody ProductCategoryCreationDTO productCategoryDTO) {
        ProductCategory productCategory = productCategoryMapper.toProductCategory(productCategoryDTO);
        productCategoryService.save(productCategory);
        return null;
    }
    
//    @GetMapping("/category")
    @Override
    public ResponseEntity<List<ProductCategoryDTO>> allCategory() {
        return ResponseEntity.ok(productCategoryListMapper.toDtoList(productCategoryService.getAll()));
    }

//    @GetMapping("/category/{id}")
    public ResponseEntity<ProductCategoryDTO> getCategoryById(@PathVariable @Min(1) Long id) {
        return ResponseEntity.ok(productCategoryMapper.toDto(productCategoryService.getById(id).get()));
    }
    
//    @GetMapping("/category/name/{name}")
    @Override
    public ResponseEntity<ProductCategoryDTO> getCategoryByName(@PathVariable String name) {
        return ResponseEntity.ok(productCategoryMapper.toDto(productCategoryService.getByName(name).get()));
    }

//    @DeleteMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public ResponseEntity<Void> removeCategoryById(@PathVariable @Min(1) Long id) {
        productCategoryService.remove(id);
        return null;
    }
    
//    @PatchMapping("/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public ResponseEntity<Void> updateCategory(
            @PathVariable @Min(1) Long id,
            @RequestBody ProductCategoryCreationDTO productCategoryDTO
    ) {
        ProductCategory productCategory = productCategoryMapper.toProductCategory(productCategoryDTO);
        productCategoryService.update(productCategory, id);
        return null;
    }
}