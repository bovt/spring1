package ru.bvt.StudentTestingBvtApp;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.bvt.StudentTestingBvtApp.service.StudentTestingService;

//@SpringBootApplication
public class StudentTestingBvtApp {

	public static void main(String[] args) {

//		SpringApplication.run(StudentTestingBvtApp.class, args);

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
		StudentTestingService testService = context.getBean(StudentTestingService.class);

//		Person ivan = service.getByName("Ivan");
//		System.out.println("name: " + ivan.getName() + " age: " + ivan.getAge());
		int i=0;
		String outStr;

		System.out.println("MAIN: StartTest");
		testService.StartTest();

		outStr = testService.GetNextQuestion();
		while (outStr != null) {
			System.out.println("Question: " + outStr);
			System.out.println("Available answer: " + testService.GetAvailableAnswersForCurrentQuestion());

			outStr = testService.GetNextQuestion();
			//testService.PutAnswer();
		}

		// testService.GetLastTestResults();



	}

}
