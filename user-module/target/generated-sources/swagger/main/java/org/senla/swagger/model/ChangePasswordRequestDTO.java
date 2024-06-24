package org.senla.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ChangePasswordRequestDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-06-24T09:46:33.073075700+03:00[Europe/Moscow]")


public class ChangePasswordRequestDTO   {
  @JsonProperty("currentPassword")
  private String currentPassword = null;

  @JsonProperty("newPassword")
  private String newPassword = null;

  @JsonProperty("confirmationPassword")
  private String confirmationPassword = null;

  public ChangePasswordRequestDTO currentPassword(String currentPassword) {
    this.currentPassword = currentPassword;
    return this;
  }

  /**
   * Get currentPassword
   * @return currentPassword
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getCurrentPassword() {
    return currentPassword;
  }

  public void setCurrentPassword(String currentPassword) {
    this.currentPassword = currentPassword;
  }

  public ChangePasswordRequestDTO newPassword(String newPassword) {
    this.newPassword = newPassword;
    return this;
  }

  /**
   * Get newPassword
   * @return newPassword
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  public ChangePasswordRequestDTO confirmationPassword(String confirmationPassword) {
    this.confirmationPassword = confirmationPassword;
    return this;
  }

  /**
   * Get confirmationPassword
   * @return confirmationPassword
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getConfirmationPassword() {
    return confirmationPassword;
  }

  public void setConfirmationPassword(String confirmationPassword) {
    this.confirmationPassword = confirmationPassword;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChangePasswordRequestDTO changePasswordRequestDTO = (ChangePasswordRequestDTO) o;
    return Objects.equals(this.currentPassword, changePasswordRequestDTO.currentPassword) &&
        Objects.equals(this.newPassword, changePasswordRequestDTO.newPassword) &&
        Objects.equals(this.confirmationPassword, changePasswordRequestDTO.confirmationPassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentPassword, newPassword, confirmationPassword);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChangePasswordRequestDTO {\n");
    
    sb.append("    currentPassword: ").append(toIndentedString(currentPassword)).append("\n");
    sb.append("    newPassword: ").append(toIndentedString(newPassword)).append("\n");
    sb.append("    confirmationPassword: ").append(toIndentedString(confirmationPassword)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
