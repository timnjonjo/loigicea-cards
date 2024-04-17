package com.timnjonjo.cards.services;

import com.timnjonjo.cards.data.JwtTokenResponse;
import com.timnjonjo.cards.data.LoginRequest;
import com.timnjonjo.cards.persistence.User;
import com.timnjonjo.cards.persistence.UserRepository;

import java.time.LocalDateTime;

public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    public AuthServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public JwtTokenResponse authenticate(LoginRequest payload) {
        User user = userService.getUserByUsername(payload.username());

        return new JwtTokenResponse(payload.username(), "", LocalDateTime.now());
    }

    @Override
    public String refresh(String token) {
        return null;
    }
}
