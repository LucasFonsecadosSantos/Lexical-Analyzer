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
package model;

/**
 * This enum represents the lexeme class that exists
 * in that project. The following class are valids:
 * 
 * IDENTIFIER,
 * SYMBOL,
 * COMMENT,
 * CHAR_LITERRAL,
 * INT_LITERAL,
 * OPERATOR,
 * SEPARATOR,
 * STRING_LITERAL;
 * 
 * @author Lucas Fonseca Dos Santos
 * @author Igor Augusto da Costa Nunes
 * @author Alan Luz Silveira
 * @author Igor Emanuel Carvalho da Cruz
 * @version 1.0
 * @since 1.0
 *
 */
public enum LexemeType {
    
    /**
     * IDENTIFIER
     * used for identifiers specified
     * by language grammar definitions.
     */
    IDENTIFIER,
    
    /**
     * RESERVED_SYMBOL
     * used for key word specified
     * by language grammar definitions.
     */
    RESERVED_SYMBOL,

    /**
     * IDENTIFIER
     * used for comments statement specified
     * by language grammar definitions.
     */
    COMMENT,

    /**
     * CHAR_LITERAL
     * used for char specified
     * by language grammar definitions.
     */
    CHAR_LITERAL,

    /**
     * INT_LITERAL
     * used for numeral values specified
     * by language grammar definitions.
     */
    INT_LITERAL,

    /**
     * OPERATOR
     * used for operators specified
     * by language grammar definitions.
     */
    OPERATOR,

    /**
     * SEPARATOR
     * used for separators and delimiters specified
     * by language grammar definitions.
     */
    SEPARATOR,

    /**
     * STRING_LITERAL
     * used for character chain specified
     * by language grammar definitions.
     */
    STRING_LITERAL;
}