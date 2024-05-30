package org.senla.repository;

import org.senla.model.PriceDynamics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceDynamicsRepository extends JpaRepository<PriceDynamics, Long> {
    @Query("SELECT priceDynamics FROM PriceDynamics priceDynamics " +
            "WHERE priceDynamics.idShop = :idShop " +
            "AND   priceDynamics.idBatch = :idBatch " +
            "AND   priceDynamics.date >= :dateStart " +
            "AND   :dateEnd >= priceDynamics.date")
    List<PriceDynamics> findAllByIdShopAndIdBatch(
            @Param("idShop") Long idShop,
            @Param("idBatch") Long idBatch,
            @Param("dateStart") LocalDateTime dateStart,
            @Param("dateEnd") LocalDateTime dateEnd
    );
}