package com.example.demo.service;

import com.example.demo.model.QuizQuestion;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class QuizService {
    private final List<QuizQuestion> questions = Arrays.asList(
        new QuizQuestion(1, "What is the capital of France?", 
            Arrays.asList("Paris", "London", "Berlin", "Rome"), 0),
        
        new QuizQuestion(2, "Which planet is known as the Red Planet?", 
            Arrays.asList("Earth", "Mars", "Jupiter", "Saturn"), 1),
        
        new QuizQuestion(3, "What is the largest mammal?", 
            Arrays.asList("Elephant", "Blue Whale", "Giraffe", "Hippopotamus"), 1)
    );


    public List<QuizQuestion> getQuestions() {
        return questions;
    }

    public boolean checkAnswer(int questionId, int selectedAnswerIndex) {
        return questions.stream()
                .filter(q -> q.getId() == questionId)
                .anyMatch(q -> q.getCorrectAnswerIndex() == selectedAnswerIndex);
    }
}
