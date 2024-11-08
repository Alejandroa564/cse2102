package com.example.demo.controller;

import com.example.demo.service.PasswordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/password")
public class PasswordController {
    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping("/evaluate")
    public String getPasswordEvaluationPage() {
        return "password"; 
    }

    @PostMapping("/evaluate")
    public String evaluatePassword(@RequestParam String password, Model model) {
        String strength = passwordService.evaluatePasswordStrength(password);
        model.addAttribute("result", strength);
        return "password";
    }
}
