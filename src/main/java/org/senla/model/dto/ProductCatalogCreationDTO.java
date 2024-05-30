package org.senla.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCatalogCreationDTO {
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
}