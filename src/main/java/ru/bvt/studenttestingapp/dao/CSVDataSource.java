package ru.bvt.studenttestingapp.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class CSVDataSource {

    public CSVDataSource(String filename) {
        ClassLoader classLoader = getClass().getClassLoader();

        try {
            file = new File(classLoader.getResource(filename).getFile());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private File file;

    String getRow(int id) {
        String result = null;
        try {
            int counter = 0;
            BufferedReader reader;
            FileReader fr = new FileReader(file);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            result = line;
            while ((line != null) && (counter < id)) {
                line = reader.readLine();
                if (line == null) {
                    return null;
                }
                result = line;
                counter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
