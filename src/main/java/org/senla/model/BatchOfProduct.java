package org.senla.model;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "batch_of_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BatchOfProduct {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @Column(name = "expiration_date_start", nullable = false)
  @NotNull
  private OffsetDateTime expirationDateStart;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @Column(name = "expiration_date_end", nullable = false)
  @NotNull
  private OffsetDateTime expirationDateEnd;

  @Column(name = "id_product", nullable = false)
  @NotNull
  private Long idProduct;

  @Column(nullable = false)
  @NotNull
  private Integer count;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "id")
  @JsonIgnore
  private ProductCatalog productCatalog;

  @OneToOne(mappedBy = "batchOfProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "id_product")
  @JsonIgnore
  private Product product;
}