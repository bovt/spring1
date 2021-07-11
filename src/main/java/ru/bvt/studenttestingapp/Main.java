package ru.bvt.studenttestingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import ru.bvt.studenttestingapp.config.AppPropsSimple;
import ru.bvt.studenttestingapp.service.ManagerServiceCSVEdition;

@SpringBootApplication
@EnableConfigurationProperties(AppPropsSimple.class)
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Main.class, args);

        var manager = context.getBean(ManagerServiceCSVEdition.class);
        manager.run();

    }
}
