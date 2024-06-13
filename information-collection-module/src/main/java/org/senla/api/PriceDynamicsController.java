package org.senla.api;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.senla.model.PriceDynamics;
import org.senla.model.dto.PriceDynamicsFinderDTO;
import org.senla.service.PriceDynamicsService;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "dynamics", description = "Запросы для price_dynamics")
@RequiredArgsConstructor
public class PriceDynamicsController {
    private final PriceDynamicsService priceDynamicsService;

    @GetMapping("/dynamics")
    public List<PriceDynamics> getDynamics(
            @PathVariable Long idShop,
            @PathVariable Long idBatch,
            @PathVariable LocalDateTime dateStart,
            @PathVariable LocalDateTime dateEnd) {
        return priceDynamicsService.getPriceDynamics(idShop, idBatch, dateStart, dateEnd);
    }
}