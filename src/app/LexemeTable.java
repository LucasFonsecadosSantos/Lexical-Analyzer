package app;

public class LexemeTable extends LexicalTablesInterface {

    private Token token;
    
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

    public String kk () {
        return "x";
    }
}