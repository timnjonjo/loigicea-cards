package com.timnjonjo.cards.services;

import com.timnjonjo.cards.persistence.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    SecurityUtils() {
        throw new IllegalArgumentException("Utility class");
    }

    public static User getUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
