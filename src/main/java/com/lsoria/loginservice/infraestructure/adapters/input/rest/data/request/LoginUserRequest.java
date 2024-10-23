package com.lsoria.loginservice.infraestructure.adapters.input.rest.data.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserRequest {

    @NotEmpty(message = "Username may not be empty")
    private String username;

    @NotEmpty(message = "Password may not be empty")
    private String password;

}
