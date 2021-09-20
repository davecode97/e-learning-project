package com.amdocs.training.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "123456789";
        String encodePassword = encoder.encode(rawPassword);

        System.out.println(encodePassword);
    }
}
