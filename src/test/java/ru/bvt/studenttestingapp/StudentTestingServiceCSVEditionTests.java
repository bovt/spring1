package ru.bvt.studenttestingapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.bvt.studenttestingapp.dao.QuestionsPackageDao;
import ru.bvt.studenttestingapp.dao.QuestionsPackageDaoCSVEdition;
import ru.bvt.studenttestingapp.service.StudentTestingService;
import ru.bvt.studenttestingapp.service.StudentTestingServiceCSVEdition;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@DisplayName("Сервис StudentTestingServiceCSVEdition должен ")
public class StudentTestingServiceCSVEditionTests {
    @Mock
    private QuestionsPackageDao stappDao;
    private StudentTestingService stappService;

    @BeforeEach
    void setUp() {
        stappDao = new QuestionsPackageDaoCSVEdition("test.csv");
        stappService = new StudentTestingServiceCSVEdition(stappDao);
        stappService.startTest();
    }

    @Test
    @DisplayName(" возвращать в методе метод getNextQuestion непустую строку")
    void getNextQuestionShouldReturnNonEmptyString() {
        String outStr = stappService.getNextQuestion();
        assertThat(outStr)
                .isNotNull();
        assertThat(outStr.length()==0)
                .isFalse();
    }

}