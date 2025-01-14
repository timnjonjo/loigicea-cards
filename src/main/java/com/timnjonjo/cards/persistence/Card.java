package com.timnjonjo.cards.persistence;

import com.timnjonjo.cards.data.CardDto;
import com.timnjonjo.cards.data.CreateCardRequest;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;

@Entity
@Table
@Getter
public class Card  extends CustomAuditable{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    @ValidColorCode()
    private String color;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Card(CreateCardRequest payload) {
        this.color = payload.getColor();
        this.name = payload.getName();
        this.description = payload.getDescription();
        this.status = Status.TODO;
    }

    public Card() {}

    public void update(CardDto payload) {
        this.color = payload.getColor();
        this.name = payload.getName();
        this.description = payload.getDescription();
        this.status = payload.getStatus();
    }
}
