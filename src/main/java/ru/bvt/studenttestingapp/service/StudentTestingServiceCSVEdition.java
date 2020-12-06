package ru.bvt.studenttestingapp.service;

import ru.bvt.studenttestingapp.dao.QuestionsPackageDao;
import ru.bvt.studenttestingapp.domain.QuestionsPackage;

public class StudentTestingServiceCSVEdition implements StudentTestingService {

    private int currentQuestionID = 0;
    private final QuestionsPackageDao dao;

    public StudentTestingServiceCSVEdition(QuestionsPackageDao dao) {
        this.dao = dao;

        // !!!!! как то нужно сообщить расположение csv
        //        this.dao = new TestFileDao("test.csv");
    }

    public void startTest() {
        dao.init();
    }

    public String getNextQuestion() {
        QuestionsPackage questionsPackage = dao.getQuestionsPackage();

        currentQuestionID++;
        if (questionsPackage.questions.size() >= currentQuestionID) {
            return questionsPackage.questions.get(currentQuestionID - 1).getText();
        } else {
            return null;
        }
    }

    public String getAvailableAnswersForCurrentQuestion() {
        return dao.getQuestionsPackage().questions.get(currentQuestionID - 1).getAvailableAnswers();
    }

    public String getCorrectAnswerForCurrentQuestion() {
        return dao.getQuestionsPackage().questions.get(currentQuestionID - 1).getCorrectAnswer();
    }


    public void putAnswer() {
        System.out.println("SVC: PutAnswer");
    }

    public void getLastTestResults() {
        System.out.println("SVC: GetLastTestResults");
    }


}
