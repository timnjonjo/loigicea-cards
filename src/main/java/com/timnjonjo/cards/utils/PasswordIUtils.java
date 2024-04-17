package com.timnjonjo.cards.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordIUtils {

    public static PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    public static String generatePassword() {
        return "password";
    }

    public static String generateSalt() {
        return "salt";
    }

    public static String generateHash(String password) {
        return encoder().encode(password);
    }
}
