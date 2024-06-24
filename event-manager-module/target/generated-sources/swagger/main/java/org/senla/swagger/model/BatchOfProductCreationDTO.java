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
 * BatchOfProductCreationDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-06-24T09:46:36.596518200+03:00[Europe/Moscow]")


public class BatchOfProductCreationDTO   {
  @JsonProperty("expirationDateStart")
  private LocalDateTime expirationDateStart = null;

  @JsonProperty("expirationDateEnd")
  private LocalDateTime expirationDateEnd = null;

  @JsonProperty("idProduct")
  private Long idProduct = null;

  @JsonProperty("count")
  private Integer count = null;

  public BatchOfProductCreationDTO expirationDateStart(LocalDateTime expirationDateStart) {
    this.expirationDateStart = expirationDateStart;
    return this;
  }

  /**
   * Get expirationDateStart
   * @return expirationDateStart
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public LocalDateTime getExpirationDateStart() {
    return expirationDateStart;
  }

  public void setExpirationDateStart(LocalDateTime expirationDateStart) {
    this.expirationDateStart = expirationDateStart;
  }

  public BatchOfProductCreationDTO expirationDateEnd(LocalDateTime expirationDateEnd) {
    this.expirationDateEnd = expirationDateEnd;
    return this;
  }

  /**
   * Get expirationDateEnd
   * @return expirationDateEnd
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public LocalDateTime getExpirationDateEnd() {
    return expirationDateEnd;
  }

  public void setExpirationDateEnd(LocalDateTime expirationDateEnd) {
    this.expirationDateEnd = expirationDateEnd;
  }

  public BatchOfProductCreationDTO idProduct(Long idProduct) {
    this.idProduct = idProduct;
    return this;
  }

  /**
   * Get idProduct
   * @return idProduct
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Long getIdProduct() {
    return idProduct;
  }

  public void setIdProduct(Long idProduct) {
    this.idProduct = idProduct;
  }

  public BatchOfProductCreationDTO count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * Get count
   * @return count
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BatchOfProductCreationDTO batchOfProductCreationDTO = (BatchOfProductCreationDTO) o;
    return Objects.equals(this.expirationDateStart, batchOfProductCreationDTO.expirationDateStart) &&
        Objects.equals(this.expirationDateEnd, batchOfProductCreationDTO.expirationDateEnd) &&
        Objects.equals(this.idProduct, batchOfProductCreationDTO.idProduct) &&
        Objects.equals(this.count, batchOfProductCreationDTO.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expirationDateStart, expirationDateEnd, idProduct, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BatchOfProductCreationDTO {\n");
    
    sb.append("    expirationDateStart: ").append(toIndentedString(expirationDateStart)).append("\n");
    sb.append("    expirationDateEnd: ").append(toIndentedString(expirationDateEnd)).append("\n");
    sb.append("    idProduct: ").append(toIndentedString(idProduct)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
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
