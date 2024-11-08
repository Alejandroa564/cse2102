package com.example.demo.controller;

import com.example.demo.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/validate")
    public String getEmailValidationPage() {
        return "email"; 
    }

    @PostMapping("/validate")
    public String validateEmail(@RequestParam String email, Model model) {
        boolean isValid = emailService.isValidEmail(email);
        model.addAttribute("result", isValid);
        return "email"; 
    }
    
}
