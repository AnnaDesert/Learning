package org.senla.service;

import org.senla.model.PriceDynamics;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceDynamicsService {
    List<PriceDynamics> getPriceDynamics(Long idShop, Long idBatch, LocalDateTime dateStart, LocalDateTime dateEnd);
}
