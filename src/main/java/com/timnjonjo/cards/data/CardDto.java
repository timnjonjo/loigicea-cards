package com.timnjonjo.cards.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.timnjonjo.cards.persistence.Card;
import com.timnjonjo.cards.persistence.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    @NotNull(message = "Name is required")
    @NotBlank(message = "Name is required")
    private String name;
    private String description;
    @Pattern(regexp = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$")
    private String color;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Status status;

    public CardDto(Card card) {
        this.id = card.getId();
        this.name = card.getName();
        this.description = card.getDescription();
        this.color = card.getColor();
        this.status = card.getStatus();
    }
}
