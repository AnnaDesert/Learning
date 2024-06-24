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
 * PriceDynamicsRequestDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-06-24T09:46:36.596518200+03:00[Europe/Moscow]")


public class PriceDynamicsRequestDTO   {
  @JsonProperty("dateStart")
  private LocalDateTime dateStart = null;

  @JsonProperty("dateEnd")
  private LocalDateTime dateEnd = null;

  @JsonProperty("idShop")
  private Long idShop = null;

  @JsonProperty("idBatch")
  private Long idBatch = null;

  public PriceDynamicsRequestDTO dateStart(LocalDateTime dateStart) {
    this.dateStart = dateStart;
    return this;
  }

  /**
   * Get dateStart
   * @return dateStart
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public LocalDateTime getDateStart() {
    return dateStart;
  }

  public void setDateStart(LocalDateTime dateStart) {
    this.dateStart = dateStart;
  }

  public PriceDynamicsRequestDTO dateEnd(LocalDateTime dateEnd) {
    this.dateEnd = dateEnd;
    return this;
  }

  /**
   * Get dateEnd
   * @return dateEnd
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public LocalDateTime getDateEnd() {
    return dateEnd;
  }

  public void setDateEnd(LocalDateTime dateEnd) {
    this.dateEnd = dateEnd;
  }

  public PriceDynamicsRequestDTO idShop(Long idShop) {
    this.idShop = idShop;
    return this;
  }

  /**
   * Get idShop
   * @return idShop
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Long getIdShop() {
    return idShop;
  }

  public void setIdShop(Long idShop) {
    this.idShop = idShop;
  }

  public PriceDynamicsRequestDTO idBatch(Long idBatch) {
    this.idBatch = idBatch;
    return this;
  }

  /**
   * Get idBatch
   * @return idBatch
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Long getIdBatch() {
    return idBatch;
  }

  public void setIdBatch(Long idBatch) {
    this.idBatch = idBatch;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceDynamicsRequestDTO priceDynamicsRequestDTO = (PriceDynamicsRequestDTO) o;
    return Objects.equals(this.dateStart, priceDynamicsRequestDTO.dateStart) &&
        Objects.equals(this.dateEnd, priceDynamicsRequestDTO.dateEnd) &&
        Objects.equals(this.idShop, priceDynamicsRequestDTO.idShop) &&
        Objects.equals(this.idBatch, priceDynamicsRequestDTO.idBatch);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dateStart, dateEnd, idShop, idBatch);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceDynamicsRequestDTO {\n");
    
    sb.append("    dateStart: ").append(toIndentedString(dateStart)).append("\n");
    sb.append("    dateEnd: ").append(toIndentedString(dateEnd)).append("\n");
    sb.append("    idShop: ").append(toIndentedString(idShop)).append("\n");
    sb.append("    idBatch: ").append(toIndentedString(idBatch)).append("\n");
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
