package org.senla.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.senla.model.RoleEnum;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
  @NotBlank
  private Long id;
  @NotBlank
  private String name;
  @NotBlank
  private String surname;
  @NotBlank
  private String phoneNumber;
  @NotBlank
  @Email
  private String email;
  @NotBlank
  private RoleEnum role;
}