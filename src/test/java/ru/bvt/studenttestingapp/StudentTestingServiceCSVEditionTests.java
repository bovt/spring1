package ru.bvt.studenttestingapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.bvt.studenttestingapp.config.AppPropsForTests;
import ru.bvt.studenttestingapp.config.AppPropsSimple;
import ru.bvt.studenttestingapp.dao.QuestionsPackageDao;
import ru.bvt.studenttestingapp.dao.QuestionsPackageDaoCSVEdition;
import ru.bvt.studenttestingapp.domain.QuestionsPackage;
import ru.bvt.studenttestingapp.service.StudentTestingService;
import ru.bvt.studenttestingapp.service.StudentTestingServiceCSVEdition;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@EnableConfigurationProperties(AppPropsSimple.class)
@DisplayName("Сервис StudentTestingServiceCSVEdition должен ")
public class StudentTestingServiceCSVEditionTests {

    @Mock
    private StudentTestingService stappService;

    @Mock
    private QuestionsPackageDao stappDao;
    private AppPropsForTests props;

    @BeforeEach
    void setUp() {
        props = new AppPropsForTests();
        stappDao = new QuestionsPackageDaoCSVEdition(props);
        stappService = new StudentTestingServiceCSVEdition(props, stappDao);
    }

    @Test
    @DisplayName(" возвращать непустую строку в методе getNextQuestion")
    void getNextQuestionShouldReturnNonEmptyString() {
        String outStr = stappService.getNextQuestion();
        assertThat(outStr)
                .isNotNull();
        assertThat(outStr.length() == 0)
                .isFalse();
    }

    @Test
    @DisplayName(" возвращать в getNextQuestion столько вопросов сколько строк в dao")
    void getNextQuestionShouldReturnQuestionsForAllDAORows() {
        Integer questionsCount = 0;
        QuestionsPackage questionsPackage = stappDao.getQuestionsPackage();

        while (stappService.getNextQuestion() != null) {
            questionsCount += 1;
        }
        assertThat(questionsCount)
                .isEqualTo(questionsPackage.questions.size());
    }

}