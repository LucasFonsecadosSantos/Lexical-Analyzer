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

import java.util.List;
import java.util.ArrayList;
import table.LexemeTable;
import table.SymbolTable;
import table.ErrorTable;
import view.GUI;

public class Main {

    public static void main(String[] args) {
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(args[0]);
        List[] results = lexicalAnalyzer.start();

        List<LexemeTable> lexemeTable = results[0];
        List<SymbolTable> symbolTable = results[1];
        List<ErrorTable> errorTable = results[2];

        for (LexemeTable lt : lexemeTable) {
            GUI.printInformationMessage(lt.getLexeme() + " ["+lt.getToken().getSymbolTableIndex()+"] " + "(" + lt.getToken().getLexemeClass() + ")");
        }

        for (SymbolTable st : symbolTable) {
            GUI.printInformationMessage(st.getLexeme() + " " + st.getIndex());
        }

        for (ErrorTable le : errorTable) {
            GUI.printErrorMessage(le.getType().toString(),
            "(" + le.getLine() + "," + le.getColumn() 
            + ") " + le.getDescription());
        }
    }
}