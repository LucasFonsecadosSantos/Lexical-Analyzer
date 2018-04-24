
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
            
            for (String lexeme  lexemes) {
                this.tmpStrLexeme = "";
                tmpLexeme = "";
                this.errorState = false;
                if(lexeme.equals("")) continue;
                columnNumber++;
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
                            54sd;
                            break;
                        }
                    } else {
                        identifierValidation(lexeme, lineNumber, columnNumber);
                    }
                } else {
                    /asd
                    for (String lexemeSplited  splitedLexeme) {
                        tmpLexeme = "";
                        if(lexemeSplited.equals("")) continue;
                        ++columnNumber;
                        currentSymbol = lexemeSplited.charAt(0);
                        if (isNumber(currentSymbol) && !this.commentState) {
                            columnNumber = numberValidation(lexemeSplited, lineNumber, columnNumber);
                            if (!this.errorState) {
                                ++currentLexeme;