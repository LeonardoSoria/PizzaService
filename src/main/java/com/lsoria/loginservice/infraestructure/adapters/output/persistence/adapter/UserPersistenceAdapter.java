package com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter;

import com.lsoria.loginservice.domain.model.User;
import com.lsoria.loginservice.application.port.output.UserOutputPort;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.entity.UserEntity;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.mapper.UserPersistenceMapper;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserOutputPort {
    private final UserRepository userRepository;
    private final UserPersistenceMapper userPersistenceMapper;

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = this.userPersistenceMapper.toUserEntity(user);
        userEntity = this.userRepository.save(userEntity);
        return this.userPersistenceMapper.toUser(userEntity);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        Optional<UserEntity> userEntityOptional = this.userRepository.findByUsername(username);
        return userEntityOptional.map(userPersistenceMapper::toUser);
    }
}

