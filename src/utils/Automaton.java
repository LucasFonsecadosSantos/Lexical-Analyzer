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
import app.SymbolTable;
import model.LexemeType;
import utils.LexicalErrors;
import app.LexemeTable;
import app.LexicalResults;
import app.Token;
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

    private String[] reservedWords;
    private String[] operators;
    private LexicalErrors lexicalErrors;
    private char[] separators;
    private char[] numbers;
    private LexicalResults lexicalResults;
    private static int currentLexeme;

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
                                this.lexicalResults.addError(LexicalErrors.type.INVALID_NUMBER_ERR ,index);
                                error = true;
                                break;
                            }
                        }
                        if (!error) {
                            //FOUND A NUMBER, THEN, SAVES AT SYMBOL TABLE AND LEXEME TABLE.
                            SymbolTable symbol = new SymbolTable(LexemeType.INT_LITERAL, tmpLexeme);
                            this.lexicalResults.addSymbolTable(symbol); 
                            this.lexicalResults.addLexemeTable(new LexemeTable(tmpLexeme, new Token(LexemeType.INT_LITERAL, symbol.getIndex())));
                        }
                    } else if (isCharacter(currentSymbol)) {
                        tmpLexeme += currentSymbol;
                        for (int i=1 ; i<lexeme.length() ; i++) {
                            currentSymbol = lexeme.charAt(i);
                            if ((isCharacter(currentSymbol)) || (isNumber(currentSymbol))) {
                                tmpLexeme += currentSymbol;
                            } else {
                                this.lexicalResults.addError(LexicalErrors.type.INVALID_LEXEME_ERR ,index);
                                error = true;
                                break;
                            }
                        }
                        if (!error) {
                            SymbolTable symbol = new SymbolTable(LexemeType.IDENTIFIER, tmpLexeme);
                            this.lexicalResults.addSymbolTable(symbol); 
                            this.lexicalResults.addLexemeTable(new LexemeTable(tmpLexeme, new Token(LexemeType.IDENTIFIER, symbol.getIndex())));
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
                                    this.lexicalResults.addError(LexicalErrors.type.INVALID_NUMBER_ERR ,index);
                                    error = true;
                                    break;
                                }
                            }
                            if (!error) {
                                //FOUND A NUMBER, THEN, SAVES AT SYMBOL TABLE AND LEXEME TABLE.
                                SymbolTable symbol = new SymbolTable(LexemeType.INT_LITERAL, tmpLexeme);
                                this.lexicalResults.addSymbolTable(symbol); 
                                this.lexicalResults.addLexemeTable(new LexemeTable(tmpLexeme, new Token(LexemeType.INT_LITERAL, symbol.getIndex())));
                            }
                        } else if (isCharacter(currentSymbol)) {
                            tmpLexeme += currentSymbol;
                            for (int i = 1 ; i < lexemeSplited.length() ; i++) {
                                
                                currentSymbol = lexemeSplited.charAt(i);
                                if ((isCharacter(currentSymbol)) || (isNumber(currentSymbol))) {
                                    tmpLexeme += currentSymbol;
                                } else {
                                    this.lexicalResults.addError(LexicalErrors.type.INVALID_LEXEME_ERR ,index);
                                    error = true;
                                    break;
                                }
                            }
                            if (!error) {
                                //FOUND A IDENTIFIER, THEN, SAVES AT SYMBOL TABLE AND LEXEME TABLE.
                                SymbolTable symbol = new SymbolTable(LexemeType.IDENTIFIER, tmpLexeme);
                                this.lexicalResults.addSymbolTable(symbol); 
                                this.lexicalResults.addLexemeTable(new LexemeTable(tmpLexeme, new Token(LexemeType.IDENTIFIER, symbol.getIndex())));
                            }
                        } else if (isOperand(lexemeSplited.charAt(0))) {
                            tmpLexeme += lexemeSplited.charAt(0);
                            this.lexicalResults.addLexemeTable(new LexemeTable(tmpLexeme, new Token(currentLexeme)));
                        } else if (isSeparator(lexemeSplited.charAt(0))) {
                            tmpLexeme += lexemeSplited.charAt(0);
                            this.lexicalResults.addLexemeTable(new LexemeTable(tmpLexeme, new Token(currentLexeme)));
                        }
                    }
                }
            }
            return this.lexicalResults;
        } else {
            return null;
        }
                
    }

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

    private Boolean isCharacter(char character) {
        if (Character.isLetter(character)) {
            return true;
        } else {
            return false;
        }
    } 

    private Boolean isOperand(char operand) {
        String operandStr = String.valueOf(operand);
        for (String operator : this.operators) {
            if (operator.equals(operandStr)) {
                return true;
            }
        }
        return false;
    }

    private Boolean isSeparator(char separatorChar) {
        for (char separator : this.separators) {
            if (separatorChar == separator) {
                return true;
            }
        }
        return false;
    }

    private Boolean isNumber(char lexeme) {
        for (char number : this.numbers) {
            if (lexeme == number) {
                return true;
            }
        }
        return false;
    }
}