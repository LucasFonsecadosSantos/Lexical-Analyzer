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

import dao.FileHandler;
import utils.Automaton;
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

    private final int SYMBOL_TABLE = 0;
    private final int LEXEME_TABLE = 0;

    /**
     * The lexical analyzer object constructor.
     * It sets the automaton attribute instance and 
     * gets source code data from file with FileHandler
     * static method.
     * 
     * @param fileName The file name string from Main, receid by args from user.
     */
    public LexicalAnalyzer(String fileName) {
        System.out.println(fileName);
        this.sourceCode = FileHandler.getSourceCode(fileName);
        this.automaton = new Automaton();
        this.lexicalTables = new ArrayList<List[]>();
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
            this.lexicalTables.add(this.automaton.makeTokens(line, lineIndex));
        }
        List<LexemeTable> list = (ArrayList<LexemeTable>) this.lexicalTables.get(0)[1];
        System.out.println(list);
        
    }


}