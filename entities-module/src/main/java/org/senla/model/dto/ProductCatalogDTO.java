package org.senla.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCatalogDTO {
  @NotBlank
  private Long id;
  @NotBlank
  @Min(1)
  private Long idShop;
  @NotBlank
  @Min(1)
  private Long idBatch;
  @NotBlank
  @Min(1)
  private Integer count;
  @NotBlank
  @Min(1)
  private Float price;
  @Column(nullable = false)
  @NotNull
  private LocalDateTime date;
}