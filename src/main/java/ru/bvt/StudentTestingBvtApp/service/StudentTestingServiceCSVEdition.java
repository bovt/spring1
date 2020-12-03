package ru.bvt.StudentTestingBvtApp.service;

import ru.bvt.StudentTestingBvtApp.dao.QuestionsPackageDao;
import ru.bvt.StudentTestingBvtApp.dao.QuestionsPackageDaoCSVEdition;
import ru.bvt.StudentTestingBvtApp.domain.QuestionsPackage;

public class StudentTestingServiceCSVEdition implements StudentTestingService {

    // probably incorrect
    int currentquestionid=0;

    // correct
    private final QuestionsPackageDao dao;

    public StudentTestingServiceCSVEdition (QuestionsPackageDao dao) {
        this.dao = dao;

        // !!!!! как то нужно сообщить расположение csv
        //        this.dao = new TestFileDao("test.csv");

        System.out.println("StudentTestingServiceCSVEdition Constructor");

    }


    // correct, not adapted
    // public Person getByName(String name) {
    //     return dao.findByName(name);
    // }

    // probably incorrect
    public void StartTest() {
        System.out.println("SVC: StartTest");
        dao.init();
    }

    public String GetNextQuestion() {
//        System.out.println("SVC: GetNextQuestion");
        QuestionsPackage fq_gnq = dao.GetQuestionsPackage();
//        currentquestionid++;
//        return fq_gnq.questions.get(currentquestionid-1).text;
        currentquestionid++;
        if (fq_gnq.questions.size()>=currentquestionid)
        {
            return fq_gnq.questions.get(currentquestionid - 1).text;
        }
        else
        { return null;}

        // !!! сделать вот так перебор
       // System.out.printf("ArrayList has %d elements \n", people.size());
//        for(String person : people){
//            System.out.println(person);
//        }

    }
    public String GetAvailableAnswersForCurrentQuestion() {
        return dao.GetQuestionsPackage().questions.get(currentquestionid-1).getAvailableAnswers();
    }
    public String GetCorrectAnswersForCurrentQuestion() {
        return dao.GetQuestionsPackage().questions.get(currentquestionid-1).getCorrectAnswer();
    }


    public void PutAnswer() {
        System.out.println("SVC: PutAnswer");
    }

    public void GetLastTestResults() {
        System.out.println("SVC: GetLastTestResults");
    }


}
