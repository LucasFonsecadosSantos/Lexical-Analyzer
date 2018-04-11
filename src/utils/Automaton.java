package utils;

/**
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

    String[] reservedWords;
    String[] operators;
    char[] separators;
    char[] numbers;

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
            ',', '.', '[', '{', '(', ')', '}', ']'
        };
    }

    public void makeTokens(String sourceLine, int index) {
        if (!sourceLine.equals("")) {
            String[] lexemes = sourceLine.split(" ");
            String[] splitedLexeme;
            String tmpLexeme;
            Boolean error;
            for (String lexeme : lexemes) {
                tmpLexeme = "";
                error = false;
                if ((splitedLexeme = sliptBySpecialCharacteres(lexeme)) == null) {
                    
                    if(isNumber(lexeme.charAt(0))) {

                    } else if (isCharacter(lexeme.charAt(0))) {

                    }
                } else {
                    for (String lexemeSplited : splitedLexeme) {
                        tmpLexeme = "";
                        if (isNumber(lexemeSplited.charAt(0))) {
                            for (int i = 1 ; i < lexemeSplited.length() ; i++) {
                                if (isNumber(lexemeSplited.charAt(i))) {
                                    tmpLexeme += lexemeSplited.charAt(i);
                                } else {
                                    LexicalErrors.addError(LexicalErrors.type.INVALID_NUMBER_ERR ,index);
                                    error = true;
                                    break;
                                }
                            }
                            if (!error) {
                                //ADICIONA NA TABELA DE SIMBOLO
                            }
                        } else if (isCharacter(lexemeSplited.charAt(0))) {
                            for (int i = 1 ; i < lexemeSplited.length() ; i++) {
                                if ((isCharacter(lexemeSplited.charAt(i))) || (isNumber(lexemeSplited.charAt(i)))) {
                                    tmpLexeme += lexemeSplited.charAt(i);
                                } else {
                                    LexicalErrors.addError(LexicalErrors.type.INVALID_LEXEME_ERR ,index);
                                    error = true;
                                    break;
                                }
                            }
                            if (!error) {
                                //ADD A TABELA DE SIMBOLO
                            }
                        } else if (isOperand(lexemeSplited.charAt(0))) {
                            //adiciona direto a tabela de simbolo
                        } else if (isSeparator(lexemeSplited.charAt(0))) {
                            //adiciona direto a tabela de simbolos
                        }
                    }
                }
            }
        } else {
            return;
        }
                
    }

    private String[] sliptBySpecialCharacteres(String lexeme) {
        
        /*
        String[] bosta = lexeme.replaceAll(
            "==", "#==#"
        ).replaceAll(
            "=", "#=#"
        ).replaceAll(
            ">", "#>#"
        ).replaceAll(
            "&&", "#&&#"
        ).replaceAll(
            "++", "#++#"
        ).replaceAll(
            "<=", "#<=#"
        ).replaceAll(
            "!", "#!#"
        ).replaceAll(
            "-", "#-#"
        ).replaceAll(
            "--", "#--#"
        ).replaceAll(
            "+", "#+#"
        ).replaceAll(
            "+=", "#+=#"
        ).replaceAll(
            "*", "#*#"
        ).replaceAll(
            ",", "#,#"
        ).replaceAll(
            ".", "#.#"
        ).replaceAll(
            "[", "#[#"
        ).replaceAll(
            "{", "#{#"
        ).replaceAll(
            "(", "#(#"
        ).replaceAll(
            ")", "#)#"
        ).replaceAll(
            "}", "#}#"
        ).replaceAll(
            "]", "#]#"
        ).split( "#");
        System.out.println(bosta.hashCode());*/
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