package com.timnjonjo.cards.persistence;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table
@Getter
public class User extends CustomAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType;

}
