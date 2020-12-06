package ru.bvt.studenttestingapp.service;

public interface StudentTestingService {
    void startTest();

    String getNextQuestion();

    String getAvailableAnswersForCurrentQuestion();

    String getCorrectAnswerForCurrentQuestion();

    void putAnswer();

    void getLastTestResults();
}
