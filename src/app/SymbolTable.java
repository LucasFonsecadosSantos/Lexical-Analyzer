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

import enumModel.LexemeType;

public class SymbolTable {

    private int index;
    private LexemeType type;
    private String lexeme;
    private String description;

    public SymbolTable(int index, LexemeType type, String lexeme) {
        setIndex(index);
        setLexemeType(type);
        setLexeme(lexeme);
        setDescription();
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setLexemeType(LexemeType type) {
        this.type = type;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    public int getIndex() {
        return this.index;
    }

    public LexemeType getLexemeType() {
        return this.type;
    }

    public String getLexeme() {
        return this.lexeme;
    }

    public void setDescription() {
        //GERAR DESCRICAO 
    }
}