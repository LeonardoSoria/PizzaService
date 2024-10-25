package com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.logger;

import com.lsoria.loginservice.application.port.output.LoggerServicePort;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.entity.LogEntryEntity;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.repository.LogEntryRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DbLoggerAdapter implements LoggerServicePort {

    private final LogEntryRepository logEntryRepository;

    public DbLoggerAdapter(LogEntryRepository logEntryRepository) {
        this.logEntryRepository = logEntryRepository;
    }

    @Override
    public void log(String message) {
        LogEntryEntity logEntry = LogEntryEntity.builder()
                .message(message)
                .timestamp(LocalDateTime.now().toString())
                .build();
        logEntryRepository.save(logEntry);
    }
}
