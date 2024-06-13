package io.codejournal.maven.swagger2java.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ShopCreationDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-06-13T17:37:57.333556400+03:00[Europe/Moscow]")


public class ShopCreationDTO   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("address")
  private String address = null;

  @JsonProperty("idAdmin")
  private Long idAdmin = null;

  public ShopCreationDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ShopCreationDTO address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public ShopCreationDTO idAdmin(Long idAdmin) {
    this.idAdmin = idAdmin;
    return this;
  }

  /**
   * Get idAdmin
   * @return idAdmin
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Long getIdAdmin() {
    return idAdmin;
  }

  public void setIdAdmin(Long idAdmin) {
    this.idAdmin = idAdmin;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShopCreationDTO shopCreationDTO = (ShopCreationDTO) o;
    return Objects.equals(this.name, shopCreationDTO.name) &&
        Objects.equals(this.address, shopCreationDTO.address) &&
        Objects.equals(this.idAdmin, shopCreationDTO.idAdmin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, idAdmin);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShopCreationDTO {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    idAdmin: ").append(toIndentedString(idAdmin)).append("\n");
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
