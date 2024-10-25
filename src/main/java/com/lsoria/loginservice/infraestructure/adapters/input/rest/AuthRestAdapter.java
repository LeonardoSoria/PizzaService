package com.lsoria.loginservice.infraestructure.adapters.input.rest;

import com.lsoria.loginservice.application.port.input.LoginUserUseCase;
import com.lsoria.loginservice.application.port.input.RegisterUserUseCase;
import com.lsoria.loginservice.domain.model.User;
import com.lsoria.loginservice.infraestructure.adapters.input.rest.data.request.LoginUserRequest;
import com.lsoria.loginservice.infraestructure.adapters.input.rest.data.request.RegisterUserRequest;
import com.lsoria.loginservice.infraestructure.adapters.input.rest.data.response.UserResponse;
import com.lsoria.loginservice.infraestructure.adapters.input.rest.mapper.UserRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthRestAdapter {

    private final RegisterUserUseCase registerUserUseCase;
    private final LoginUserUseCase loginUserUseCase;
    private final UserRestMapper userRestMapper;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody @Valid RegisterUserRequest registerUserRequest) {
        User user = this.userRestMapper.toUser(registerUserRequest);
        user = this.registerUserUseCase.registerUser(user);
        return new ResponseEntity<>(this.userRestMapper.toUserResponse(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody @Valid LoginUserRequest loginUserRequest) {
        User user = this.loginUserUseCase.loginUser(loginUserRequest.getUsername(), loginUserRequest.getPassword());
        return new ResponseEntity<>(this.userRestMapper.toUserResponse(user), HttpStatus.OK);
    }
}

