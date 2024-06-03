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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotNull
    private String token;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false, name = "token_type")
    @Builder.Default
    private TokenTypeEnum tokenType = TokenTypeEnum.BEARER;

    @NotNull
    @Column(nullable = false)
    private boolean revoked;

    @NotNull
    @Column(nullable = false)
    private boolean expired;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn()
    @JsonIgnore
    private User user;
}
