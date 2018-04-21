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
 * This class represnts the token model
 * abstraction. It contains just two informations:
 * The lexeme class and your ocurrency index at
 * symbol table.
 * 
 * @author Lucas Fonseca Dos Santos
 * @author Igor Augusto da Costa Nunes
 * @author Alan Luz Silveira
 * @author Igor Emanuel Carvalho da Cruz
 * @version 1.0
 * @since 1.0
 */
public class Token {

    /**
     * 
     */
    private LexemeType lexemeClass;

    /**
     * Ocurency index attribute.
     */
    private int symbolTableIndex;

    /**
     * Token object constructor. It receives the lexeme class
     * and ocurrency index.
     * 
     * @param lexemeClass The class of lexeme.
     * @param symbolTableIndex Occurency index.
     */
    public Token(LexemeType lexemeClass, int symbolTableIndex) {
        setLexemeClass(lexemeClass);
        setIndex(symbolTableIndex);
    }

    /**
     * Token object constructor overwrited.
     * It just reiceves occurency index.
     * 
     * @param index Occurency index.
     */
    public Token(int index) {
        setLexemeClass(null);
        setIndex(index);
    }

    /**
     * Modifier method of lexemeClass attribute.
     * It changes lexemeClass attribute state.
     * 
     * @param lexemeClass The new lexemeClass state.
     */
    public void setLexemeClass(LexemeType lexemeClass) {
        this.lexemeClass = lexemeClass;
    }

    /**
     * Modifier method of index attribute.
     * It changes index attribute state.
     * 
     * @param index The new index state.
     */
    public void setIndex(int index) {
        this.symbolTableIndex = index;
    }

    /**
     * Accessor method of symbolTableIndex attribute.
     * It returns symbolTableIndex attribute state.
     * 
     * @return int The symbolTableIndex state.
     */
    public int getSymbolTableIndex() {
        return this.symbolTableIndex;
    }

    /**
     * Accessor method of lexemeClass attribute.
     * It returns lexemeClass attribute state.
     * 
     * @return LexemeType The lexemeClass state.
     */
    public LexemeType getLexemeClass() {
        return this.lexemeClass;
    }
}