package ru.bvt.studenttestingapp.dao;

import ru.bvt.studenttestingapp.domain.Question;
import ru.bvt.studenttestingapp.domain.QuestionsPackage;

public class QuestionsPackageDaoCSVEdition implements QuestionsPackageDao {

    private QuestionsPackage questionsPackage;
    private CSVDataSource csvDataSource;

    public QuestionsPackageDaoCSVEdition(String filename) {
        csvDataSource = new CSVDataSource(filename);
    }

    public QuestionsPackage getQuestionsPackage() {
        return this.questionsPackage;
    }

    public void init() {

        questionsPackage = new QuestionsPackage();

        String[] tempStringArray;
        String tempString;
        int i = 0;

        tempString = csvDataSource.getRow(i);
        while (tempString != null) {
            tempStringArray = tempString.split(",");
            questionsPackage.questions.add(new Question(i, tempStringArray[0], tempStringArray[1], tempStringArray[2]));
            i++;
            tempString = csvDataSource.getRow(i);
        }

    }


}
