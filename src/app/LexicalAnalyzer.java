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
import app.LexemeTable;
import dao.FileHandler;
import utils.LexicalErrors;
import view.GUI;
import model.ErrorType;
import utils.Automaton;
import java.util.Map;



import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * This class represents the LexicalAnalyzer object,
 * the core of project. It contains a automaton and
 * the list with all source code lines.
 * 
 * @author Lucas Fonseca Dos Santos
 * @author Igor Augusto da Costa Nunes
 * @author Alan Luz Silveira
 * @version 1.0
 * @since 1.0
 */
public class LexicalAnalyzer {

    /**
     * Automaton attribute
     */
    private Automaton automaton;

    /**
     * Source code data list attribute
     */
    private List<String> sourceCode;

    /**
     * Source code data list attribute
     */
    private List<List[]> lexicalTables;
    private List<LexemeTable> lexemeTable;
    private List<SymbolTable> symbolTable;
    private List<LexicalErrors> errors;
    private List<LexicalResults> results;

    /**
     * The lexical analyzer object constructor.
     * It sets the automaton attribute instance and 
     * gets source code data from file with FileHandler
     * static method.
     * 
     * @param fileName The file name string from Main, receid by args from user.
     */
    public LexicalAnalyzer(String fileName) {
        GUI.clear();
        GUI.printActionMessage("Compiling the " + fileName + " code.");
        this.sourceCode = FileHandler.getSourceCode(fileName);
        this.automaton = new Automaton();
        this.lexemeTable = new ArrayList<LexemeTable>();
        this.symbolTable = new ArrayList<SymbolTable>();
        this.results = new ArrayList<LexicalResults>();
        this.errors = new ArrayList<LexicalErrors>();
    }

    /**
     * This method is responsible for starting
     * the tokens maker process, sending line by line
     * from source code to automaton.
     * 
     */
    public void start() {
        int lineIndex = 0;
        for (String line : this.sourceCode) {
            ++lineIndex;
            this.results.add(this.automaton.makeTokens(line, lineIndex));
        }
        populateTables();
        System.out.println(this.lexemeTable.size());
        for (LexemeTable lt : this.lexemeTable) {
            if (lt != null) {
                if (lt.getToken() != null)
                    GUI.printInformationMessage(lt.getLexeme() + " ["+lt.getToken().getSymbolTableIndex()+"]");
            }
        }
        for (LexicalErrors le : this.errors) {
            GUI.printErrorMessage(le.getType().toString(),
                "(" + le.getLine() + "," + le.getColumn() 
                + ") " + le.getDescription());
        }
    }

    private void populateTables() {
        for (LexicalResults results : this.results) {
            if (results != null) {
                for (LexemeTable lexemeTable : results.getLexemeTable()) {
                    this.lexemeTable.add(lexemeTable);
                }
                for (SymbolTable symbolTable : results.getSymbolTable()) {
                    this.symbolTable.add(symbolTable);
                }
                this.errors = results.getErrors();
            } else {
                continue;
            }
        }
    }


}