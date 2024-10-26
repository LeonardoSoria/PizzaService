package com.lsoria.loginservice.application.service;

import com.lsoria.loginservice.application.port.input.ConfigStrategyUseCase;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.EncryptionStrategyFactory;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.LoggerStrategyFactory;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConfigStrategyService implements ConfigStrategyUseCase {

    private final UserService userService;
    private final EncryptionStrategyFactory encryptionStrategyFactory;
    private final LoggerStrategyFactory loggerStrategyFactory;

    @Override
    public boolean changeStrategies(String encryptionType, String loggerType) {
        userService.setEncryptionService(encryptionStrategyFactory.getEncryptionStrategy(encryptionType));
        userService.setLoggerService(loggerStrategyFactory.getLoggerStrategy(loggerType));
        return true;
    }
}
