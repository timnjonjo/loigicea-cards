package com.timnjonjo.cards.api;

import com.timnjonjo.cards.data.CreateUserRequest;
import com.timnjonjo.cards.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("v1/api/users")
@RestController
public class UserApiResource {

    private final UserService userService;

    public UserApiResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public void create(@RequestBody CreateUserRequest payload){
        this.userService.create(payload);
    }




}
