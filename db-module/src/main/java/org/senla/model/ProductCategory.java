package org.senla.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "product_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCategory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(insertable=false, updatable=false)
  private Long id;

  @Column(nullable = false)
  @NotNull
  private String name;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name="product_to_category",
          joinColumns =  @JoinColumn(name="id_category", referencedColumnName="id"),
          inverseJoinColumns = @JoinColumn(name="id_product ", referencedColumnName="id"))
  private List<Product> product;
}