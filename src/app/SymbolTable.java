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