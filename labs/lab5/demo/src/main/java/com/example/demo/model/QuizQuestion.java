package com.example.demo.model;

import java.util.List;

public class QuizQuestion {
    private int id;
    private String question;
    private List<String> options;
    private int correctAnswerIndex; // Stores the index of the correct answer

    // Constructor
    public QuizQuestion(int id, String question, List<String> options,int correctAnswerIndex) {
        this.id = id;
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public void setCorrectAnswerIndex(int correctAnswerIndex) {
        this.correctAnswerIndex = correctAnswerIndex;
    }
    
    public String getCorrectAnswer() {
        return options.get(correctAnswerIndex);
    }
}