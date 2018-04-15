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
 * Lucas Fonseca dos Santos    [201712078]
 * Igor Augusto da Costa Nunes [201420447]
 * Alan Luz Silveira           [201420...]
 * 
 * GITHUB: https://github.com/LucasFonsecadosSantos
 *         https://github.com/Inuness
 *         https://github.com/alanluz
 * 
 */
package utils;
import java.util.Map;
import java.util.LinkedHashMap;
import model.ErrorType;

public class LexicalErrors {
    
    private Map<ErrorType, Integer> errorsList = new LinkedHashMap<ErrorType, Integer>();
    protected static ErrorType type;

    public LexicalErrors() {
        this.errorsList = new LinkedHashMap<ErrorType, Integer>();
    }

    public void addError(ErrorType type, int lineNumber) {
        this.errorsList.put(type, lineNumber);
    }

    public Map<ErrorType, Integer> getErrors() {
        return this.errorsList;
    }
}