package language;

import datastructures.PatternLibrary;

import java.util.ArrayList;

public class Translator implements Symbols {

    public static PatternLibrary library = new PatternLibrary();
    public static boolean doSlashes = false;

    public String morseToEnglish(ArrayList<Pattern> letters) {
        StringBuffer finishedText = new StringBuffer();

        for (int i = 0; i < letters.size(); i++) {
            finishedText.append(morsePatternToLetter(letters.get(i)));
        }

        return finishedText.toString();
    }

    public static Character morsePatternToLetter(Pattern pattern) {
        return library.get(pattern);
    }

    public static String englishToStringMorse(String englishIn) {
        StringBuffer toPattern = new StringBuffer();
        for (int i = 0; i < englishIn.length(); i++) {
            if (englishIn.charAt(i) == ' ') {
                // space character
                toPattern.append(library.SPACE + " ");
            } else if ((doSlashes && englishIn.charAt(i) == Combinations.LETTER_SEPARATOR.toString().charAt(0))){

            } else {
                // not a space character
                toPattern.append(library.get(englishIn.charAt(i)));
                if(doSlashes){
                    toPattern.append('/');
                } else {
                    toPattern.append(' ');
                }
            }
        }
        return toPattern.toString();
    }
}
