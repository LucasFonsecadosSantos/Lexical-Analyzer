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
package app;

import model.LexemeType;

public class SymbolTable {

    private String lexeme;
    private static int index = 0;
    protected static LexemeType type;
    private String description;

    public SymbolTable(LexemeType type, String lexeme) {
        setIndex(index);
        setLexemeType(type);
        setLexeme(lexeme);
        setDescription();
        increaseIndex();
    }

    public String getLexeme() {
        return this.lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }
        
    public int getIndex() {
        return index;
    }

    public void increaseIndex() {
        index++;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setLexemeType(LexemeType type) {
        this.type = type;
    }

    public LexemeType getLexemeType() {
        return this.type;
    }

    public void setDescription() {
        //GERAR DESCRICAO 
    }
}