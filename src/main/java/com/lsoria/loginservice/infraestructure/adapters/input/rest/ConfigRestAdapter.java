// ConfigRestAdapter.java
package com.lsoria.loginservice.infraestructure.adapters.input.rest;

import com.lsoria.loginservice.application.service.UserService;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.EncryptionStrategyFactory;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.LoggerStrategyFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/config")
public class ConfigRestAdapter {

    private final UserService userService;
    private final EncryptionStrategyFactory encryptionStrategyFactory;
    private final LoggerStrategyFactory loggerStrategyFactory;

    public ConfigRestAdapter(UserService userService, EncryptionStrategyFactory encryptionStrategyFactory,
                             LoggerStrategyFactory loggerStrategyFactory) {
        this.userService = userService;
        this.encryptionStrategyFactory = encryptionStrategyFactory;
        this.loggerStrategyFactory = loggerStrategyFactory;
    }

    @PostMapping("/update")
    public String updateConfig(@RequestParam String encryptionType, @RequestParam String loggerType) {
        userService.setEncryptionService(encryptionStrategyFactory.getEncryptionStrategy(encryptionType));
        userService.setLoggerService(loggerStrategyFactory.getLoggerStrategy(loggerType));

        return "UserService configuration updated successfully";
    }
}
