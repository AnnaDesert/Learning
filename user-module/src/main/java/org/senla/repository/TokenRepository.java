package org.senla.repository;

import org.senla.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    @Query("SELECT token FROM Token token INNER JOIN User user " +
            "ON token.user.id = user.id " +
            "WHERE user.id = :id AND (token.expired = false OR token.revoked = false)")
    List<Token> findAllValidTokenByUser(@Param("id") Long id);

    Optional<Token> findByToken(String token);
}
