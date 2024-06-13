package org.senla.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
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

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id")
  @JsonIgnore
  private Shop shop;

  @OneToMany(fetch = FetchType.LAZY)
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