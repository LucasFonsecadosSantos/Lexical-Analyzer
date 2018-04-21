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
 * @author Igor Emanuel Carvalho da Cruz
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
     * Language grammar definitions for
     * comments expressions.
     */
    private String[] commentDelimiter;
    /**
     * Current lexeme attribute.
     */
    private int currentLexeme;

    private Boolean errorState;

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
        this.commentDelimiter = new String[] {
            "//"
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
            int currentSymbolAmount = 0;
            Boolean comment = false;
            
            for (String lexeme : lexemes) {
                tmpLexeme = "";
                error = false;
                
                if(lexeme.equals("")) continue;
                currentSymbolAmount++;
                if ((splitedLexeme = sliptBySpecialCharacteres(lexeme)) == null) {
                    if (lexeme.equals("")) continue;
                    currentSymbol = lexeme.charAt(0);
                    if (isComment(lexeme)) {
                        comment = true;
                        String commentLexeme = "";
                        Boolean control = false;
                        for (String commentString : lexemes) {
                            if (control) {
                                commentLexeme += commentString;
                            } else {
                                control = isComment(commentString);
                            }
                        }
                        ++currentLexeme;
                        System.out.println("e COMENTARIO: " + commentLexeme);
                        this.lexicalResults.addLexemeTable(commentLexeme, LexemeType.COMMENT, currentLexeme);
                        break;
                    } else if (isNumber(currentSymbol)) {
                        tmpLexeme += currentSymbol;

                        for (int i=1 ; i < lexeme.length() ; i++) {
                            ++currentSymbolAmount;
                            currentSymbol = lexeme.charAt(i);
                            if (isNumber(currentSymbol)) {
                                tmpLexeme += currentSymbol;
                            } else {
                                this.lexicalResults.addError(ErrorType.INVALID_NUMBER_ERR ,index, currentSymbolAmount);
                                error = true;
                                break;
                            }
                        }

                        if (!error) {
                            //FOUND A NUMBER, THEN, SAVES AT SYMBOL TABLE AND LEXEME TABLE.
                            ++currentLexeme;
                            SymbolTable symbol = new SymbolTable(LexemeType.INT_LITERAL, tmpLexeme, currentLexeme);
                            //System.out.println("adding: " + tmpLexeme + "("+currentLexeme+")");
                            this.lexicalResults.addSymbolTable(symbol); 
                            this.lexicalResults.addLexemeTable(tmpLexeme, LexemeType.INT_LITERAL, currentLexeme);
                        } else {
                            break;
                        }
                    } else if (isCharacter(currentSymbol)) {
                        tmpLexeme += currentSymbol;
                        for (int i=1 ; i<lexeme.length() ; i++) {
                            ++currentSymbolAmount;
                            currentSymbol = lexeme.charAt(i);
                            if ((isCharacter(currentSymbol)) || (isNumber(currentSymbol))) {
                                tmpLexeme += currentSymbol;
                            } else {
                                
                                this.lexicalResults.addError(ErrorType.INVALID_LEXEME_ERR ,index, currentSymbolAmount);
                                error = true;
                                break;
                            }
                        }
                        if (!error) {
                            ++currentLexeme;
                            if (isReservedWord(tmpLexeme)) {
                                this.lexicalResults.addLexemeTable(tmpLexeme, LexemeType.RESERVED_SYMBOL, currentLexeme);
                            } else {
                                SymbolTable symbol = new SymbolTable(LexemeType.IDENTIFIER, tmpLexeme, currentLexeme);
                                this.lexicalResults.addSymbolTable(symbol); 
                                this.lexicalResults.addLexemeTable(tmpLexeme, LexemeType.IDENTIFIER, currentLexeme);
                            }
                            //System.out.println("adding: " + tmpLexeme + "("+currentLexeme+")");
                        } else {
                            break;
                        } 
                    }
                    
                    
                } else {
                    for (String lexemeSplited : splitedLexeme) {
                        tmpLexeme = "";
                        if(lexemeSplited.equals("")) continue;
                        ++currentSymbolAmount;
                        currentSymbol = lexemeSplited.charAt(0);
                        if (isComment(lexeme)) {
                            comment = true;
                            String commentLexeme = "";
                            Boolean control = false;
                            for (String commentString : lexemes) {
                                if (control) {
                                    commentLexeme += commentString;
                                } else {
                                    control = isComment(commentString);
                                }
                            }
                            ++currentLexeme;
                            this.lexicalResults.addLexemeTable(commentLexeme, LexemeType.COMMENT, currentLexeme);
                            System.out.println("e COMENTARIO: " + commentLexeme);
                            break;
                        } else  if (isNumber(currentSymbol)) {
                            tmpLexeme += currentSymbol;
                            for (int i = 1 ; i < lexemeSplited.length() ; i++) {
                                ++currentSymbolAmount;
                                currentSymbol = lexemeSplited.charAt(i);
                                if (isNumber(currentSymbol)) {
                                    tmpLexeme += currentSymbol;
                                } else {
                                    this.lexicalResults.addError(ErrorType.INVALID_NUMBER_ERR ,index, currentSymbolAmount);
                                    error = true;
                                    break;
                                }
                            }
                            if (!error) {
                                //FOUND A NUMBER, THEN, SAVES AT SYMBOL TABLE AND LEXEME TABLE.
                                ++currentLexeme;
                                SymbolTable symbol = new SymbolTable(LexemeType.INT_LITERAL, tmpLexeme, currentLexeme);
                                //System.out.println("adding: " + tmpLexeme + "("+currentLexeme+")");
                                this.lexicalResults.addSymbolTable(symbol); 
                                this.lexicalResults.addLexemeTable(tmpLexeme, LexemeType.INT_LITERAL, currentLexeme);
                            } else {
                                break;
                            }
                        } else if (isCharacter(currentSymbol)) {
                            tmpLexeme += currentSymbol;
                            for (int i = 1 ; i < lexemeSplited.length() ; i++) {
                                ++currentSymbolAmount;
                                currentSymbol = lexemeSplited.charAt(i);
                                if ((isCharacter(currentSymbol)) || (isNumber(currentSymbol))) {
                                    tmpLexeme += currentSymbol;
                                } else {
                                    this.lexicalResults.addError(ErrorType.INVALID_LEXEME_ERR ,index, currentSymbolAmount);
                                    error = true;
                                    break;
                                }
                            }
                            if (!error) {
                                //FOUND A IDENTIFIER, THEN, SAVES AT SYMBOL TABLE AND LEXEME TABLE.
                                ++currentLexeme;
                                if (isReservedWord(tmpLexeme)) {
                                    this.lexicalResults.addLexemeTable(tmpLexeme, LexemeType.RESERVED_SYMBOL, currentLexeme);
                                } else {
                                    SymbolTable symbol = new SymbolTable(LexemeType.IDENTIFIER, tmpLexeme, currentLexeme);
                                    this.lexicalResults.addSymbolTable(symbol); 
                                    this.lexicalResults.addLexemeTable(tmpLexeme, LexemeType.IDENTIFIER, currentLexeme);
                                    //System.out.println("adding: " + tmpLexeme + "("+currentLexeme+")");
                                }
                            } else {
                                break;
                            }
                        } else if (isOperand(currentSymbol)) {
                            ++currentLexeme;
                            tmpLexeme += currentSymbol;
                            this.lexicalResults.addLexemeTable(tmpLexeme, LexemeType.OPERATOR, currentLexeme);
                            //System.out.println("adding: " + tmpLexeme + "("+currentLexeme+")");
                        } else if (isSeparator(currentSymbol)) {
                            ++currentLexeme;
                            tmpLexeme += currentSymbol;
                            this.lexicalResults.addLexemeTable(tmpLexeme, LexemeType.SEPARATOR, currentLexeme);
                            //System.out.println("adding: " + tmpLexeme + "("+currentLexeme+")");
                        }
                        if (comment) {
                            break;
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
     * This method verifys if the a lexeme received by
     * param is a comment.
     * 
     * @param lexeme A lexeme for test.
     * @return Boolean The result that indicates if lexeme is comment.
     */
    private Boolean isComment(String lexeme) {
        for (String symbol : this.commentDelimiter) {
            if (lexeme.equals(symbol)) {
                System.out.println("LEXEMEEE " + lexeme);
                return true;
            }
        }

        //System.out.println("LEXEMEEE " + lexeme);
        return false;
    }

    /**
     * This method verifys if a lexeme is a reserved word
     * specificated by language grammar.
     * 
     * @param identifier A lexeme for verification.
     * @return Boolean The result that indicates if lexeme is or isn't reserved word.
     */
    private Boolean isReservedWord(String identifier) {
        for (String symbol : this.reservedWords) {
            if (identifier.equals(symbol)) {
                return true;
            }
        }
        return false;
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