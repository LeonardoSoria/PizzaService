package com.loginservice.loginservice.domain.services;

import com.loginservice.loginservice.domain.model.User;
import com.loginservice.loginservice.domain.ports.EncryptionServicePort;
import com.loginservice.loginservice.domain.ports.LoggerServicePort;
import com.loginservice.loginservice.domain.ports.UserRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepositoryPort userRepository;
    private final EncryptionServicePort encryptionService;
    private final LoggerServicePort loggerService;

    public UserService(UserRepositoryPort userRepository, EncryptionServicePort encryptionService, LoggerServicePort loggerService) {
        this.userRepository = userRepository;
        this.encryptionService = encryptionService;
        this.loggerService = loggerService;
    }

    public void registerUser(String username, String email, String password) {
        String encryptedPassword = encryptionService.encrypt(password);
        User user = new User(username, email, encryptedPassword);
        userRepository.save(user);
        loggerService.log("User registered: " + username);
    }

    public boolean loginUser(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            boolean isValid = encryptionService.verify(password, user.getPassword());
            loggerService.log("Login attempt: " + username + " - " + (isValid ? "SUCCESS" : "FAILURE"));
            return isValid;
        }
        return false;
    }
}
