package org.senla.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "token")
public class Token {
    @Id
    @GeneratedValue
    public Integer id;

    @Column(nullable = false, unique = true)
    @NotNull
    public String token;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false, name = "token_type")
    @Builder.Default
    public TokenTypeEnum tokenType = TokenTypeEnum.BEARER;

    @NotNull
    @Column(nullable = false)
    public boolean revoked;

    @NotNull
    @Column(nullable = false)
    public boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @JsonIgnore
    public User user;
}
