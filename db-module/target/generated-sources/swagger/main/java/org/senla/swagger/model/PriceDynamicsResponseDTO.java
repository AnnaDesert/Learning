package org.senla.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.OffsetDateTime;
import java.time.LocalDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PriceDynamicsResponseDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-06-24T09:46:21.945026200+03:00[Europe/Moscow]")


public class PriceDynamicsResponseDTO   {
  @JsonProperty("date")
  private LocalDateTime date = null;

  @JsonProperty("price")
  private Float price = null;

  public PriceDynamicsResponseDTO date(LocalDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public PriceDynamicsResponseDTO price(Float price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceDynamicsResponseDTO priceDynamicsResponseDTO = (PriceDynamicsResponseDTO) o;
    return Objects.equals(this.date, priceDynamicsResponseDTO.date) &&
        Objects.equals(this.price, priceDynamicsResponseDTO.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceDynamicsResponseDTO {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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
