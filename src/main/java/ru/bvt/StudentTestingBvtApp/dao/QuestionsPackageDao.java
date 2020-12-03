package ru.bvt.StudentTestingBvtApp.dao;

import ru.bvt.StudentTestingBvtApp.domain.Question;
import ru.bvt.StudentTestingBvtApp.domain.QuestionsPackage;

public interface QuestionsPackageDao {

    QuestionsPackage GetQuestionsPackage();
    void init();
}
