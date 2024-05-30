package org.senla.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.*;

import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "product_catalog")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonPropertyOrder({"idShop", "idBatch", "count", "price"})
public class ProductCatalog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "id_shop", nullable = false)
  @NotNull
  private Long idShop;

  @Column(name = "id_batch", nullable = false)
  @NotNull
  private Long idBatch;

  @Column(nullable = false)
  @NotNull
  private Integer count;

  @Column(nullable = false)
  @NotNull
  private Float price;

  @OneToOne(mappedBy = "productCatalog", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "id_shop")
  @JsonIgnore
  private Shop shop;

  @OneToOne(mappedBy = "productCatalog", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "id_batch")
  @JsonIgnore
  private BatchOfProduct batchOfProduct;
}