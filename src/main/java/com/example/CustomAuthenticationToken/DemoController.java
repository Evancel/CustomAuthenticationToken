package com.example.CustomAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Date;

@RestController
public class DemoController {
    private final AccessTokenRepository repository;

    public DemoController(AccessTokenRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/token")
    public String token() {
        var bytes = KeyGenerators.secureRandom(10).generateKey();
        var hexString = new BigInteger(1, bytes).toString(16);

        var token = new AccessToken();
        token.setToken(hexString);
        var timestamp = System.currentTimeMillis() + 300_000; // TTL = 300 seconds
        token.setExpiresAt(new Date(timestamp));
        repository.save(token);

        return hexString;
    }

    @PostMapping("/action")
    public String action(Authentication authentication) {
        return "Requested action has been performed with token=" + authentication.getCredentials();
    }
}