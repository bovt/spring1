package ru.bvt.studenttestingapp.service;

import org.springframework.stereotype.Service;
import ru.bvt.studenttestingapp.config.AppProps;
import ru.bvt.studenttestingapp.dao.QuestionsPackageDao;
import ru.bvt.studenttestingapp.domain.QuestionsPackage;

@Service
public class StudentTestingServiceCSVEdition implements StudentTestingService {

    private int currentQuestionID = 0;

    private QuestionsPackageDao dao;
    private AppProps props;

    public StudentTestingServiceCSVEdition(AppProps props, QuestionsPackageDao dao) {
        this.props = props;
        this.dao = dao;
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

}
