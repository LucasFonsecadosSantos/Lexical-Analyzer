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
    String[] separators;

    public Automaton() {
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
        this.separators = new String[]{
            ",", ".", "[", "{", "(", ")", "}", "]"
        };
    }

    public void makeTokens(String sourceLine, int index) {
        if (!sourceLine.equals("")) {
            String[] lexemes = sourceLine.split(" ");
            String tmpLexeme;
            Boolean error = false;
            for (String lexeme : lexemes) {
                if (isNumber(lexeme.charAt(0))) {
                    for (int i=1 ; i < lexeme.length() ; i++) {
                        if (isNumber(lexeme.charAt(i))) {
                            continue;
                        } else {
                            LexicalErrors.addError(LexicalErrors.type.INVALID_LEXEME_ERR ,index);
                            error = true;
                            break;
                        }
                    }
                    if (!error) {
                        //ADICIONA NA TABELA DE SIMBULOS COMO UM BAGUI NUMERO
                    }
                }
            }
            return;
        } else {
            return;
        }
    }

    private Boolean isNumber(char lexeme) {
        if (
            lexeme == '0' || lexeme == '1' || lexeme == '2' ||
            lexeme == '3' || lexeme == '4' || lexeme == '5' ||
            lexeme == '6' || lexeme == '7' || lexeme ==  '8' ||
            lexeme == '9'
        ) {
            return true;
        } else {
            return false;
        }
    }
}