package com.loginservice.loginservice.adapter.out;

import com.loginservice.loginservice.domain.ports.EncryptionServicePort;
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
