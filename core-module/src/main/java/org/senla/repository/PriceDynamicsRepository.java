package org.senla.repository;

import org.senla.model.PriceDynamics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceDynamicsRepository extends MongoRepository<PriceDynamics, String> {
    @Query("{ $and: [ {idShop: :idShop}, {idBatch: :idBatch}, {date: {$gte: :dateStart}}, {date: {$lte: :dateEnd}} ] }")
    List<PriceDynamics> findAllByIdShopAndIdBatch(
            @Param("idShop") Long idShop,
            @Param("idBatch") Long idBatch,
            @Param("dateStart") LocalDateTime dateStart,
            @Param("dateEnd") LocalDateTime dateEnd
    );
}