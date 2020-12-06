package ru.bvt.studenttestingapp.dao;

import ru.bvt.studenttestingapp.domain.QuestionsPackage;

public interface QuestionsPackageDao {

    QuestionsPackage getQuestionsPackage();

    void init();
}
