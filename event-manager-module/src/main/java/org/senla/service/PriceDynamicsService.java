package org.senla.service;

import org.senla.swagger.model.PriceDynamicsResponseDTO;

public interface PriceDynamicsService {
    void consumeEvents(PriceDynamicsResponseDTO priceDynamicsResponseDTO);
}
