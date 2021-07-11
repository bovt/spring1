package ru.bvt.studenttestingapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

public class AppPropsForTests implements AppProps {

    private Locale locale = new Locale("en");

    public String getCsvFilename() {
        return new String("test_EN.csv");
    }

    public Locale getLocale() {
        return locale;
    }
}
