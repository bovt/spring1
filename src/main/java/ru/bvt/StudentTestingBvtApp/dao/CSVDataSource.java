package ru.bvt.StudentTestingBvtApp.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class CSVDataSource {

    public CSVDataSource (String strfile) {
        System.out.println("CSVDataSource Constructor from "+strfile);

        ClassLoader classLoader = getClass().getClassLoader();
        file = new File(classLoader.getResource(strfile).getFile());
// добавить проверку null при getFile
        System.out.println("OK CSVDataSource Constructor from "+file);
    }

    int CountRows() {return 15;}
    // !!!!!!!!!!!!!!!!

    private File file;

    String GetRow(int id) {
        String result=null;
        try {
            int counter=0;
            BufferedReader reader;
            FileReader fr = new FileReader(file);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            result=line;
            while ((line != null) && (counter <id)) {
 //               System.out.println("DS: GetRow"+line);
                line = reader.readLine();
                if (line==null) {return null;}
                result=line;
                counter++;
            }
 //           System.out.println("DS: res="+result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
