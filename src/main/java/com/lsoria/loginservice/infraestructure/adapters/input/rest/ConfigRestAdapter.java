package com.lsoria.loginservice.infraestructure.adapters.input.rest;

import com.lsoria.loginservice.application.service.UserService;
import com.lsoria.loginservice.infraestructure.adapters.config.BeanConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/config")
public class ConfigRestAdapter {

    @PostMapping("/update")
    public String updateConfig(
            @RequestParam String encryptionType,
            @RequestParam String loggerType) {

        return "UserService configuration updated successfully";
    }
}
