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
import ru.bvt.studenttestingapp.domain.Question;
import ru.bvt.studenttestingapp.domain.QuestionsPackage;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@EnableConfigurationProperties(AppPropsSimple.class)
@DisplayName("Сервис QuestionsPackageDaoCSVEdition должен ")
public class QuestionsPackageDaoCSVEditionTests {

    @Mock
    private QuestionsPackageDao stappDao;
    private AppPropsForTests props;

    @BeforeEach
    void setUp() {
        props = new AppPropsForTests();
        stappDao = new QuestionsPackageDaoCSVEdition(props);
    }

    @Test
    @DisplayName(" возвращать в getQuestionsPackage сущности с непустыми значениями полей")
    void getNextQuestionShouldReturnNonEmptyString() {
        QuestionsPackage questionsPackage = stappDao.getQuestionsPackage();

        Integer checker = 1;

        for (int i = 0; i < questionsPackage.questions.size(); i++) {
            Question question = questionsPackage.questions.get(i);
            checker = (checker
                    * question.getText().length()
                    * question.getCorrectAnswer().length()
                    * question.getAvailableAnswers().length() > 0) ? 1 : 0;
        }

        assertThat(checker)
                .isEqualTo(1);
    }
}