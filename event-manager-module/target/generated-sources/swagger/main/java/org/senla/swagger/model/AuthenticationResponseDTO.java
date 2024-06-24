package org.senla.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AuthenticationResponseDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-06-24T09:46:36.596518200+03:00[Europe/Moscow]")


public class AuthenticationResponseDTO   {
  @JsonProperty("accessToken")
  private String accessToken = null;

  @JsonProperty("refreshToken")
  private String refreshToken = null;

  public AuthenticationResponseDTO accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  /**
   * Get accessToken
   * @return accessToken
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public AuthenticationResponseDTO refreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }

  /**
   * Get refreshToken
   * @return refreshToken
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthenticationResponseDTO authenticationResponseDTO = (AuthenticationResponseDTO) o;
    return Objects.equals(this.accessToken, authenticationResponseDTO.accessToken) &&
        Objects.equals(this.refreshToken, authenticationResponseDTO.refreshToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessToken, refreshToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthenticationResponseDTO {\n");
    
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
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
