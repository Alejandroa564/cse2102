package com.example.demo.controller;

import com.example.demo.service.QuizService;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/quiz")
    public String getQuizPage(Model model) {
        model.addAttribute("questions", quizService.getQuestions());
        return "quiz"; 
    }

    @PostMapping("/quiz/res")
    public String submitQuiz(@RequestParam Map<String, String> answers, Model model) {
        int correctCount = 0;

        for (var entry : answers.entrySet()) {
            int questionId = Integer.parseInt(entry.getKey().replace("question_", ""));
            int selectedAnswer = Integer.parseInt(entry.getValue());

            if (quizService.checkAnswer(questionId, selectedAnswer)) {
                correctCount++;
            }
        }

        model.addAttribute("score", correctCount);
        model.addAttribute("total", quizService.getQuestions().size());
        return "result"; 
    }
    @GetMapping("/quiz/questions")
    public ResponseEntity<?> getQuestions() {
        return ResponseEntity.ok(quizService.getQuestions());
    }

    @PostMapping("quiz/answer")
    public ResponseEntity<Boolean> answerQuestion(@RequestParam int questionId, @RequestParam int selectedAnswerIndex) {
        return ResponseEntity.ok(quizService.checkAnswer(questionId, selectedAnswerIndex));
    }
}
