package com.example.CustomAuthenticationToken;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class MyConfigurer extends AbstractHttpConfigurer<MyConfigurer, HttpSecurity> {

    @Override
    public void configure(HttpSecurity builder) {
        AuthenticationManager manager = builder.getSharedObject(AuthenticationManager.class);
        builder.addFilterAfter(
                new AccessTokenFilter(manager),
                UsernamePasswordAuthenticationFilter.class
        );
    }
}