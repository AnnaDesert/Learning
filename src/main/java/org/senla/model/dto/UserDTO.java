package org.senla.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotNull;
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
  @NotNull
  private String name;
  @NotNull
  private String surname;
  @NotNull
  private String phoneNumber;
  @NotNull
  private String email;
  @NotNull
  private RoleEnum role;
}