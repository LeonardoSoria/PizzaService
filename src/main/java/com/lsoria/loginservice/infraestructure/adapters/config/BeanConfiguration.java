package com.lsoria.loginservice.infraestructure.adapters.config;

import com.lsoria.loginservice.application.service.ConfigStrategyService;
import com.lsoria.loginservice.application.service.UserService;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.EncryptionStrategyFactory;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.LoggerStrategyFactory;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.UserPersistenceAdapter;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.encypt.BcryptEncryptionAdapter;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.logger.HttpLoggerAdapter;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.mapper.UserPersistenceMapper;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserPersistenceAdapter userPersistenceAdapter(final UserRepository userRepository, final UserPersistenceMapper userPersistenceMapper) {
        return new UserPersistenceAdapter(userRepository, userPersistenceMapper);
    }

    @Bean
    public UserService userService(final UserPersistenceAdapter userPersistenceAdapter, final BcryptEncryptionAdapter bcryptEncryptionAdapter, final HttpLoggerAdapter httpLoggerAdapter) {
        return new UserService(userPersistenceAdapter, bcryptEncryptionAdapter, httpLoggerAdapter);
    }

    @Bean
    public ConfigStrategyService configStrategyService(final UserService userService, final EncryptionStrategyFactory encryptionStrategyFactory, final LoggerStrategyFactory loggerStrategyFactory) {
        return new ConfigStrategyService(userService, encryptionStrategyFactory, loggerStrategyFactory);
    }

}
