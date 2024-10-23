package com.lsoria.loginservice.application.port.output;

public interface EncryptionServicePort {
    String encrypt(String password);
    boolean verify(String rawPassword, String encryptedPassword);
}
