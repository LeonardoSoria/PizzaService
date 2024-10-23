package com.lsoria.loginservice.infraestructure.adapters.input.rest.mapper;

import com.lsoria.loginservice.domain.model.User;
import com.lsoria.loginservice.infraestructure.adapters.input.rest.data.request.RegisterUserRequest;
import com.lsoria.loginservice.infraestructure.adapters.input.rest.data.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper
public interface UserRestMapper {

    User toUser(RegisterUserRequest registerUserRequest);

    UserResponse toUserResponse(User user);
}
