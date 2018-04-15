package app;

public class LexemeTable {

    private Token token;
    private String lexeme;
    
    public LexemeTable(String lexeme ,Token token) {
        setLexeme(lexeme);
        setToken(token);
    }

    public LexemeTable(String lexeme) {
        setLexeme(lexeme);
        setToken(null);
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return this.token;
    }

    public String getLexeme() {
        return this.lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }
}