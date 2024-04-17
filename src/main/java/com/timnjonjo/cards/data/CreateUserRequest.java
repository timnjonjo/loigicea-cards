package com.timnjonjo.cards.data;

import com.timnjonjo.cards.persistence.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    private String username;
    private String password;
    private UserType userType;

}
