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
 * This enum represents the error class that exists
 * in that project. The following class are valids:
 * INVALID_LEXEME_ERR,
 * INVALID_OPERAND_ERR,
 * INVALID_CHARACTER_ERR,
 * INVALID_NUMBER_ERR;
 * 
 * @author Lucas Fonseca Dos Santos
 * @author Igor Augusto da Costa Nunes
 * @author Alan Luz Silveira
 * @author Igor Emanuel Carvalho da Cruz
 * @version 1.0
 * @since 1.0
 *
 */
public enum ErrorType {

    /**
     * INVALID_LEXEME_ERR
     * used for any identifier not recognized
     * by language grammar definitions.
     */
    INVALID_LEXEME_ERR,
    
    /**
     * INVALID_OPERAND_ERR
     * used for any operand not recognized
     * by language grammar definitions.
     */
    INVALID_OPERAND_ERR,

    /**
     * INVALID_CHARACTER_ERR
     * used for any symbol not recognized
     * by language grammar definitions.
     */
    INVALID_CHARACTER_ERR,
    
    /**
     * INVALID_NUMBER_ERR
     * used for any numeral symbol not recognized
     * by language grammar definitions.
     */
    INVALID_NUMBER_ERR;
}