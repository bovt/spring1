package ru.bvt.studenttestingapp.service;

public interface StudentTestingService {

    String getNextQuestion();

    String getAvailableAnswersForCurrentQuestion();

    String getCorrectAnswerForCurrentQuestion();

}
