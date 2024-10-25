package com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.encypt;

import com.lsoria.loginservice.application.port.output.EncryptionServicePort;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class BcryptEncryptionAdapter implements EncryptionServicePort {
    @Override
    public String encrypt(String plainText) {
        return BCrypt.hashpw(plainText, BCrypt.gensalt());
    }

    @Override
    public boolean verify(String plainText, String encrypted) {
        return BCrypt.checkpw(plainText, encrypted);
    }
}
