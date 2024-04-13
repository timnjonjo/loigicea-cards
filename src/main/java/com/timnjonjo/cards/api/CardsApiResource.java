package com.timnjonjo.cards.api;

import com.timnjonjo.cards.data.CardDto;
import com.timnjonjo.cards.services.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("v1/api/cards")
@RestController
public class CardsApiResource {

    private final CardService cardsService;

    public CardsApiResource(CardService cardsService) {
        this.cardsService = cardsService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CardDto payload) {
        this.cardsService.create(payload);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CardDto get(@PathVariable String id) {
        return this.cardsService.getById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable String id) {
        this.cardsService.delete(id);
    }

}
