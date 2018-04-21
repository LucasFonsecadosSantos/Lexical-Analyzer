package app;
//comentario01
import model.ErrorType;
import model.LexemeType;
import utils.LexicalErrors;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class LexicalResults {
    // comentario 03
    private List<LexemeTable> lexemeTable;
    private List<SymbolTable> symbolTable;
    private List<LexicalErrors> errors; // comentariooo as 02

    public LexicalResults() {
        this.lexemeTable = new ArrayList<LexemeTable>();
        this.symbolTable = new ArrayList<SymbolTable>();
        this.errors = new ArrayList<LexicalErrors>();
    }

    public void addToLexemeTable(LexemeTable lexemeTable, SymbolTable symbolTable) {
        addLexemeTable(lexemeTable);
        addSymbolTable(symbolTable);
    }
    
    public void addToLexemeTable(LexemeTable lexemeTable) {
        addLexemeTable(lexemeTable);
        addSymbolTable(null);
    }

    public void addLexemeTable(String lexeme, LexemeType lexemeClass, int symbolTableIndex) {
        if (lexemeClass == LexemeType.OPERATOR || lexemeClass == LexemeType.SEPARATOR) {
            this.lexemeTable.add(new LexemeTable(lexeme, new Token(symbolTableIndex)));
        } else {
            this.lexemeTable.add(new LexemeTable(lexeme, new Token(lexemeClass, symbolTableIndex)));
        }
    }

    public void addLexemeTable(LexemeTable lexemeTable) {
        this.lexemeTable.add(lexemeTable);
    }

    public void addSymbolTable(SymbolTable symbolTable) {
        this.symbolTable.add(symbolTable);
    }

    public void addError(ErrorType type, int lineNumber, int columnNumber) {
        this.errors.add(new LexicalErrors(type, lineNumber, columnNumber));
    }

    public List<LexemeTable> getLexemeTable() {
        return this.lexemeTable;
    }

    public List<SymbolTable> getSymbolTable() {
        return this.symbolTable;
    }

    public List<LexicalErrors> getErrors() {
        return this.errors;
    }
}
