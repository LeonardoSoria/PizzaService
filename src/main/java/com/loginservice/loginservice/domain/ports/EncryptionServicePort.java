package com.loginservice.loginservice.domain.ports;

public interface EncryptionServicePort {
    String encrypt(String password);
    boolean verify(String rawPassword, String encryptedPassword);
}
