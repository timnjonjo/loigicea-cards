package com.timnjonjo.cards.persistence;

import com.timnjonjo.cards.data.CreateUserRequest;
import com.timnjonjo.cards.utils.PasswordIUtils;
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

    public User() {
    }

    public User(CreateUserRequest payload) {
        this.username = payload.getUsername();
        this.password = PasswordIUtils.generateHash(payload.getPassword());
        this.userType = payload.getUserType();
    }
}
