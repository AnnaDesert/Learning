package org.senla.api;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.senla.model.PriceDynamics;
import org.senla.service.PriceDynamicsService;
import org.senla.service.impl.PriceDynamicsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@Validated
@RequestMapping("/api/v1")
@Tag(name = "dynamics", description = "Запросы для price_dynamics")
public class PriceDynamicsController {
    private final PriceDynamicsService priceDynamicsService;

    @Autowired
    public PriceDynamicsController(PriceDynamicsServiceImpl priceDynamicsService) {
        this.priceDynamicsService = priceDynamicsService;
    }

    @GetMapping("/dynamics")
    public List<PriceDynamics> getDynamics(
            @RequestParam("idShop") Long idShop,
            @RequestParam("idBatch") Long idBatch,
            @RequestParam("strDateStart") String strDateStart,
            @RequestParam("strDateEnd") String strDateEnd) {
        LocalDateTime dateStart = LocalDateTime.parse(strDateStart);
        LocalDateTime dateEnd = LocalDateTime.parse(strDateEnd);
        return priceDynamicsService.getPriceDynamics(idShop, idBatch, dateStart, dateEnd);
    }
}