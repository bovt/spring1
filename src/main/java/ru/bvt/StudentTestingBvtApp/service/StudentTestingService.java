package ru.bvt.StudentTestingBvtApp.service;

import ru.bvt.StudentTestingBvtApp.dao.QuestionsPackageDao;

public interface StudentTestingService {

// correct not adapted
// Person getByName(String name);

    // проверить имена методов по требованиям к именованию
    String GetNextQuestion();
    void StartTest();
    void PutAnswer();
    void GetLastTestResults();
    String GetAvailableAnswersForCurrentQuestion();
    String GetCorrectAnswersForCurrentQuestion();
}
