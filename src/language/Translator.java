package language;

import datastructures.PatternLibrary;

import java.util.ArrayList;

public class Translator implements Symbols {

    public static PatternLibrary library = new PatternLibrary();

    public static String morseToEnglish(ArrayList<Pattern> letters){
        StringBuffer finishedText = new StringBuffer();

        for (int i = 0; i < letters.size(); i++) {
            finishedText.append(morsePatternToLetter(letters.get(i)));
        }

        return finishedText.toString();
    }

    public static Character morsePatternToLetter(Pattern pattern){
        return library.get(pattern);
    }

    public static String englishToStringMorse(String englishIn){
        return null;
    }

}
