package com.lsoria.loginservice.infraestructure.adapters.input.rest.data.response;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    @NotEmpty(message = "Username may not be empty")
    private String username;

    @NotEmpty(message = "Email may not be empty")
    private String email;

}
