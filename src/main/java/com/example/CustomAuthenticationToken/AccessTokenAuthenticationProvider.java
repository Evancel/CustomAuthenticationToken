package com.example.CustomAuthenticationToken;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component
public class AccessTokenAuthenticationProvider implements AuthenticationProvider {
    private final AccessTokenRepository repository;

    public AccessTokenAuthenticationProvider(AccessTokenRepository repository) {
        this.repository = repository;
    }

    @Transactional(noRollbackFor = BadCredentialsException.class)
    @Override
    public Authentication authenticate(Authentication authentication) {
        var token = authentication.getCredentials().toString();

        AccessToken accessToken = repository
                .findByToken(token)
                .orElseThrow(() -> new BadCredentialsException("Invalid access token"));

        repository.deleteById(accessToken.getId());

        if (new Date().after(accessToken.getExpiresAt())) {
            throw new BadCredentialsException("Invalid access token");
        }

        authentication.setAuthenticated(true);
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return AccessTokenAuthentication.class.equals(authentication);
    }
}
