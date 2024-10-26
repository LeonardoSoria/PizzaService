package com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter;

import com.lsoria.loginservice.application.port.output.EncryptionServicePort;
import com.lsoria.loginservice.application.port.output.LoggerServicePort;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.encypt.AesEncryptionAdapter;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.encypt.BcryptEncryptionAdapter;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.encypt.Sha256EncryptionAdapter;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.logger.DbLoggerAdapter;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.logger.FileLoggerAdapter;
import com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.logger.HttpLoggerAdapter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EncryptionStrategyFactory {

    private final Map<String, EncryptionServicePort> strategies = new HashMap<>();

    public EncryptionStrategyFactory(BcryptEncryptionAdapter bcryptEncryptionAdapter,
                                     Sha256EncryptionAdapter sha256EncryptionAdapter,
                                     AesEncryptionAdapter aesEncryptionAdapter) {
        strategies.put("BCRYPT", bcryptEncryptionAdapter);
        strategies.put("SHA256", sha256EncryptionAdapter);
        strategies.put("AES", aesEncryptionAdapter);
    }

    public EncryptionServicePort getEncryptionStrategy(String encryptionType) {
        return strategies.getOrDefault(encryptionType.toUpperCase(), strategies.get("BCRYPT")); // Default to BCRYPT if not found
    }
}
