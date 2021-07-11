package ru.bvt.studenttestingapp.domain;

public class Question {

    private int id;
    private String text;
    private String availableAnswers;
    private String correctAnswer;

    public Question(int id, String text, String availableAnswers, String correctAnswer) {
        this.id = id;
        this.text = text;
        this.availableAnswers = availableAnswers;
        this.correctAnswer = correctAnswer;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getAvailableAnswers() {
        return availableAnswers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    void setId(int id) {
        this.id = id;
    }

    void setText(String text) {
        this.text = text;
    }

    void setAvailableAnswers(String availableAnswers) {
        this.availableAnswers = availableAnswers;
    }

    void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

}
