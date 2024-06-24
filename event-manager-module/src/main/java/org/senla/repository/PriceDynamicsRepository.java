package org.senla.repository;

import org.senla.model.PriceDynamics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceDynamicsRepository extends MongoRepository<PriceDynamics, String> {
}