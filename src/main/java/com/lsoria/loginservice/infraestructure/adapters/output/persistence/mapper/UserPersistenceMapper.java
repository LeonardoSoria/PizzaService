package com.lsoria.loginservice.infraestructure.adapters.output.persistence.mapper;

import com.lsoria.loginservice.domain.model.User;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserPersistenceMapper {

    UserEntity toUserEntity(User user);

    User toUser(UserEntity userEntity);
}
