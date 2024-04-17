package com.timnjonjo.cards.services;


import com.timnjonjo.cards.data.CreateUserRequest;
import com.timnjonjo.cards.persistence.User;

public interface UserService {

    void create(CreateUserRequest payload);

    User getUserByUsername(String username);
}
