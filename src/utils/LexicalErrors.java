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
package utils;
import java.util.Map;
import java.util.LinkedHashMap;
import model.ErrorType;

/**
 * This class represents a lexical error.
 * This object contains all informations about
 * error as your description, type (defined by
 * enum errors type), the line number where it was
 * ocurred, the column number where was found this
 * error.
 * 
 * @author Lucas Fonseca Dos Santos
 * @author Igor Augusto da Costa Nunes
 * @author Alan Luz Silveira
 * @author Igor Emanuel Carvalho da CruzO
 * @version 1.0
 * @since 1.0
 */
public class LexicalErrors {
    
    /**
     * The line number attribute.
     * It represents the line number where
     * the error was found.
     */
    private int lineNumber;

    /**
     * The column number attribute.
     * It stores the line column number where
     * the error was found.
     */
    private int columnNumber;

    /**
     * The error description attribute.
     * It's error description defined by
     * your type.
     */
    private String description;

    /**
     * The error class attribute.
     * It stores the error type.
     */
    private ErrorType type;

    /**
     * The lexicalError object constructor.
     * It receives the error type, the line number where it was found and
     * the column number where it was found and sets them at attributes.
     * 
     * @param type The class error type (defined by errorType enum).
     * @param lineNumber The line number where it was found.
     * @param columnNumber The line column number where it was found.
     */
    public LexicalErrors(ErrorType type, int lineNumber, int columnNumber) {
        setType(type);
        setLineNumber(lineNumber);
        setColumnNumber(columnNumber);
        setDescription(type);
    }

    /**
     * The accessor method of description attribute.
     * 
     * @return String The description attribute state.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * The accessor method of type attribute.
     * 
     * @return ErrorType A enum error type attribute state.
     */
    public ErrorType getType() {
        return this.type;
    }

    /**
     * The accessor method of lineNumber attribute..
     * 
     * @return int The lineNumber attribute state.
     */
    public int getLine() {
        return this.lineNumber;
    }

    /**
     * The acessor method of columnNumber attribute.
     * 
     * @return int The columnNumber attribute state.
     */
    public int getColumn() {
        return this.columnNumber;
    }

    /**
     * The modifier method of type attribute.
     * 
     * @param type The new type of object (based by enum error type).
     */
    private void setType(ErrorType type) {
        this.type = type;
    }

    /**
     * The modifier method of lineNumber attribute.
     * 
     * @param lineNumber The new lineNumber attribute state.
     */
    private void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    /**
     * The modifier method of columnNumber attribute.
     * 
     * @param columnNumber The new column number attribute state.
     */
    private void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    /**
     * The modifier method of description attribute.
     * It chooses the descrition by the error class.
     * 
     * @param type An error type defined by enum errors.
     */
    private void setDescription(ErrorType type) {
        switch(type) {
            case INVALID_LEXEME_ERR:
                this.description = "You have a " 
                + "invalid identifier or reservated "
                + "word";
                break;
            case INVALID_OPERAND_ERR:
                this.description = "You have a " 
                + "invalid operator";
                break;
            case INVALID_CHARACTER_ERR:
                this.description = "You have a " 
                + "invalid character";
                break;
            case INVALID_NUMBER_ERR:
                this.description = "You have a " 
                + "invalid number";
                break;
        }
    }
}