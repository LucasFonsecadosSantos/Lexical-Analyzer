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
package view;

/**
 * This class makes all iteration with humans by terminal
 * way. It's responsible for formatting any messages for
 * console print out.
 * 
 * @author Lucas Fonseca Dos Santos
 * @author Igor Augusto da Costa Nunes
 * @author Alan Luz Silveira
 * @version 1.0
 * @since 1.0
 */
public class GUI {

    /**
     * RESET
     * Unix RESET color string code. Constant value attribute.
     */
    private static final String RESET = "\033[0m";  // Text Reset

    /**
     * REGULAR COLORS
     * Unix BLACK color string code. Constant value attribute.
     */
    private static final String BLACK = "\033[0;30m";

    /**
     * Unix RED color string code. Constant value attribute.
     */
    private static final String RED = "\033[0;31m";

    /**
     * Unix GREEN color string code. Constant value attribute.
     */
    private static final String GREEN = "\033[0;32m";
    
    /**
     * Unix YELLOW color string code. Constant value attribute.
     */
    private static final String YELLOW = "\033[0;33m";
    
    /**
     * Unix BLUE color string code. Constant value attribute.
     */
    private static final String BLUE = "\033[0;34m";

    /**
     * Unix PURPLE color string code. Constant value attribute.
     */
    private static final String PURPLE = "\033[0;35m";

    /**
     * Unix CYAN color string code. Constant value attribute.
     */
    private static final String CYAN = "\033[0;36m";

    /**
     * Unix WHITE color string code. Constant value attribute.
     */
    private static final String WHITE = "\033[0;37m";

    /**
     * BOLD COLORS PATTERN
     * Unix BLACK BOLD color string code. Constant value attribute.
     */
    private static final String BLACK_BOLD = "\033[1;30m";

    /**
     * Unix RED BOLD color string code. Constant value attribute.
     */
    private static final String RED_BOLD = "\033[1;31m";
    
    /**
     * Unix GREEN BOLD color string code. Constant value attribute.
     */
    private static final String GREEN_BOLD = "\033[1;32m";
    
    /**
     * Unix YELLOW BOLD color string code. Constant value attribute.
     */
    private static final String YELLOW_BOLD = "\033[1;33m";
    
    /**
     * Unix BLUE BOLD color string code. Constant value attribute.
     */
    private static final String BLUE_BOLD = "\033[1;34m";
    
    /**
     * Unix PURPLE BOLD color string code. Constant value attribute.
     */
    private static final String PURPLE_BOLD = "\033[1;35m";
    
    /**
     * Unix CYAN BOLD color string code. Constant value attribute.
     */
    private static final String CYAN_BOLD = "\033[1;36m";
    
    /**
     * Unix WHITE BOLD color string code. Constant value attribute.
     */
    private static final String WHITE_BOLD = "\033[1;37m";


    /**
     * COLORS AND UNDERLINE DECORATION PATTERN
     * Unix BLACK UNDERLINED color string code. Constant value attribute.
     */
    private static final String BLACK_UNDERLINED = "\033[4;30m";

    /**
     * Unix RED UNDERLINED color string code. Constant value attribute.
     */
    private static final String RED_UNDERLINED = "\033[4;31m";

    /**
     * Unix GREEN UNDERLINED color string code. Constant value attribute.
     */
    private static final String GREEN_UNDERLINED = "\033[4;32m";

    /**
     * Unix YELLOW UNDERLINED color string code. Constant value attribute.
     */
    private static final String YELLOW_UNDERLINED = "\033[4;33m";

    /**
     * Unix BLUE UNDERLINED color string code. Constant value attribute.
     */
    private static final String BLUE_UNDERLINED = "\033[4;34m";

    /**
     * Unix PURPLE UNDERLINED color string code. Constant value attribute.
     */
    private static final String PURPLE_UNDERLINED = "\033[4;35m";
    
    /**
     * Unix CYAN UNDERLINED color string code. Constant value attribute.
     */
    private static final String CYAN_UNDERLINED = "\033[4;36m";

    /**
     * Unix WHITE UNDERLINED color string code. Constant value attribute.
     */
    private static final String WHITE_UNDERLINED = "\033[4;37m";

    
    /**
     * BACKGROUND PATTERN
     * Unix BLACK BACKGROUND color string code.
     * Constant value attribute.
     */
    private static final String BLACK_BACKGROUND = "\033[40m";
    
    /**
     * Unix RED BACKGROUND color string code.
     * Constant value attribute.
     */
    private static final String RED_BACKGROUND = "\033[41m";

    /**
     * Unix GREEN BACKGROUND color string code.
     * Constant value attribute.
     */
    private static final String GREEN_BACKGROUND = "\033[42m";

    /**
     * Unix YELLOW BACKGROUND color string code.
     * Constant value attribute.
     */
    private static final String YELLOW_BACKGROUND = "\033[43m";

    /**
     * Unix BLUE BACKGROUND color string code.
     * Constant value attribute.
     */
    private static final String BLUE_BACKGROUND = "\033[44m";

    /**
     * Unix PURPLE BACKGROUND color string code.
     * Constant value attribute.
     */
    private static final String PURPLE_BACKGROUND = "\033[45m";

    /**
     * Unix CYAN BACKGROUND color string code.
     * Constant value attribute.
     */
    private static final String CYAN_BACKGROUND = "\033[46m";

    /**
     * Unix WHITE BACKGROUND color string code.
     * Constant value attribute.
     */
    private static final String WHITE_BACKGROUND = "\033[47m";

    /**
     * HIGHT INTENSITY COLORS PATTERN
     * Unix BLACK BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String BLACK_BRIGHT = "\033[0;90m";
    
    /**
     * Unix RED BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String RED_BRIGHT = "\033[0;91m";
    
    /**
     * Unix GREEN BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String GREEN_BRIGHT = "\033[0;92m";
    
    /**
     * Unix YELLOW BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String YELLOW_BRIGHT = "\033[0;93m";

    /**
     * Unix BLUE BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String BLUE_BRIGHT = "\033[0;94m";

    /**
     * Unix PURPLE BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String PURPLE_BRIGHT = "\033[0;95m";

    /**
     * Unix CYAN BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String CYAN_BRIGHT = "\033[0;96m";

    /**
     * Unix WHITE BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String WHITE_BRIGHT = "\033[0;97m";

    
    /**
     * HIGH INTENSITY BOLD COLORS PATTERN
     * Unix BLACK BOLD BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String BLACK_BOLD_BRIGHT = "\033[1;90m";
    
    /**
     * Unix RED BOLD BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String RED_BOLD_BRIGHT = "\033[1;91m";
    
    /**
     * Unix GREEN BOLD BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String GREEN_BOLD_BRIGHT = "\033[1;92m";

    /**
     * Unix YELLOW BOLD BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";

    /**
     * Unix BLUE BOLD BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String BLUE_BOLD_BRIGHT = "\033[1;94m";

    /**
     * Unix PURPLE BOLD BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";

    /**
     * Unix CYAN BOLD BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String CYAN_BOLD_BRIGHT = "\033[1;96m";

    /**
     * Unix WHITE BOLD BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String WHITE_BOLD_BRIGHT = "\033[1;97m";

    /**
     * HIGH INTENSITY BACKGROUNDS PATTERN
     * Unix BLACK BACKGROUND BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";
    
    /**
     * Unix RED BACKGROUND BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String RED_BACKGROUND_BRIGHT = "\033[1;101m";
    
    /**
     * Unix GREEN BACKGROUND BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";

    /**
     * Unix YELLOW BACKGROUND BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String YELLOW_BACKGROUND_BRIGHT = "\033[30;103m";

    /**
     * Unix BLUE BACKGROUND BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";

    /**
     * Unix PURPLE BACKGROUND BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m";

    /**
     * Unix CYAN BACKGROUND BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";

    /**
     * Unix WHITE BACKGROUND BRIGHT color string code.
     * Constant value attribute.
     */
    private static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";
    
    /**
     * This method prints out a sucessffully message from compiler
     * process to user by console.
     * 
     * @param message A successfully message from compiler process.
     */
    public static void printSuccessfullyMessage(String message) {
        System.out.println(WHITE_BRIGHT + "[" + GREEN_BRIGHT + "OK" + WHITE_BRIGHT + "] " + message + ".");
    }

    /**
     * This method prints out a error message from compiler
     * process to user by console.
     * 
     * @param message A error message from compiler process.
     */
    public static void printErrorMessage(String title, String message) {
        System.out.println(WHITE_BRIGHT + "[" + RED_BRIGHT + "ERROR" + WHITE_BRIGHT + "] "
        + RED_BACKGROUND_BRIGHT + " " + title.toUpperCase() + " " + RED_BRIGHT + ": " + message + ".");
    }

    /**
     * This method prints out a warning message from compiler
     * process to user by console.
     * 
     * @param message A warning message from compiler process.
     */
    public static void printWarningMessage(String title, String message) {
        System.out.println(WHITE_BRIGHT + "[" + YELLOW_BRIGHT + "WARNING" + WHITE_BRIGHT + "] " + 
        YELLOW_BACKGROUND_BRIGHT + " " + title.toUpperCase() + " " + YELLOW_BRIGHT + ": " + message + ".");
    }

    /**
     * This method prints out a information message from compiler
     * process to user by console.
     * 
     * @param message A information message from compiler process.
     */
    public static void printInformationMessage(String message) {
        System.out.println(WHITE_BRIGHT + "[" + CYAN_BRIGHT + "INFORMATION" + WHITE_BRIGHT + "] " + CYAN_BRIGHT + message + ".");
    }

    /**
     * This method prints out a action message from compiler
     * process to user by console.
     * 
     * @param message A action message from compiler process.
     */
    public static void printActionMessage(String message) {
        System.out.println(WHITE_BRIGHT + "[..] " + message + ".");
    }

    /**
     * This method cleans the console with a string.
     */
    public static void clear() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}