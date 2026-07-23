package com.meerkatgramv2scg.global.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public record JwtConfig(
        String secret,
        String headerKey,
        String scheme
) {
}
