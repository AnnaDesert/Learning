package org.senla.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {
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

  @OneToMany(mappedBy = "user")
  @JoinColumn(name = "id")
  @JsonIgnore
  private List<Token> tokens;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return role.getAuthorities();
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}