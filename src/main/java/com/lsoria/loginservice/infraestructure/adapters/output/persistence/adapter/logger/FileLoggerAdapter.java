package com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.logger;

import com.lsoria.loginservice.application.port.output.LoggerServicePort;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class FileLoggerAdapter implements LoggerServicePort {

    private static final String LOG_FILE_PATH = "application.log";

    @Override
    public void log(String message) {
        try (FileWriter fileWriter = new FileWriter(LOG_FILE_PATH, true)) {
            fileWriter.write(LocalDateTime.now() + " - " + message + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Error writing log to file", e);
        }
    }
}
