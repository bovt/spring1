package ru.bvt.StudentTestingBvtApp.domain;

public class Question {

    // incorrect
    public int id;
    public String text;
    public String availableAnswers;
    public String correctAnswer;
    public String givenAnswer;

    // correct
//    private final String text;
//    private final String availableAnswers;
//    private final String correctAnswer;
//    private final String givenAnswer;

// incorrect
    public Question() {}

    public Question(String text, String correctAnswer) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.givenAnswer = null;
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
    public String getGivenAnswer() {
        return givenAnswer;
    }

}
