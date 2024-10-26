package com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.logger;

import com.lsoria.loginservice.application.port.output.LoggerServicePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpLoggerAdapter implements LoggerServicePort {
    private static final Logger logger = LoggerFactory.getLogger(HttpLoggerAdapter.class);

    @Override
    public void log(String message) {
        logger.info("Sending log to external URL: {}", message);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://www.sd-bo.com/log.php?log_value=" + message, String.class);
        logger.info("Response from logging server: {}", response);
    }
}

