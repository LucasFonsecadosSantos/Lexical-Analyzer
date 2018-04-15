package app;

import model.LexemeType;

public class Token {

    private LexemeType lexemeClass;
    private int symbolTableIndex;

    public Token(LexemeType lexemeClass, int symbolTableIndex) {
        setLexemeClass(lexemeClass);
        setIndex(symbolTableIndex);
    }

    public Token(int index) {
        setLexemeClass(null);
        setIndex(index);
    }

    public void setLexemeClass(LexemeType lexemeClass) {
        this.lexemeClass = lexemeClass;
    }

    public void setIndex(int index) {
        this.symbolTableIndex = index;
    }

    public int getSymbolTableIndex() {
        return this.symbolTableIndex;
    }

    public LexemeType getLexemeClass() {
        return this.lexemeClass;
    }
}