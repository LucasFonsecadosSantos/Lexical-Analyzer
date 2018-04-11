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
            '0', '1', '2', '3', '4', '5'
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
        this.operators = new String[]{
            "=", "==", ">", "++", "&&",
            "<=", "!", "-", "--", "+", 
            "+=", "*"};
        this.separators = new char[]{
            ',', '.', '[', '{', '(', ')', '}', ']'
        };
    }

    public void makeTokens(String sourceLine, int index) {
        if (!sourceLine.equals("")) {
            String[] lexemes = sourceLine.split(" ");
            String tmpLexeme;
            Boolean error = false;
            for (String lexeme : lexemes) {
                tmpLexeme = "";
                if (isNumber(lexeme.charAt(0))) {
                    for (int i=1 ; i < lexeme.length() ; i++) {
                        if (isNumber(lexeme.charAt(i))) {
                            tmpLexeme += lexeme.charAt(i);
                            continue;
                        } else {
                            if (isOperand(lexeme.charAt(i))) {
                                //ENCONTROU OPERANDO NO MEIO DO NUMERO
                                //adicionar o operando a tabela de simbulos;
                                //verificar se o proximo e operando
                                    //se for, erro,
                                    // se nao for,
                            } else {
                                //É SEPARADOR OU LETRA
                                LexicalErrors.addError(LexicalErrors.type.INVALID_LEXEME_ERR ,index);
                                error = true;
                                break;
                            }
                        }
                    }
                    if (!error) {
                        //ADICIONA NA TABELA DE SIMBULOS COMO UM BAGUI NUMERO
                    }
                } else if (isCharacter(lexeme.charAt(0))) {
                    for (int i=1 ; i < lexeme.length() ; i++) {
                        if (isCharacter(lexeme.charAt(i) || isNumber(lexeme.charAt(i))) {
                            tmpLexeme += lexeme.charAt(i);
                            continue;
                        } else {
                            if (isOperand(lexeme.charAt(i))) {
                                //PALAVRA ENCONTROU UM OPERANDO NO MEIO
                            } else if(isSeparator(lexeme.charAt(i))) {
                                //PALAVRA COM SEPADOR
                            } else {
                                LexicalErrors.addError(LexicalErrors.type.INVALID_CHARACTER_ERR ,index);
                                error = true;
                                break;
                            }
                        }
                        if (!error) {
                            //ADICIONA NA TABELA DE SIMBULOS COMO UM BAGUI SINISTRO DE IDENTIFICADOR
                        }
                    }
                } else if (isOperand(lexeme.charAt(0))) {
                    if(isOperand(lexeme.charAt(2))) {
                        LexicalErrors.addError(LexicalErrors.type.INVALID_OPERAND_ERR ,index);
                        error = true;
                    } else if(isOperand(lexeme.charAt(2) )) {

                    }
                } else if (isSeparator(lexeme.charAt(0))) {
                    
                } else {
                    continue;
                }
            }
            return;
        } else {
            return;
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