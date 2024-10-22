package com.loginservice.loginservice.application;

import com.loginservice.loginservice.domain.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class LoginUserUseCase {
    private final UserService userService;

    public LoginUserUseCase(UserService userService) {
        this.userService = userService;
    }

    public boolean execute(String username, String password) {
        return userService.loginUser(username,password);
    }
}
