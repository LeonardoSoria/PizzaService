package com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.encypt;

import com.lsoria.loginservice.application.port.output.EncryptionServicePort;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
public class Sha256EncryptionAdapter implements EncryptionServicePort {

    @Override
    public String encrypt(String plainText) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(plainText.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error while hashing with SHA-256", e);
        }
    }

    @Override
    public boolean verify(String plainText, String encrypted) {
        return encrypt(plainText).equals(encrypted);
    }
}
