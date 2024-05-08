package org.senla.api;

import org.senla.model.BatchOfProduct;
import org.senla.model.dto.BatchOfProductDTO;
import org.senla.model.dto.BatchOfProductMapper;
import org.senla.service.BatchOfProductService;
import org.senla.service.impl.BatchOfProductServiceImpl;
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
public class BatchApiController implements BatchApi {
    private final NativeWebRequest request;
    private final BatchOfProductService batchOfProductService;
    private final BatchOfProductMapper batchOfProductMapper;
    @Autowired
    public BatchApiController(NativeWebRequest request, BatchOfProductServiceImpl batchOfProductService, BatchOfProductMapper batchOfProductMapper) {
        this.request = request;
        this.batchOfProductService = batchOfProductService;
        this.batchOfProductMapper = batchOfProductMapper;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    @PostMapping("/batch")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBatch(@RequestBody BatchOfProductDTO batchOfProductDTO) {
        BatchOfProduct batchOfProduct = batchOfProductMapper.toBatchOfProduct(batchOfProductDTO);
        batchOfProductService.save(batchOfProduct);
    }

    @Override
    @GetMapping("/batch")
    public List<BatchOfProductDTO> allBatch() {
        return batchOfProductService.getAll()
                .stream()
                .map(batchOfProductMapper::toDto)
                .collect(toList());
    }

    @Override
    @GetMapping("/batch/{id}")
    public Optional<BatchOfProductDTO> getBatchById(@PathVariable Long id) {
        return batchOfProductService.getById(id).map(batchOfProductMapper::toDto);
    }

    @Override
    @DeleteMapping("/batch/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeBatchById(@PathVariable Long id) {
        batchOfProductService.remove(id);
    }

    @Override
    @PatchMapping("/batch/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBatch(@RequestBody BatchOfProductDTO batchOfProductDTO, @PathVariable Long id) {
        BatchOfProduct batchOfProduct = batchOfProductMapper.toBatchOfProduct(batchOfProductDTO);
        batchOfProductService.update(batchOfProduct, id);
    }
}
