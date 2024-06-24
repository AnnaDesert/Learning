package org.senla.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.senla.model.PriceDynamics;
import org.senla.repository.PriceDynamicsRepository;
import org.senla.service.PriceDynamicsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PriceDynamicsServiceImpl implements PriceDynamicsService {
    private final PriceDynamicsRepository priceDynamicsRepository;

    @Override
    public List<PriceDynamics> getPriceDynamics(Long idShop, Long idBatch, LocalDateTime dateStart, LocalDateTime dateEnd) {
        return new ArrayList<>(priceDynamicsRepository.findAllByIdShopAndIdBatch(idShop, idBatch, dateStart, dateEnd));
    }
}
