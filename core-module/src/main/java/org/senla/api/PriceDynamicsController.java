package org.senla.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.senla.model.mapper.PriceDynamicsListMapper;
import org.senla.service.PriceDynamicsService;
import org.senla.swagger.api.DynamicsApi;
import org.senla.swagger.model.PriceDynamicsRequestDTO;
import org.senla.swagger.model.PriceDynamicsResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "dynamics", description = "Запросы для price_dynamics")
@RequiredArgsConstructor
public class PriceDynamicsController implements DynamicsApi {
    private final PriceDynamicsService priceDynamicsService;
    private final PriceDynamicsListMapper priceDynamicsListMapper;

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<List<PriceDynamicsResponseDTO>> getPriceDynamics(PriceDynamicsRequestDTO priceDynamicsRequestDTO) {
        return ResponseEntity.ok(priceDynamicsListMapper.toDtoList(
                priceDynamicsService.getPriceDynamics(
                priceDynamicsRequestDTO.getIdShop(),
                priceDynamicsRequestDTO.getIdBatch(),
                priceDynamicsRequestDTO.getDateStart(),
                priceDynamicsRequestDTO.getDateEnd())
        ));
    }
}