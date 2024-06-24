package org.senla.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "batch_of_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchOfProduct {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @Column(name = "expiration_date_start", nullable = false)
  @NotNull
  private LocalDateTime expirationDateStart;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @Column(name = "expiration_date_end", nullable = false)
  @NotNull
  private LocalDateTime expirationDateEnd;

  @Column(name = "product_id", nullable = false, insertable=false, updatable=false)
  @NotNull
  private Long productId;

  @Column(nullable = false)
  @NotNull
  private Integer count;

  @OneToOne(fetch = FetchType.LAZY)
  @PrimaryKeyJoinColumn
  private ProductCatalog productCatalog;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product product;
}