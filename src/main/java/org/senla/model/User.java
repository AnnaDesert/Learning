package org.senla.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, columnDefinition = "char")
  @NotNull
  private String password;
  @Column(nullable = false, columnDefinition = "char")
  @NotNull
  private String name;
  @Column(nullable = false, columnDefinition = "char")
  @NotNull
  private String surname;
  @Column(name = "phone_number", nullable = false, columnDefinition = "char")
  @NotNull
  private String phoneNumber;
  @Column(nullable = false, columnDefinition = "char")
  @NotNull
  private String email;
  @Enumerated(EnumType.STRING)
  @NotNull
  @Column(nullable = false)
  private RoleEnum role;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "id")
  @JsonIgnore
  private Shop shop;
}