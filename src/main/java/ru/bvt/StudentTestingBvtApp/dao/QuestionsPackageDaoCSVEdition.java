package ru.bvt.StudentTestingBvtApp.dao;

import ru.bvt.StudentTestingBvtApp.domain.Question;
import ru.bvt.StudentTestingBvtApp.domain.QuestionsPackage;

public class QuestionsPackageDaoCSVEdition implements QuestionsPackageDao {

    // correct
    public QuestionsPackage GetQuestionsPackage() {
        return this.fq;
    }

    // !!!! all above probably incorrect, from daotry
    // rename tfd
    private QuestionsPackage fq;
    CSVDataSource tfd;

    public QuestionsPackageDaoCSVEdition() {
//    public QuestionsPackageDaoCSVEdition(String fileName) {
        //    !!!!  tfd = new TestFileDataSource(fileName);
        tfd = new CSVDataSource("test.csv");
    }

    public void init() {

        fq = new QuestionsPackage();

        // нормализовать имена
        String[] tempString;
        String tempString2;

        int i=0;

        Question currentQuestion;

        tempString2 = tfd.GetRow(i);
        while ( tempString2!=null ) {
            tempString = tempString2.split(",");
            currentQuestion = new Question("init", "initcorransw");
            currentQuestion.text = tempString[0];
            currentQuestion.availableAnswers = tempString[1];
            currentQuestion.correctAnswer = tempString[2];
            currentQuestion.givenAnswer = null;

            // ОТМЕНА сделать функцию add, которая сама создаёт объект? Мы не должны в dao передавать отдельные поля, а должны вот так создать объект и передать
            // создавать прямо внутри запроса в скобках вот тут:
            fq.questions.add(currentQuestion);

            i++;
            tempString2 = tfd.GetRow(i);
        }
    }



}
