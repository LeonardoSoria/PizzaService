package com.loginservice.loginservice.application;

import com.loginservice.loginservice.domain.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserUseCase {
    private final UserService userService;

    public RegisterUserUseCase(UserService userService) {
        this.userService = userService;
    }

    public void execute(String username, String email, String password) {
        userService.registerUser(username, email, password);
    }
}
