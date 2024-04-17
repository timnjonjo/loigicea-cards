package com.timnjonjo.cards.services;

import com.timnjonjo.cards.data.CardDto;
import com.timnjonjo.cards.data.CreateCardRequest;

public interface CardService {
    void create(CreateCardRequest payload);
    CardDto getById(String id);
    void delete(String id);

    void update(String id, CardDto payload);
}
