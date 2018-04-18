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
package utils;

import view.GUI;
import model.LexemeType;
import model.ErrorType;
import app.SymbolTable;
import app.LexicalResults;
import java.util.List;
import java.util.ArrayList;

/**
 * This represents the most important class at the
 * current step for the project, the Automaton.
 * It's a matemathical model that process the source
 * code by a language grammar described next:
 * 
 * @author Lucas Fonseca Dos Santos
 * @author Igor Augusto da Costa Nunes
 * @author Alan Luz Silveira
 * @version 1.0
 * @since 1.0
 *
 *
 * = == > ++ && <= ! - -- + += *
 * 
 * ,.[{()}];
 * 
 * abstract extends int protected this
 * boolean false new public true
 * char import null return void
 * class if package static while
 * else instanceof private super
 * 
 * <identifier > = (a-z|A-Z|_|$){a-z|A-Z|_|0-9|$}
 */
public class Automaton {

    /**
     * Language Reserved words array attribute.
     * All words contained here is specificated by
     * language grammar.
     */
    private String[] reservedWords;
    
    /**
     * Language operators array attribute.
     * All operators contained here is specificated by
     * language grammar.
     */
    private String[] operators;

    /**
     * Language separators array attribute.
     * All separators contained here is specificated by
     * language grammar.
     */
    private char[] separators;

    /**
     * Language numbers array attribute.
     * All numbers contained here is specificated by
     * language grammar.
     */
    private char[] numbers;

    /**
     * A lexical analyze results by automaton
     * process verification attribute.
     * This object contains all information
     * collected by source code as Lexemes, errors
     * and symbols.
     */
    private LexicalResults lexicalResults;

    /**
     * Current lexeme attribute.
     */
    private static int currentLexeme;

    /**
     * The automaton object constructor.
     * It sets the following attributes:
     * - numbers as char array with your symbols.
     * - reservedWords as String array with your symbols.
     * - operators as String array with your symbols.
     * - separators as String with your symbols.
     * and after that, sets the lexicalResults as a new
     * object.
     */
    public Automaton() {
        this.numbers = new char[] {
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9'
        };
        this.reservedWords = new String[]{
            "abstract", "boolean", "char", "else",
            "class", "extends", "false", "import",
            "if", "instanceof", "int", "new", "null",
            "package", "private", "protected", "public",
            "return", "static", "super", "this", "true",
            "void", "while"
        };
        this.operators = new String[] {
            "=", "==", ">", "++", "&&",
            "<=", "!", "-", "--", "+", 
            "+=", "*"};
        this.separators = new char[] {
            ',', '.', '[', '{', '(', ')', '}', ']',';'
        };
        this.lexicalResults = new LexicalResults();
        currentLexeme =0;
    }

    public LexicalResults makeTokens(String sourceLine, int index) {
        if (!sourceLine.equals("")) {
            String[] lexemes = sourceLine.split(" ");
            String[] splitedLexeme;
            String tmpLexeme;
            Boolean error;
            char currentSymbol;
            
            for (String lexeme : lexemes) {
                tmpLexeme = "";
                error = false;
                if(lexeme.equals("")) continue;
                //System.out.println(lexeme);
                if ((splitedLexeme = sliptBySpecialCharacteres(lexeme)) == null) {
                    currentLexeme++;
                    if(lexeme.equals("")) continue;
                    currentSymbol = lexeme.charAt(0);
                    if (isNumber(currentSymbol)) {
                        tmpLexeme += currentSymbol;
                        for (int i=1 ; i < lexeme.length() ; i++) {
                            currentSymbol = lexeme.charAt(i);
                            if (isNumber(currentSymbol)) {
                                tmpLexeme += currentSymbol;
                            } else {
                                this.lexicalResults.addError(ErrorType.INVALID_NUMBER_ERR ,index, i);
                                error = true;
                                break;
                            }
                        }
                        if (!error) {
                            //FOUND A NUMBER, THEN, SAVES AT SYMBOL TABLE AND LEXEME TABLE.
                            SymbolTable symbol = new SymbolTable(LexemeType.INT_LITERAL, tmpLexeme);
                            this.lexicalResults.addSymbolTable(symbol); 
                            this.lexicalResults.addLexemeTable(tmpLexeme, LexemeType.INT_LITERAL, symbol.getIndex());
                        }
                    } else if (isCharacter(currentSymbol)) {
                        tmpLexeme += currentSymbol;
                        for (int i=1 ; i<lexeme.length() ; i++) {
                            currentSymbol = lexeme.charAt(i);
                            if ((isCharacter(currentSymbol)) || (isNumber(currentSymbol))) {
                                tmpLexeme += currentSymbol;
                            } else {
                                this.lexicalResults.addError(ErrorType.INVALID_LEXEME_ERR ,index, i);
                                error = true;
                                break;
                            }
                        }
                        if (!error) {
                            SymbolTable symbol = new SymbolTable(LexemeType.IDENTIFIER, tmpLexeme);
                            this.lexicalResults.addSymbolTable(symbol); 
                            this.lexicalResults.addLexemeTable(tmpLexeme, LexemeType.IDENTIFIER, symbol.getIndex());
                        } 
                    }
                    
                    
                } else {
                    /*for (String s : splitedLexeme) {
                        System.out.println(s);
                    }*/
                    for (String lexemeSplited : splitedLexeme) {
                        currentLexeme++;
                        tmpLexeme = "";
                        if(lexemeSplited.equals("")) continue;
                        currentSymbol = lexemeSplited.charAt(0);
                        if (isNumber(currentSymbol)) {
                            tmpLexeme += currentSymbol;
                            for (int i = 1 ; i < lexemeSplited.length() ; i++) {
                                currentSymbol = lexemeSplited.charAt(i);
                                if (isNumber(currentSymbol)) {
                                    tmpLexeme += currentSymbol;
                                } else {
                                    this.lexicalResults.addError(ErrorType.INVALID_NUMBER_ERR ,index, i);
                                    error = true;
                                    break;
                                }
                            }
                            if (!error) {
                                //FOUND A NUMBER, THEN, SAVES AT SYMBOL TABLE AND LEXEME TABLE.
                                SymbolTable symbol = new SymbolTable(LexemeType.INT_LITERAL, tmpLexeme);
                                this.lexicalResults.addSymbolTable(symbol); 
                                this.lexicalResults.addLexemeTable(tmpLexeme, LexemeType.INT_LITERAL, symbol.getIndex());
                            }
                        } else if (isCharacter(currentSymbol)) {
                            tmpLexeme += currentSymbol;
                            for (int i = 1 ; i < lexemeSplited.length() ; i++) {
                                
                                currentSymbol = lexemeSplited.charAt(i);
                                if ((isCharacter(currentSymbol)) || (isNumber(currentSymbol))) {
                                    tmpLexeme += currentSymbol;
                                } else {
                                    this.lexicalResults.addError(ErrorType.INVALID_LEXEME_ERR ,index, i);
                                    error = true;
                                    break;
                                }
                            }
                            if (!error) {
                                //FOUND A IDENTIFIER, THEN, SAVES AT SYMBOL TABLE AND LEXEME TABLE.
                                SymbolTable symbol = new SymbolTable(LexemeType.IDENTIFIER, tmpLexeme);
                                this.lexicalResults.addSymbolTable(symbol); 
                                this.lexicalResults.addLexemeTable(tmpLexeme, LexemeType.IDENTIFIER, symbol.getIndex());
                            }
                        } else if (isOperand(lexemeSplited.charAt(0))) {
                            tmpLexeme += lexemeSplited.charAt(0);
                            this.lexicalResults.addLexemeTable(tmpLexeme, LexemeType.OPERATOR, currentLexeme);
                        } else if (isSeparator(lexemeSplited.charAt(0))) {
                            tmpLexeme += lexemeSplited.charAt(0);
                            this.lexicalResults.addLexemeTable(tmpLexeme, LexemeType.SEPARATOR, currentLexeme);
                        }
                    }
                }
            }
            return this.lexicalResults;
        } else {
            return null;
        }
                
    }

    /**
     * This private method splits by special characteres defined by language grammar
     * a lexeme line and return it.
     * The split operation is based by a regex function. If any symbol is located by
     * regex function, the method writes # symbol after and before the special character,
     * and after that, splits the line by # symbol.
     * 
     * @return String[] A string array with all lexemes splited by special characteres.
     * @param lexeme String lexeme that will be splited.
     */
    private String[] sliptBySpecialCharacteres(String lexeme) {
        for (char separator : this.separators) {
            for (String operand : this.operators) {
                if (lexeme.contains(String.valueOf(separator)) || lexeme.contains(operand)) {
                    return lexeme.replaceAll("(==?|&&|\\+[+=]?|<=|--?|[>!*,;.\\[{()}\\]])", "#$1#").split("#");
                }
            }
        }
        return null;
    }

    /**
     * This private method verifys if a character is ou isn't a valid character
     * defined by language grammar.
     * 
     * @return Boolean A condition that indicates if the symbol is or isn't a character.
     * @param character A symbol will be verificate if the symbol is or isn't a character.
     */
    private Boolean isCharacter(char character) {
        return (Character.isLetter(character));
    } 

    /**
     * This method verifys if the character is a valid operator by the conditions
     * expressed by language grammar.
     * 
     * @param operand A character that will be avaliated if it's operator.
     * @return Boolean True if the character is operator by language grammar definitions.
     */
    private Boolean isOperand(char operand) {
        String operandStr = String.valueOf(operand);
        for (String operator : this.operators) {
            if (operator.equals(operandStr)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This private method will avaliated if a character is or isn't a valid separtor
     * by language grammar definitions.
     * 
     * @param separatorChar A character that will be avaliated if it's a separator char by language grammar definitions.
     * @return Boolean True if the character is a separator by language grammar definitions.
     */
    private Boolean isSeparator(char separatorChar) {
        for (char separator : this.separators) {
            if (separatorChar == separator) {
                return true;
            }
        }
        return false;
    }

    /**
     * This private method returns if the lexeme is a valid number
     * by language grammar specifications.
     * 
     * @return Boolean True if the lexeme is a valid number by language grammar.
     * @param Lexeme A lexeme that will be avaliated if it's a valid number by language grammar specifications.
     */
    private Boolean isNumber(char lexeme) {
        for (char number : this.numbers) {
            if (lexeme == number) {
                return true;
            }
        }
        return false;
    }
}