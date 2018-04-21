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
package app;

import model.LexemeType;

/**
 * This class represnets a symbol table model
 * abstraction. It contains all informations
 * about identifiers and numbers collected
 * from source code by parsing step.
 * 
 * @author Lucas Fonseca Dos Santos
 * @author Igor Augusto da Costa Nunes
 * @author Alan Luz Silveira
 * @author Igor Emanuel Carvalho da Cruz
 * @version 1.0
 * @since 1.0
 */
public class SymbolTable {

    /**
     * The string lexeme attribute.
     */
    private String lexeme;

    /**
     * The lexeme occurency index attribute.
     */
    private int index;

    /**
     * The lexeme class attribute.
     */
    protected static LexemeType type;

    /**
     * The lexeme description attribute.
     */
    private String description;

    /**
     * The symbol table object constructor. it sets the index,
     * lexeme class, lexeme and your description.
     * 
     * @param type The lexeme class.
     * @param lexeme The lexeme.
     * @param index The occurrency index of lexeme.
     */
    public SymbolTable(LexemeType type, String lexeme, int index) {
        setIndex(index);
        setLexemeType(type);
        setLexeme(lexeme);
        setDescription();
    }

    /**
     * The lexeme attribute accessor method.
     * It returns the lexeme attribute state.
     * 
     * @return String Lexeme attribute state.
     */
    public String getLexeme() {
        return this.lexeme;
    }

    /**
     * The lexeme attribute modifier method.
     * It changes the lexeme attribute state.
     * 
     * @param lexeme New lexeme attribute state.
     */
    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }
    
    /**
     * The index attribute accessor method.
     * It returns the index attribute state.
     * 
     * @return int Index attribute state.
     */
    public int getIndex() {
        return this.index;
    }

    /**
     * The index attribute modifier method.
     * It changes the index attribute state.
     * 
     * @param type New index attribute state.
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * The lexeme class attribute modifier method.
     * It changes the lexeme class attribute state.
     * 
     * @param type New lexeme type attribute state.
     */
    public void setLexemeType(LexemeType type) {
        this.type = type;
    }

    /**
     * The lexeme class attribute accessor method.
     * It returns the lexeme class attribute state.
     * 
     * @return LexemeType Lexeme class attribute state.
     */
    public LexemeType getLexemeType() {
        return this.type;
    }

    public void setDescription() {
        //GERAR DESCRICAO 
    }
}