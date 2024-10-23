package com.lsoria.loginservice.application.port.input;

import com.lsoria.loginservice.domain.model.User;

public interface LoginUserUseCase {
    User loginUser(String username, String password);
}
