package com.timnjonjo.cards.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Card Exceptions Occurred")
public class CardException extends RuntimeException {
    public CardException(String message) {
        super(message);
    }
}
