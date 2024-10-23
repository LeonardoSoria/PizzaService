package com.lsoria.loginservice.application.service;

import com.lsoria.loginservice.application.port.input.LoginUserUseCase;
import com.lsoria.loginservice.application.port.input.RegisterUserUseCase;
import com.lsoria.loginservice.domain.model.User;
import com.lsoria.loginservice.application.port.output.EncryptionServicePort;
import com.lsoria.loginservice.application.port.output.LoggerServicePort;
import com.lsoria.loginservice.application.port.output.UserOutputPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements LoginUserUseCase, RegisterUserUseCase {

    private final UserOutputPort userOutputPort;
    private final EncryptionServicePort encryptionService;
    private final LoggerServicePort loggerService;

    public UserService(UserOutputPort userOutputPort, EncryptionServicePort encryptionService, LoggerServicePort loggerService) {
        this.userOutputPort = userOutputPort;
        this.encryptionService = encryptionService;
        this.loggerService = loggerService;
    }

    @Override
    public User loginUser(String username, String password) {
        Optional<User> userOpt = userOutputPort.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            boolean isValid = encryptionService.verify(password, user.getPassword());
            loggerService.log("Login attempt: " + username + " - " + (isValid ? "SUCCESS" : "FAILURE"));
            if (isValid) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User registerUser(User user) {
        user.setPassword(encryptionService.encrypt(user.getPassword()));
        loggerService.log("User registered: " + user.getUsername());
        return userOutputPort.saveUser(user);
    }
}
