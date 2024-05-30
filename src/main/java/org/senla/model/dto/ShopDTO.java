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
public class ShopDTO {
  @NotBlank
  private Long id;
  @NotBlank
  private String name;
  @NotBlank
  private String address;
  @NotBlank
  private Long idAdmin;
}