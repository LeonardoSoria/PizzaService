package com.lsoria.loginservice.application.port.input;

import com.lsoria.loginservice.domain.model.User;

public interface RegisterUserUseCase {
    User registerUser(User user);
}
