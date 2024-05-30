package org.senla.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BatchOfProductCreationDTO {
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @NotBlank
  private LocalDateTime expirationDateStart;
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @NotBlank
  private LocalDateTime expirationDateEnd;
  @NotBlank
  @Min(1)
  private Long idProduct;
  @NotBlank
  @Min(1)
  private Integer count;
}