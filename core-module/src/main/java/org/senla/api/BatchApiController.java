package org.senla.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.senla.model.BatchOfProduct;
import org.senla.model.mapper.BatchOfProductListMapper;
import org.senla.model.mapper.BatchOfProductMapper;
import org.senla.service.BatchOfProductService;
import org.senla.swagger.api.BatchApi;
import org.senla.swagger.model.BatchOfProductDTO;
import org.senla.swagger.model.BatchOfProductCreationDTO;
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
@Tag(name = "batch", description = "Запросы для batch_of_product")
@RequiredArgsConstructor
public class BatchApiController implements BatchApi {
    private final BatchOfProductService batchOfProductService;
    private final BatchOfProductMapper batchOfProductMapper;
    private final BatchOfProductListMapper batchOfProductListMapper;

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    //    @PostMapping("/batch")
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public ResponseEntity<Void> addBatch(@RequestBody BatchOfProductCreationDTO batchOfProductDTO) {
        BatchOfProduct batchOfProduct = batchOfProductMapper.toBatchOfProduct(batchOfProductDTO);
        batchOfProductService.save(batchOfProduct);
        return null;
    }
    
//    @GetMapping("/batch")
    @Override
    public ResponseEntity<List<BatchOfProductDTO>> allBatch() {
        return ResponseEntity.ok(batchOfProductListMapper.toDtoList(batchOfProductService.getAll()));
    }

    @Override
//    @GetMapping("/batch/{id}")
    public ResponseEntity<BatchOfProductDTO> getBatchById(@PathVariable @Min(1) Long id) {
        return ResponseEntity.ok(batchOfProductMapper.toDto(batchOfProductService.getById(id)));
    }

    @Override
//    @GetMapping("/batch/productCategory/{productCategory}")
    public ResponseEntity<List<BatchOfProductDTO>> getBatchByProductCategory(@PathVariable String productCategory) {
        return ResponseEntity.ok(batchOfProductListMapper.toDtoList(batchOfProductService.findByProductCategory(productCategory)));
    }

    @Override
//    @DeleteMapping("/batch/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> removeBatchById(@PathVariable @Min(1) Long id) {
        batchOfProductService.remove(id);
        return null;
    }

    //    @PatchMapping("/batch/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public ResponseEntity<Void> updateBatch(@PathVariable @Min(1) Long id,
            @RequestBody BatchOfProductCreationDTO batchOfProductDTO

    ) {
        BatchOfProduct batchOfProduct = batchOfProductMapper.toBatchOfProduct(batchOfProductDTO);
        batchOfProductService.update(batchOfProduct, id);
        return null;
    }
}