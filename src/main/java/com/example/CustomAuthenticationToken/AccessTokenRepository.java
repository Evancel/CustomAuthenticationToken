package com.example.CustomAuthenticationToken;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccessTokenRepository extends CrudRepository<AccessToken, Long> {
    Optional<AccessToken> findByToken(String token);
}
