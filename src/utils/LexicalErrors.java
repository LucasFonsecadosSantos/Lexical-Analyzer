package utils;

import java.util.LinkedHashMap;

public class LexicalErrors {
    
    private static LinkedHashMap<ErrorType, Integer> errorsList = new LinkedHashMap<ErrorType, Integer>();
    protected static ErrorType type;

    public static void addError(ErrorType type, int lineNumber) {
        errorsList.put(type, lineNumber);
    }
}