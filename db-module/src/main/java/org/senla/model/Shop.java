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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "shop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  @NotNull
  private String name;

  @Column(nullable = false)
  @NotNull
  private String address;

  @Column(name = "id_admin", nullable = false)
  @NotNull
  private Long idAdmin;

  @OneToOne(mappedBy = "shop", fetch = FetchType.LAZY)
  @JoinColumn(name = "id_admin")
  @JsonIgnore
  private User admin;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id")
  @JsonIgnore
  private ProductCatalog productCatalog;
}