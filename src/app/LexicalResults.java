package app;

import model.ErrorType;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import utils.LexicalErrors;

public class LexicalResults {
    
    private List<LexemeTable> lexemeTable;
    private List<SymbolTable> symbolTable;
    private LexicalErrors lexicalErrors;

    public LexicalResults() {
        this.lexemeTable = new ArrayList<LexemeTable>();
        this.symbolTable = new ArrayList<SymbolTable>();
        this.lexicalErrors = new LexicalErrors();
    }

    public void addToLexemeTable(LexemeTable lexemeTable, SymbolTable symbolTable) {
        addLexemeTable(lexemeTable);
        addSymbolTable(symbolTable);
    }
    
    public void addToLexemeTable(LexemeTable lexemeTable) {
        addLexemeTable(lexemeTable);
        addSymbolTable(null);
    }

    public void addLexemeTable(LexemeTable lexemeTable) {
        this.lexemeTable.add(lexemeTable);
    }

    public void addSymbolTable(SymbolTable symbolTable) {
        this.symbolTable.add(symbolTable);
    }

    public void addError(ErrorType type, int lineNumber) {
        this.lexicalErrors.addError(type, lineNumber);
    }

    public List<LexemeTable> getLexemeTable() {
        return this.lexemeTable;
    }

    public List<SymbolTable> getSymbolTable() {
        return this.symbolTable;
    }

    public Map<ErrorType, Integer> getErrors() {
        return this.lexicalErrors.getErrors();
    }
}