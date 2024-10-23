package com.lsoria.loginservice.application.port.output;

import com.lsoria.loginservice.domain.model.User;

import java.util.Optional;

public interface UserOutputPort {
    User saveUser(User user);
    Optional<User> findByUsername(String username);
}
