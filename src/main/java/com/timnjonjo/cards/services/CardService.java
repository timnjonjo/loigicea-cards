package com.timnjonjo.cards.services;

import com.timnjonjo.cards.data.CardDto;

public interface CardService {
    void create(CardDto payload);

    CardDto getById(String id);

    void delete(String id);
}
