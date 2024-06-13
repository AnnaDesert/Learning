package org.senla.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.senla.model.PriceDynamics;
import org.senla.model.dto.PriceDynamicsDTO;
import org.senla.model.mapper.PriceDynamicsMapper;
import org.senla.repository.PriceDynamicsRepository;
import org.senla.service.PriceDynamicsService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PriceDynamicsServiceImpl implements PriceDynamicsService {
    private final PriceDynamicsRepository priceDynamicsRepository;
    private final PriceDynamicsMapper priceDynamicsMapper;

    @KafkaListener(topics = "dynamicTopic", groupId = "jt-group")
    public void consumeEvents(PriceDynamicsDTO priceDynamicsDTO) {
        PriceDynamics priceDynamics = priceDynamicsMapper.toPriceDynamics(priceDynamicsDTO);
        priceDynamicsRepository.save(priceDynamics);
        log.info("consumer consume the events {} ", priceDynamicsDTO.toString());
    }
}
