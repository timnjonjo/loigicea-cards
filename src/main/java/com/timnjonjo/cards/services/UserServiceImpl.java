package com.timnjonjo.cards.services;

import com.timnjonjo.cards.data.CreateUserRequest;
import com.timnjonjo.cards.persistence.User;
import com.timnjonjo.cards.persistence.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(CreateUserRequest payload) {
        log.info("Creating user {}", payload);
        User user = new User(payload);
        this.userRepository.save(user);
        log.info("User created successfully");
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository
                .findByUsername(username)
                .orElseThrow(()->new LogiceaException("No User Found"));
    }
}
