package com.timnjonjo.cards.data;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public record JwtTokenResponse(String username, String token, LocalDateTime expiryDate) {


}
