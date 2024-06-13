package io.codejournal.maven.swagger2java.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProductCatalogDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-06-13T17:37:57.333556400+03:00[Europe/Moscow]")


public class ProductCatalogDTO   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("idShop")
  private Long idShop = null;

  @JsonProperty("idBatch")
  private Long idBatch = null;

  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("price")
  private Float price = null;

  public ProductCatalogDTO id(Long id) {
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

  public ProductCatalogDTO idShop(Long idShop) {
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

  public ProductCatalogDTO idBatch(Long idBatch) {
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

  public ProductCatalogDTO count(Integer count) {
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

  public ProductCatalogDTO price(Float price) {
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
    ProductCatalogDTO productCatalogDTO = (ProductCatalogDTO) o;
    return Objects.equals(this.id, productCatalogDTO.id) &&
        Objects.equals(this.idShop, productCatalogDTO.idShop) &&
        Objects.equals(this.idBatch, productCatalogDTO.idBatch) &&
        Objects.equals(this.count, productCatalogDTO.count) &&
        Objects.equals(this.price, productCatalogDTO.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, idShop, idBatch, count, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductCatalogDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idShop: ").append(toIndentedString(idShop)).append("\n");
    sb.append("    idBatch: ").append(toIndentedString(idBatch)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
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
