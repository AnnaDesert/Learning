package org.senla.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import org.senla.model.BatchOfProduct;
import org.senla.model.dto.BatchOfProductCreationDTO;
import org.senla.model.dto.BatchOfProductDTO;
import org.senla.model.mapper.BatchOfProductMapper;
import org.senla.service.BatchOfProductService;
import org.senla.service.impl.BatchOfProductServiceImpl;
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
@Tag(name = "batch", description = "Запросы для batch_of_product")
public class BatchApiController {
    private final BatchOfProductService batchOfProductService;
    private final BatchOfProductMapper batchOfProductMapper;
    @Autowired
    public BatchApiController(BatchOfProductServiceImpl batchOfProductService, BatchOfProductMapper batchOfProductMapper) {
        this.batchOfProductService = batchOfProductService;
        this.batchOfProductMapper = batchOfProductMapper;
    }

    @PostMapping("/batch")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBatch(@RequestBody BatchOfProductCreationDTO batchOfProductDTO) {
        BatchOfProduct batchOfProduct = batchOfProductMapper.toBatchOfProduct(batchOfProductDTO);
        batchOfProductService.save(batchOfProduct);
    }

    
    @GetMapping("/batch")
    public List<BatchOfProductDTO> allBatch() {
        return batchOfProductService.getAll()
                .stream()
                .map(batchOfProductMapper::toDto)
                .collect(toList());
    }

    
    @GetMapping("/batch/{id}")
    public Optional<BatchOfProductDTO> getBatchById(@PathVariable @Min(1) Long id) {
        return batchOfProductService.getById(id).map(batchOfProductMapper::toDto);
    }

    
    @DeleteMapping("/batch/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeBatchById(@PathVariable @Min(1) Long id) {
        batchOfProductService.remove(id);
    }

    
    @PatchMapping("/batch/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBatch(
            @RequestBody BatchOfProductCreationDTO batchOfProductDTO,
            @PathVariable @Min(1) Long id
    )
    {
        BatchOfProduct batchOfProduct = batchOfProductMapper.toBatchOfProduct(batchOfProductDTO);
        batchOfProductService.update(batchOfProduct, id);
    }
}
