package ru.bvt.studenttestingapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@ConfigurationProperties(prefix = "stapp")
public class AppPropsSimple implements AppProps {

    private String csvFilenamePrefix;
    private Locale locale = new Locale("en");

    public String getCsvFilename() {
        return new String(csvFilenamePrefix + locale.toString() + ".csv");
    }

    public void setCsvFilenamePrefix(String csvFilenamePrefix) {
        this.csvFilenamePrefix = csvFilenamePrefix;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = new Locale(locale);
    }

}
