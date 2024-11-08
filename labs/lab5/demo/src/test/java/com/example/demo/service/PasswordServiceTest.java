package com.example.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordServiceTest {

    private PasswordService passwordService;

    @BeforeEach
    void setUp() {
        passwordService = new PasswordService(); // Initialize the service
    }

    @Test
    void testEvaluatePasswordStrength_WeakPassword() {
        // Test for a weak password (less than 8 characters)
        String result = passwordService.evaluatePasswordStrength("short");

        // Assert that the result is "Weak"
        assertEquals("Weak", result);
    }

    @Test
    void testEvaluatePasswordStrength_StrongPassword() {
        // Test for a strong password (contains uppercase letter and special character)
        String result = passwordService.evaluatePasswordStrength("Strong@2024");

        // Assert that the result is "Strong"
        assertEquals("Strong", result);
    }

    @Test
    void testEvaluatePasswordStrength_ModeratePassword() {
        // Test for a moderate password (contains either an uppercase letter or a special character, but not both)
        String result = passwordService.evaluatePasswordStrength("Moderate1");

        // Assert that the result is "Moderate"
        assertEquals("Moderate", result);
    }

    @Test
    void testEvaluatePasswordStrength_PasswordWithNoUppercase() {
        // Test for a password with no uppercase letters
        String result = passwordService.evaluatePasswordStrength("weakpassword1!");

        // Assert that the result is "Moderate"
        assertEquals("Moderate", result);
    }

    @Test
    void testEvaluatePasswordStrength_PasswordWithNoSpecialCharacter() {
        // Test for a password with no special characters
        String result = passwordService.evaluatePasswordStrength("WeakPassword1");

        // Assert that the result is "Moderate"
        assertEquals("Moderate", result);
    }
}
