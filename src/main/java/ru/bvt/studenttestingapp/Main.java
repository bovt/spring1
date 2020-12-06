package ru.bvt.studenttestingapp;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.bvt.studenttestingapp.service.StudentTestingService;

//@SpringBootApplication
public class Main {

    public static void main(String[] args) {

//		SpringApplication.run(StudentTestingBvtApp.class, args);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        StudentTestingService testService = context.getBean(StudentTestingService.class);

        int i = 0;
        String outStr;

        testService.startTest();

        outStr = testService.getNextQuestion();
        while (outStr != null) {
            System.out.println("Question: " + outStr);
            System.out.println("Available answers: " + testService.getAvailableAnswersForCurrentQuestion());

            outStr = testService.getNextQuestion();
            //testService.PutAnswer();
        }

        // testService.GetLastTestResults();


    }

}
