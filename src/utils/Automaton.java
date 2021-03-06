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
import table.SymbolTable;
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
 * 
 * ,.[{()}];
 * 
 * abstract extends int protected this
 * boolean false new public true
 * char import null return void
 * class if package static while
 * else instanceof private super
 * 
 * identifier = (a-z|A-Z|_|$){a-z|A-Z|_|0-9|$}
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
     * Valid identifys symbols attribute;
     */
    private char[] identifierSymbols;

    /**
     * Current lexeme attribute.
     */
    private int currentLexeme;

    /**
     * Error state attribute;
     */
    private Boolean errorState;

    /**
     * Comment state attribute.
     */
    private Boolean commentState;

    /**
     * Temporary lexeme construction attribute.
     */
    private String tmpStrLexeme="";

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
        this.identifierSymbols = new char[] {
            'a','b','c','d','e','f','g','h','i',
            'j','k','l','m','n','o','p','q','r','s',
            't','u','v','w','x','y','z','_','$',
            'A','B','C','D','E','F','G','H','I','J','K',
            'L','M','N','O','P','Q','R','S','T','U','V',
            'W','X','Y','Z'
        };
        this.lexicalResults = new LexicalResults();
        this.currentLexeme = 0;
    }

    /**
     * This is automaton core. It's process all lexemes received from
     * source code line, validating all lexeme symbol by symbol.
     * The validations are made by language grammar definitions,
     * identifying errors and success lexemes.
     * 
     * @param sourceLine Source code line.
     * @param lineNumber Source code line number.
     * @return LexicalResults A lexical result object with all tables constructed by automaton process.
     */
    public LexicalResults makeTokens(String sourceLine, int lineNumber) {
        if (!sourceLine.equals("")) {
            String[] lexemes = sourceLine.split(" ");
            String[] splitedLexeme;
            String tmpLexeme;
            String commentString = "";
            char currentSymbol;
            int columnNumber = 0;
            Boolean comment = false;
            Boolean tmpComment = false;
            this.errorState = false;
            this.commentState = false;

            if ((commentString = getComment(sourceLine)) != null) {
                tmpComment = true;
            }
            
            for (String lexeme : lexemes) {
                this.tmpStrLexeme = "";
                tmpLexeme = "";
                this.errorState = false;
                if(lexeme.equals("")) continue;
                columnNumber++;

                //If the source line contains a special symbol like +-*();[]
                if ((splitedLexeme = sliptBySpecialCharacteres(lexeme)) == null) {
                    if (lexeme.equals("")) continue;
                    currentSymbol = lexeme.charAt(0);
                    if (isNumber(currentSymbol) && !this.commentState) {
                        columnNumber = numberValidation(lexeme, lineNumber, columnNumber);
                        if (!this.errorState) {
                            ++currentLexeme;
                            storeNumber(lexeme, currentLexeme);
                        } else {
                            break;
                        }
                    } else if (isCharacter(currentSymbol) && !this.commentState) {
                        columnNumber = identifierValidation(lexeme, lineNumber, columnNumber);
                        if (!this.errorState) {
                            ++currentLexeme;
                            storeIdentifier(this.tmpStrLexeme, currentLexeme);
                        } else {
                            break;
                        }
                    } else {
                        identifierValidation(lexeme, lineNumber, columnNumber);
                    }
                } else {
                    for (String lexemeSplited : splitedLexeme) {
                        tmpLexeme = "";
                        if(lexemeSplited.equals("")) continue;
                        ++columnNumber;
                        currentSymbol = lexemeSplited.charAt(0);
                        if (isNumber(currentSymbol) && !this.commentState) {
                            columnNumber = numberValidation(lexemeSplited, lineNumber, columnNumber);
                            if (!this.errorState) {
                                ++currentLexeme;
                                storeNumber(lexemeSplited, currentLexeme);
                            } else {
                                break;
                            }
                        } else if (isCharacter(currentSymbol) && !this.commentState) {
                            columnNumber = identifierValidation(lexemeSplited, lineNumber, columnNumber);
                            if (!this.errorState) {
                                ++currentLexeme;
                                storeIdentifier(this.tmpStrLexeme, currentLexeme);
                            } else {
                                break;
                            }
                        } else if (isOperand(lexemeSplited) && !this.commentState) {
                            ++currentLexeme;
                            storeOperator(lexemeSplited, currentLexeme);
                        } else if (isSeparator(currentSymbol) && !this.commentState) {
                            ++currentLexeme;
                            storeSeparator(currentSymbol, currentLexeme);
                        }
                        if (comment) {
                            break;
                        }
                    }
                }
            }
            if (!commentString.equals("")) {
                this.currentLexeme++;
                storeComment(commentString, this.currentLexeme);
            }
            return this.lexicalResults;
        } else {
            return null;
        }
                
    }

    /**
     * Comment handling method. This method runs the
     * source code line searching a comment delimiter
     * and after that, returns it to save by next.
     * 
     * @param line Source code line.
     */
    private String getComment(String line) {
        String tmpComment = "";
        Boolean commentFound = false;
        for (int i=0 ; i < line.length() ; i++) {
            if (commentFound) {
                tmpComment += line.charAt(i);
            }
            if ((line.charAt(i) == '/') && (line.charAt(i+1) == '/') && !(commentFound)) {
                tmpComment += String.valueOf(line.charAt(i)) + String.valueOf(line.charAt(i+1));
                i += 1;
                commentFound = true;
            }
        }
        return tmpComment;
    }

    /**
     * This method is responsible for validation of any comments pattern, delimited
     * by '//' symbols.
     * 
     * @param lexeme The lexeme (first in source code line).
     * @param lexemeArray The source code line.
     * @param columnNumber The current column number.
     * @return String The string comment extract from source code line.
     */
    private String commentValidation(String lexeme, String[] lexemeArray, int columnNumber) {
        String commentLexeme = "";
        Boolean control = false;
        for (String commentString : lexemeArray) {
            if (control) {
                commentLexeme += commentString;
            } else {
                control = isComment(commentString);
                if (control) commentLexeme += commentString;
            }
        }
        return commentLexeme;
    }

    /**
     * This method is responsible for number pattern validation.
     * 
     * @param lexeme The lexeme to be validated.
     * @param index The source code line number.
     * @param columnNumber The column number.
     * @return int The column number update.
     */
    private int numberValidation(String lexeme, int index, int columnNumber) {
        char currentSymbol = lexeme.charAt(0);
        String tmpLexeme = "";
        tmpLexeme += currentSymbol;
        for (int i = 1 ; i < lexeme.length() ; i++) {
            ++columnNumber;
            currentSymbol = lexeme.charAt(i);
            if (isNumber(currentSymbol)) {
                tmpLexeme += currentSymbol;
            } else {
                this.lexicalResults.addError(ErrorType.INVALID_NUMBER_ERR ,index, columnNumber);
                this.errorState = true;
                break;
            }
        }
        return columnNumber;
    }

    /**
     * This method is responsible for identifier pattern validation.
     * 
     * @param lexeme The lexeme to be validated.
     * @param index The source code line number.
     * @param columnNumber The column number update.
     */
    private int identifierValidation(String lexeme, int index, int columnNumber) {
        char currentSymbol;
        this.tmpStrLexeme = "";
        for (String symbol : this.commentDelimiter) {
            if (symbol.equals(lexeme)) {
                this.commentState = true;
                return columnNumber;
            }
        }
        for (int i=0 ; i<lexeme.length() ; i++) {
            currentSymbol = lexeme.charAt(i);
            if ((isCharacter(currentSymbol)) || (isNumber(currentSymbol))) {
                this.tmpStrLexeme += currentSymbol;
                ++columnNumber;
            } else if ((i < lexeme.length()-1 ) && (currentSymbol == '/') && (lexeme.charAt(i+1) == '/')) {
                this.commentState = true;
                return columnNumber;
            } else {
                this.lexicalResults.addError(ErrorType.INVALID_LEXEME_ERR ,index, columnNumber);
                this.errorState = true;
                break;
            }
        }
        return columnNumber;
    }
    
    /**
     * This method is responsible for stores a comment, extracted
     * from source code line.
     * 
     * @param lexeme A comment lexeme to be stored.
     * @param lexemeIndex The lexeme index value.
     */
    private void storeComment(String lexeme, int lexemeIndex) {
        this.lexicalResults.addLexemeTable(" " + lexeme, LexemeType.COMMENT, currentLexeme);
    }

    /**
     * This method is responsible for stores a separator lexeme at lexeme table,
     * extracted from source code line.
     * 
     * @param lexeme A separator lexeme to be stored.
     * @param lexemeIndex A separator lexeme index value.
     */
    private void storeSeparator(char lexeme, int lexemeIndex) {
        this.lexicalResults.addLexemeTable(String.valueOf(lexeme), LexemeType.SEPARATOR, lexemeIndex);
    }

    /**
     * This method is responsible for stores a operator lexeme at lexeme table,
     * extracted from source code line.
     * 
     * @param lexeme A operator lexeme to be stored.
     * @param lexemeIndex A operator lexeme index value.
     */
    private void storeOperator(String lexeme, int lexemeIndex) {
        this.lexicalResults.addLexemeTable(lexeme, LexemeType.OPERATOR, lexemeIndex);
    }

    /**
     * This method is responsible for stores a number lexeme at lexeme table,
     * extracted from source code line.
     * 
     * @param lexeme A number lexeme to be stored.
     * @param lexemeIndex A number lexeme index value.
     */
    private void storeNumber(String lexeme, int lexemeIndex) {
        this.lexicalResults.addSymbolTable(new SymbolTable(LexemeType.INT_LITERAL, lexeme, lexemeIndex)); 
        this.lexicalResults.addLexemeTable(lexeme, LexemeType.INT_LITERAL, lexemeIndex);
    }

    /**
     * This method is responsible for stores a identifier lexeme at lexeme table,
     * extracted from source code line.
     * 
     * @param lexeme A identifier lexeme to be stored.
     * @param lexemeIndex A identifier lexeme index value.
     */
    private void storeIdentifier(String lexeme, int lexemeIndex) {
        if (isReservedWord(lexeme)) {
            this.lexicalResults.addLexemeTable(lexeme, LexemeType.RESERVED_SYMBOL, lexemeIndex);
        } else {
            this.lexicalResults.addSymbolTable(new SymbolTable(LexemeType.IDENTIFIER, lexeme, lexemeIndex)); 
            this.lexicalResults.addLexemeTable(lexeme, LexemeType.IDENTIFIER, lexemeIndex);
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
            if (lexeme.equals(symbol) || lexeme.contains(symbol)) {
                return true;
            }
        }
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
        //return ((Character.isLetter(character) || character == '$' | character == '_'));
        for (char symbol : this.identifierSymbols) {
            if (character == symbol) {
                return true;
            }
        }
        return false;
    } 

    /**
     * This method verifys if the character is a valid operator by the conditions
     * expressed by language grammar.
     * 
     * @param operand A character that will be avaliated if it's operator.
     * @return Boolean True if the character is operator by language grammar definitions.
     */
    private Boolean isOperand(String lexeme) {
        for (String operator : this.operators) {
            if (operator.equals(lexeme)) {
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