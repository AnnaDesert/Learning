package org.senla.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

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

  @OneToOne(mappedBy = "shop", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "id_admin")
  @JsonIgnore
  private User admin;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "id")
  @JsonIgnore
  private ProductCatalog productCatalog;
}