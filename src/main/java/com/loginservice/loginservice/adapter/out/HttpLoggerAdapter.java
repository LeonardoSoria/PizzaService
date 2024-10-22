package com.loginservice.loginservice.adapter.out;

import com.loginservice.loginservice.domain.ports.LoggerServicePort;
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

