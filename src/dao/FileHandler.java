/**
 * PRATICAL PROJECT STEP 01
 * Federal University of Lavras (UFLA)
 * Compilers Discipline
 * 
 * Lexical Analyzer from pratical project step 01 for
 * compilers discipline.
 * 
 * This compiler works with the J-- language, specified
 * by document attached to this software documentation.
 * 
 * by:
 * Lucas Fonseca dos Santos      [201712078]
 * Igor Augusto da Costa Nunes   [201420447]
 * Alan Luz Silveira             [201421560]
 * Igor Emanuel Carvalho da Cruz [201621230]
 * 
 * GITHUB: https://github.com/LucasFonsecadosSantos
 *         https://github.com/Inuness
 *         https://github.com/alanluz
 * 
 */
package dao;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

/**
 * This class manipulates any file operations.
 * It's responsible for reads and writes the input
 * and output files.
 * 
 * @author Lucas Fonseca Dos Santos
 * @author Igor Augusto da Costa Nunes
 * @author Alan Luz Silveira
 * @author Igor Emanuel Carvalho da Cruz
 * @version 1.0
 * @since 1.0
 */
public class FileHandler {
    
    /**
     * This method is responsible for get all source code 
     * content and return this by List.
     * 
     * @param fileName The file path name for read operation.
     * @return List A source code data.
     */
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