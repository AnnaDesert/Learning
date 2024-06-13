package org.senla.repository;

import org.senla.model.PriceDynamics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceDynamicsRepository extends MongoRepository<PriceDynamics, String> {
}