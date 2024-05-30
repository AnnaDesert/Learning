package org.senla.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopCreationDTO {
  @NotBlank
  private String name;
  @NotBlank
  private String address;
  @NotBlank
  private Long idAdmin;
}