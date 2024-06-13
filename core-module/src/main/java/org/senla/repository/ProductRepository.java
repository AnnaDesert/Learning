package org.senla.repository;

import org.senla.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT product FROM Product product INNER JOIN FETCH product.productCategory category " +
            "WHERE category.name = :category")
    List<Product> findByCategory(@Param("category") String category);
    List<Product> findByName(String name);
}
