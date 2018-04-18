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
    
    private int lineNumber;
    private int columnNumber;
    private String description;
    protected static ErrorType type;

    public LexicalErrors(ErrorType type, int lineNumber, int columnNumber) {
        setType(type);
        setLineNumber(lineNumber);
        setColumnNumber(columnNumber);
        setDescription(type);
    }

    public String getDescription() {
        return this.description;
    }

    public ErrorType getType() {
        return this.type;
    }

    public int getLine() {
        return this.lineNumber;
    }

    public int getColumn() {
        return this.columnNumber;
    }

    private void setType(ErrorType type) {
        this.type = type;
    }

    private void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    private void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    private void setDescription(ErrorType type) {
        switch(type) {
            case INVALID_LEXEME_ERR:
                this.description = "You have a " 
                + "invalid identifier or reservated"
                + "word. Please, you must fix this to"
                + "contninue";
                break;
            case INVALID_OPERAND_ERR:
                this.description = "You have a " 
                + "invalid operator Please, you"
                + "must fix this to contninue";
                break;
            case INVALID_CHARACTER_ERR:
                this.description = "You have a " 
                + "invalid character. Please, "
                + "you must fix this to contninue";
                break;
            case INVALID_NUMBER_ERR:
                this.description = "You have a " 
                + "invalid number. Please, you"
                + "must fix this to contninue";
                break;
        }
    }
}