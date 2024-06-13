package io.codejournal.maven.swagger2java.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BatchOfProductDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-06-13T17:37:57.333556400+03:00[Europe/Moscow]")


public class BatchOfProductDTO   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("expirationDateStart")
  private OffsetDateTime expirationDateStart = null;

  @JsonProperty("expirationDateEnd")
  private OffsetDateTime expirationDateEnd = null;

  @JsonProperty("idProduct")
  private Long idProduct = null;

  @JsonProperty("count")
  private Integer count = null;

  public BatchOfProductDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BatchOfProductDTO expirationDateStart(OffsetDateTime expirationDateStart) {
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
    public OffsetDateTime getExpirationDateStart() {
    return expirationDateStart;
  }

  public void setExpirationDateStart(OffsetDateTime expirationDateStart) {
    this.expirationDateStart = expirationDateStart;
  }

  public BatchOfProductDTO expirationDateEnd(OffsetDateTime expirationDateEnd) {
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
    public OffsetDateTime getExpirationDateEnd() {
    return expirationDateEnd;
  }

  public void setExpirationDateEnd(OffsetDateTime expirationDateEnd) {
    this.expirationDateEnd = expirationDateEnd;
  }

  public BatchOfProductDTO idProduct(Long idProduct) {
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

  public BatchOfProductDTO count(Integer count) {
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
    BatchOfProductDTO batchOfProductDTO = (BatchOfProductDTO) o;
    return Objects.equals(this.id, batchOfProductDTO.id) &&
        Objects.equals(this.expirationDateStart, batchOfProductDTO.expirationDateStart) &&
        Objects.equals(this.expirationDateEnd, batchOfProductDTO.expirationDateEnd) &&
        Objects.equals(this.idProduct, batchOfProductDTO.idProduct) &&
        Objects.equals(this.count, batchOfProductDTO.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, expirationDateStart, expirationDateEnd, idProduct, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BatchOfProductDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
