package com.lsoria.loginservice.infraestructure.adapters.output.persistence;

import com.lsoria.loginservice.application.port.output.LoggerServicePort;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpLoggerAdapter implements LoggerServicePort {
    @Override
    public void log(String message) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject("http://www.sd-bo.com/log.php?log_value=" + message, String.class);
    }
}

