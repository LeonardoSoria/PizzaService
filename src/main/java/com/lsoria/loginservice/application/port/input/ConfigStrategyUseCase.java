package com.lsoria.loginservice.application.port.input;

public interface ConfigStrategyUseCase {
    boolean changeStrategies(String encryptionType, String loggerType);
}
