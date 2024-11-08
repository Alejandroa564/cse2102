package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    public String evaluatePasswordStrength(String password) {
        if (password.length() < 8) {
            return "Weak";
        } else if (password.matches(".*[A-Z].*") && password.matches(".*[!@#&()–[{}]:;',?/*~$^+=<>].*")) {
            return "Strong";
        }
        return "Moderate";
    }
}
