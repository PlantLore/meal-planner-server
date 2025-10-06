package com.davis.mealplanner.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import com.davis.mealplanner.exceptions.UnauthorizedAuthenticationException;

public final class SecurityUtils {

    private SecurityUtils() {}

    // The claim name where the email is stored
    private static final String EMAIL_CLAIM = "https://whiskandwisker/email";

    public static String getEmailFromJwt() throws UnauthorizedAuthenticationException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new UnauthorizedAuthenticationException();
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof Jwt jwt) {
            Object claim = jwt.getClaim(EMAIL_CLAIM);
            if (claim instanceof String s) {
                return s;
            }
        }

        throw new UnauthorizedAuthenticationException();
    }
}
