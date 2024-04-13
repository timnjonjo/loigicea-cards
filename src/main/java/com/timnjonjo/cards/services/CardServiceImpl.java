package com.timnjonjo.cards.services;

import com.timnjonjo.cards.data.CardDto;
import com.timnjonjo.cards.persistence.Card;
import com.timnjonjo.cards.persistence.CardRepository;
import com.timnjonjo.cards.persistence.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void create(CardDto payload) {
        log.info("Creating card {}", payload);
        Card card = new Card(payload);
        try {
            this.cardRepository.save(card);
        } catch (Exception e) {
            log.error("Error saving card", e);
            throw new CardException("Error Creating Card: Error");
        }
    }

    @Override
    public CardDto getById(String id) {
        log.info("Getting card {}", id);
        Card card = getCard(id);
        return new CardDto(card);
    }

    @Override
    public void delete(String id) {
        log.info("Deleting card {}", id);
        Card card = getCard(id);
        this.cardRepository.delete(card);
    }

    private Card getCard(String id) {
        log.info("Getting card {}", id);
        User user = SecurityUtils.getUser();
        return this.cardRepository.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new CardException("No Card Found"));
    }
}
