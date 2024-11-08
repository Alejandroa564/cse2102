package com.example.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailServiceTest {

    private EmailService emailService;

    @BeforeEach
    void setUp() {
        emailService = new EmailService(); // Initialize the service
    }

    @Test
    void testIsValidEmail_ValidEmail() {
        // Test for a valid email address
        String email = "user@example.com";
        assertTrue(emailService.isValidEmail(email), "Valid email should return true");
    }

    @Test
    void testIsValidEmail_InvalidEmail_MissingAtSymbol() {
        // Test for an invalid email address (missing '@')
        String email = "userexample.com";
        assertFalse(emailService.isValidEmail(email), "Email without '@' should return false");
    }

    @Test
    void testIsValidEmail_InvalidEmail_InvalidDomain() {
        // Test for an invalid email address (invalid domain)
        String email = "user@com";
        assertFalse(emailService.isValidEmail(email), "Email with invalid domain should return false");
    }

    @Test
    void testIsValidEmail_InvalidEmail_EmptyString() {
        // Test for an invalid email address (empty string)
        String email = "";
        assertFalse(emailService.isValidEmail(email), "Empty email should return false");
    }

    @Test
    void testIsValidEmail_ValidEmailWithSpecialChars() {
        // Test for a valid email address with special characters
        String email = "user.name+tag@example.com";
        assertTrue(emailService.isValidEmail(email), "Valid email with special characters should return true");
    }

    
}
