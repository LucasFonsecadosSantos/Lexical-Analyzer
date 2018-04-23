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
package table;

import app.Token;

/**
 * This class represents the Lexeme table row model.
 * In theory, it represents the lexeme table data
 * abstraction collected from source code inputed.
 * It contains a lexeme string and one token.
 * 
 * @author Lucas Fonseca Dos Santos
 * @author Igor Augusto da Costa Nunes
 * @author Alan Luz Silveira
 * @author Igor Emanuel Carvalho da Cruz
 * @version 1.0
 * @since 1.0
 */
public class LexemeTable {

    /**
     * The token attribute.
     * It represents the second column of lexeme table
     * in real abstraction.
     */
    private Token token;

    /**
     * The lexeme attribute.
     * It represents the first column of lexeme table
     * in real abstraction.
     */
    private String lexeme;
    
    /**
     * The lexeme table object constructor. It sets the
     * lexeme attribute state and token attribute states
     * with params received from the caller method.
     * 
     * @param lexeme A string lexeme.
     * @param token A token object.
     */
    public LexemeTable(String lexeme ,Token token) {
        setLexeme(lexeme);
        setToken(token);
    }

    /**
     * The lexeme table object constructor overwrited.
     * It receives and sets the lexeme attribute state
     * from caller method.
     * 
     * @param lexeme A string lexeme.
     */
    public LexemeTable(String lexeme) {
        setLexeme(lexeme);
        setToken(null);
    }

    /**
     * The token attribute modifier method.
     * It changes the token attribute state.
     * 
     * @param token A new token instance.
     */
    public void setToken(Token token) {
        this.token = token;
    }

    /**
     * The token attribute accessor method.
     * It returns the token attribute state.
     * 
     * @return Token The token attribute state.
     */
    public Token getToken() {
        return this.token;
    }

    /**
     * The lexeme attribute accessor method.
     * It returns the lexeme attribute state.
     * 
     * @return String The lexeme attribute state.
     */
    public String getLexeme() {
        return this.lexeme;
    }

    /**
     * The lexeme attribute modifier method.
     * It changes the lexeme attribute state.
     * 
     * @param lexeme A new lexeme string.
     */
    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }
}