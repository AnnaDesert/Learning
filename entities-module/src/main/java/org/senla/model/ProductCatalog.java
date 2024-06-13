package org.senla.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

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

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @Column(nullable = false)
  @NotNull
  private LocalDateTime date;

  @OneToOne(mappedBy = "productCatalog", fetch = FetchType.LAZY)
  @JoinColumn(name = "id_shop")
  @JsonIgnore
  private Shop shop;

  @OneToOne(mappedBy = "productCatalog", fetch = FetchType.LAZY)
  @JoinColumn(name = "id_batch")
  @JsonIgnore
  private BatchOfProduct batchOfProduct;
}