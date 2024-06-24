package org.senla.repository;

import org.senla.model.ProductCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCatalogRepository extends JpaRepository<ProductCatalog, Long> {
    @Query("SELECT productCatalog FROM ProductCatalog productCatalog " +
            "WHERE productCatalog.idBatch = :idBatch " +
            "ORDER BY productCatalog.price")
    List<ProductCatalog> findAllOrderedByPrice(@Param("idBatch") Long idBatch);


}
