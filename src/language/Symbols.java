package language;

public interface Symbols {

    String DOT = ".";
    String DASH = "-";

    /**
     * The character '/' in morse represents a letter break to prevent confusion between individual letters
     */
    String LETTER_BREAK = "/";

    /**
     * The character sequence "//" represents a phrase break to prevent confusion between words
     */
    String PHRASE_BREAK = "//";

}
