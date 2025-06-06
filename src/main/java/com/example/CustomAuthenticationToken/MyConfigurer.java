package com.example.CustomAuthenticationToken;
/*
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class MyConfigurer extends AbstractHttpConfigurer<MyConfigurer, HttpSecurity> {
    private final AuthenticationManager manager;

    public MyConfigurer(AuthenticationManager manager) {
        this.manager = manager;
    }

    @Override
    public void configure(HttpSecurity builder) {
        AuthenticationManager manager = builder.getSharedObject(AuthenticationManager.class);
        builder.addFilterAfter(
                new AccessTokenFilter(manager),
                UsernamePasswordAuthenticationFilter.class
        );
    }
}
 */