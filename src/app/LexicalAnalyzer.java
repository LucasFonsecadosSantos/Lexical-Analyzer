package app;

import dao.FileHandler;
import utils.Automaton;
import java.util.List;
import java.util.ArrayList;

public class LexicalAnalyzer {

    private Automaton automaton;
    private List<String> sourceCode;

    public LexicalAnalyzer(String fileName) {
        System.out.println(fileName);
        this.sourceCode = FileHandler.getSourceCode(fileName);
        this.automaton = new Automaton();
    }

    public void start() {

        int lineIndex = 0;
        for (String line : this.sourceCode) {
            ++lineIndex;
            this.automaton.makeTokens(line, lineIndex);
        }
    }


}