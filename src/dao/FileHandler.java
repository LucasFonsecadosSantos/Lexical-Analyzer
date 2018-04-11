package dao;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

/**
 * 
 */
public class FileHandler {
    
    public static List<String> getSourceCode(String fileName) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String tmpLine;
            List<String> sourceCode = new ArrayList<String>();
            while((tmpLine = bufferedReader.readLine()) != null) {
                sourceCode.add(tmpLine);
            }
            return sourceCode;
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.toString());
        } catch (IOException ioe) {
            System.out.println(ioe.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }
}