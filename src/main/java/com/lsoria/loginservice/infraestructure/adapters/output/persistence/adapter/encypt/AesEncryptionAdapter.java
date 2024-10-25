package com.lsoria.loginservice.infraestructure.adapters.output.persistence.adapter.encypt;

import com.lsoria.loginservice.application.port.output.EncryptionServicePort;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Component
public class AesEncryptionAdapter implements EncryptionServicePort {

    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "MySecretKey12345";

    @Override
    public String encrypt(String plainText) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error while encrypting with AES", e);
        }
    }

    @Override
    public boolean verify(String plainText, String encrypted) {
        return encrypt(plainText).equals(encrypted);
    }
}
