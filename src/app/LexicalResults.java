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

import model.ErrorType;
import model.LexemeType;
import table.ErrorTable;
import table.LexemeTable;
import table.SymbolTable;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * This class represents all information returned
 * after automaton has processed source code.
 * It contains a lexeme table, symbol table and
 * lexical errors table.
 * 
 * @author Lucas Fonseca Dos Santos
 * @author Igor Augusto da Costa Nunes
 * @author Alan Luz Silveira
 * @author Igor Emanuel Carvalho da Cruz
 * @version 1.0
 * @since 1.0
 *
 */
public class LexicalResults {
    
    /**
     * The lexeme table list attribute
     */
    private List<LexemeTable> lexemeTable;

    /**
     * The symbol table list attribute
     */
    private List<SymbolTable> symbolTable;

    /**
     * The lexical errors list attribute
     */
    private List<ErrorTable> errors;

    /**
     * The lexical results object constructor.
     * It sets the lexemeTable, symbolTable and errors
     * lists.
     */
    public LexicalResults() {
        this.lexemeTable = new ArrayList<LexemeTable>();
        this.symbolTable = new ArrayList<SymbolTable>();
        this.errors = new ArrayList<ErrorTable>();
    }

    /**
     * Modifier method of lexeme table attribute.
     * It ads one new lexeme table and symbol table to lexeme table
     * array.
     * 
     * @param lexemeTable New lexeme table object for add into lexeme table.
     * @param symbolTable New symbol table object for add into symbol table.
     */
    public void addToLexemeTable(LexemeTable lexemeTable, SymbolTable symbolTable) {
        addLexemeTable(lexemeTable);
        addSymbolTable(symbolTable);
    }
    
    /**
     * Modifier method overwrited of lexeme table attribute.
     * It ads one new lexeme table and symbol table to lexeme table
     * array.
     * 
     * @param lexemeTable New lexeme table object for add into lexeme table.
     */
    public void addToLexemeTable(LexemeTable lexemeTable) {
        addLexemeTable(lexemeTable);
        addSymbolTable(null);
    }

    /**
     * It's responsible for add new lexeme table. Just it! kkk
     * 
     * @param lexeme A lexeme string to be add.
     * @param lexemeClass A lexeme class type that will be add.
     * @param symbolTableIndex The lexeme occurency index.
     */
    public void addLexemeTable(String lexeme, LexemeType lexemeClass, int symbolTableIndex) {
        if (lexemeClass == LexemeType.OPERATOR || lexemeClass == LexemeType.SEPARATOR) {
            this.lexemeTable.add(new LexemeTable(lexeme, new Token(lexemeClass, symbolTableIndex)));
        } else {
            this.lexemeTable.add(new LexemeTable(lexeme, new Token(lexemeClass, symbolTableIndex)));
        }
    }

    /**
     * This method adds new lexeme table.
     * 
     * @param lexemeTable The lexeme table object.
     */
    public void addLexemeTable(LexemeTable lexemeTable) {
        this.lexemeTable.add(lexemeTable);
    }

    public void addSymbolTable(SymbolTable symbolTable) {
        this.symbolTable.add(symbolTable);
    }

    public void addError(ErrorType type, int lineNumber, int columnNumber) {
        this.errors.add(new ErrorTable(type, lineNumber, columnNumber));
    }

    /**
     * Accessor method of lexeme table attribute state.
     * It returns the lexeme table attribute state.
     * 
     * @return List A lexeme list object.
     */
    public List<LexemeTable> getLexemeTable() {
        return this.lexemeTable;
    }

    /**
     * Accessor method of symbol table attribute state.
     * It returns the symbol table attribute state.
     * 
     * @return List A symbol list object.
     */
    public List<SymbolTable> getSymbolTable() {
        return this.symbolTable;
    }

    /**
     * Accessor method of errors table attribute state.
     * It returns the errors table attribute state.
     * 
     * @return List A errors list object.
     */
    public List<ErrorTable> getErrors() {
        return this.errors;
    }
}