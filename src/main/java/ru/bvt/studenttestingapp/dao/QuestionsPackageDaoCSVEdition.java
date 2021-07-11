package ru.bvt.studenttestingapp.dao;

import org.springframework.stereotype.Component;
import ru.bvt.studenttestingapp.config.AppProps;
import ru.bvt.studenttestingapp.config.AppPropsSimple;
import ru.bvt.studenttestingapp.domain.Question;
import ru.bvt.studenttestingapp.domain.QuestionsPackage;

@Component
public class QuestionsPackageDaoCSVEdition implements QuestionsPackageDao {

    private QuestionsPackage questionsPackage;
    private CSVDataSource csvDataSource;

    public QuestionsPackageDaoCSVEdition(AppProps props) {
        csvDataSource = new CSVDataSource(props.getCsvFilename());
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

    public QuestionsPackage getQuestionsPackage() {
        return this.questionsPackage;
    }


}
