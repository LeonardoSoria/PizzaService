package com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter;

import com.lsoria.loginservice.application.port.output.LoggerServicePort;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.logger.DbLoggerAdapter;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.logger.FileLoggerAdapter;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.logger.HttpLoggerAdapter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LoggerStrategyFactory {

    private final Map<String, LoggerServicePort> strategies = new HashMap<>();

    public LoggerStrategyFactory(HttpLoggerAdapter httpLoggerAdapter, FileLoggerAdapter fileLoggerAdapter,
                                 DbLoggerAdapter dbLoggerAdapter) {
        strategies.put("HTTP", httpLoggerAdapter);
        strategies.put("FILE", fileLoggerAdapter);
        strategies.put("DB", dbLoggerAdapter);
    }

    public LoggerServicePort getLoggerStrategy(String loggerType) {
        return strategies.getOrDefault(loggerType.toUpperCase(), strategies.get("HTTP")); // Default to HTTP if not found
    }
}
