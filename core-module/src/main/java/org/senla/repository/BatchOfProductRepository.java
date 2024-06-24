package org.senla.repository;

import org.senla.model.BatchOfProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchOfProductRepository extends JpaRepository<BatchOfProduct, Long> {
    @Query("SELECT batchOfProduct FROM BatchOfProduct batchOfProduct " +
            "INNER JOIN FETCH batchOfProduct.product product " +
            "INNER JOIN FETCH product.productCategory category " +
            "WHERE category.name = :productCategory")
    List<BatchOfProduct> findByProductCategory(@Param("productCategory") String productCategory);
}
