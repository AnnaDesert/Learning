package org.senla.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCatalogDTO {
  @NotNull
  private Long idBatch;

  @NotNull
  private Integer count;

  @NotNull
  private Float price;
}