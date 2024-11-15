package com.lsoria.pizzaservice.infraestructure.adapters.input.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/config")
@RequiredArgsConstructor
public class ConfigRestAdapter {

    private final ConfigStrategyUseCase configStrategyUseCase;
    @PostMapping("/update")
    public String updateConfig(@RequestParam String encryptionType, @RequestParam String loggerType) {
        boolean res = this.configStrategyUseCase.changeStrategies(encryptionType, loggerType);
        if (res) {
            return "UserService configuration updated successfully";
        }
        return "UserService configuration could not be updated";
    }
}
