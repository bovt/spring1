package ru.bvt.studenttestingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.bvt.studenttestingapp.config.AppProps;
import ru.bvt.studenttestingapp.config.AppPropsSimple;

import java.util.Scanner;

@Service
public class ManagerServiceCSVEdition implements ManagerService {

    @Autowired
    private StudentTestingService testingService;

    @Autowired
    private AppProps props;

    private final MessageSource messageSource;


    public ManagerServiceCSVEdition(MessageSource messageSource, AppProps props) {
        this.props = props;
        this.messageSource = messageSource;
    }

    public void run() {
        int questionsCount = 0, correctAnswersCount = 0;
        String outStr, inStr;
        Scanner in = new Scanner(System.in);

        outStr = this.testingService.getNextQuestion();
        while (outStr != null) {
            questionsCount += 1;
            System.out.println(messageSource.getMessage("interact.prequestion", null, props.getLocale()) + outStr);
            System.out.println(messageSource.getMessage("interact.preavailableanswers", null, props.getLocale()) + this.testingService.getAvailableAnswersForCurrentQuestion());
            inStr = in.nextLine();
            if (inStr.equalsIgnoreCase(this.testingService.getCorrectAnswerForCurrentQuestion())) {
                correctAnswersCount += 1;
            }
            ;
            outStr = this.testingService.getNextQuestion();
        }

        in.close();
        if (questionsCount == 0) {
            return;
        }
        if (correctAnswersCount == questionsCount) {
            System.out.println(messageSource.getMessage("result.passed", null, props.getLocale()));
        } else {
            System.out.println(messageSource.getMessage("result.failed", null, props.getLocale()));
        }

    }

    ;

}
