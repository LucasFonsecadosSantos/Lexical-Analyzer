package app;

public class LexemeTable implements LexicalTablesInterface {

    private Token token;
    
    public LexemeTable(String lexeme ,Token token) {
        setLexeme(lexeme);
        setToken(token);
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return this.token;
    }
}