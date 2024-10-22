package com.loginservice.loginservice.domain.ports;

import com.loginservice.loginservice.domain.model.User;

import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findByUsername(String username);
}
