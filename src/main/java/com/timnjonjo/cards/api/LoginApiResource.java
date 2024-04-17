package com.timnjonjo.cards.api;

import com.timnjonjo.cards.data.LoginRequest;
import com.timnjonjo.cards.services.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("v1/api/auth")
@RestController
public class LoginApiResource {


    private final AuthService authService;

    public LoginApiResource(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping()
    public void login(@RequestBody LoginRequest payload){
        this.authService.authenticate(payload);
    }
}
