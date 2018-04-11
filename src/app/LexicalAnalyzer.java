package app;

import dao.FileHandler;
import java.util.List;
import java.util.ArrayList;

public class LexicalAnalyzer {

    private List<String> sourceCode;

    public LexicalAnalyzer(String fileName) {
        this.sourceCode = FileHandler.getSourceCode(fileName);
    }

    


}