package language;

import datastructures.PatternLibrary;

import java.util.ArrayList;

public class Pattern implements Symbols, Comparable<Pattern> {

    private ArrayList<Character> symbols;
    public static boolean doSlashes = false;

    public Pattern(){
        symbols = new ArrayList<>();
    }

    public Pattern(String input){
        symbols = new ArrayList<>();
        StringBuffer read = new StringBuffer();

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) != ' '){
                read.append(input.charAt(i));
                symbols.add(input.charAt(i));
            }
        }
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < symbols.size(); i++) {
            sb.append(symbols.get(i));
        }
        if(doSlashes){
            sb.append("//");
        }

        return sb.toString();
    }

    @Override
    public int compareTo(Pattern o) {
        if(o.toString().equals(this.toString())){
            return 0;
        } else {
            return -1;
        }
    }

    public boolean equals(Pattern o){
        return o.toString().equals(this.toString());
    }

    public static ArrayList<Pattern> decode(String in){
        // TODO rewrite to be functional
        ArrayList<Pattern> patterns = new ArrayList<>();
        for (int i = 0; i < in.length()-1; i++) {
            StringBuffer morsePattern = new StringBuffer();
            boolean isSpace = false;
            while(in.charAt(i)!= ' ' && i < in.length()-1){

                // check to see if a space would be valid in the area
                if(i<in.length()-2) {
                    // check to see if there's a space
                    if (in.charAt(i) == '/' && in.charAt(i + 1) == '/'){
                        isSpace = true;
                        morsePattern.append("//");
                        break;
                    }
                }
                morsePattern.append(in.charAt(i++));
            }

            if(isSpace){
                patterns.add(PatternLibrary.SPACE);
            } else {
                patterns.add(new Pattern(morsePattern.toString()));
                patterns.add(PatternLibrary.LETTER_SEPARATOR);
            }
        }

        return patterns;
    }

}
