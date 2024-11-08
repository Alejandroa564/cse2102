package com.example.demo.service;

import com.example.demo.model.QuizQuestion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuizServiceTest {

    private QuizService quizService;

    @BeforeEach
    void setUp() {
        quizService = new QuizService(); // Initialize the service (no mocks needed for now)
    }

    @Test
    void testGetQuestions() {
        // Call the service method
        List<QuizQuestion> result = quizService.getQuestions();

        // Verify the result
        assertNotNull(result); // Assert that the result is not null
        assertEquals(3, result.size()); // Verify that there are exactly 3 questions

        // Verify that the questions are correct
        assertEquals("What is the capital of France?", result.get(0).getQuestion());
        assertEquals("Which planet is known as the Red Planet?", result.get(1).getQuestion());
        assertEquals("What is the largest mammal?", result.get(2).getQuestion());
    }

    @Test
    void testCheckAnswer_CorrectAnswer() {
        // Test the method for a correct answer
        boolean result = quizService.checkAnswer(1, 0); // Question 1, Correct answer is index 0 (Paris)

        assertTrue(result); // Assert that the result is true (correct answer)
    }

    @Test
    void testCheckAnswer_IncorrectAnswer() {
        // Test the method for an incorrect answer
        boolean result = quizService.checkAnswer(1, 1); // Question 1, Wrong answer is index 1 (London)

        assertFalse(result); // Assert that the result is false (incorrect answer)
    }

    @Test
    void testCheckAnswer_QuestionNotFound() {
        // Test when a question ID does not exist
        boolean result = quizService.checkAnswer(999, 0); // Non-existent question

        assertFalse(result); // Assert that the result is false (no question found)
    }

    @Test
    void testCheckAnswer_InvalidAnswerIndex() {
        // Test when an invalid answer index is given
        boolean result = quizService.checkAnswer(1, 5); // Invalid answer index

        assertFalse(result); // Assert that the result is false (invalid index)
    }
}
