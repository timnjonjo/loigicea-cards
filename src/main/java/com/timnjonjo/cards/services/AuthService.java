package com.timnjonjo.cards.services;

import com.timnjonjo.cards.data.JwtTokenResponse;
import com.timnjonjo.cards.data.LoginRequest;

public interface AuthService {
    JwtTokenResponse authenticate(LoginRequest payload);

    String refresh(String token);
}
