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
            char ch = input.charAt(i);
            if(ch != ' '){

                if(ch == '-'){
                    ch = '_';
                }

                if(ch == '*'){
                    ch = '.';
                }

                read.append(ch);
                symbols.add(ch);
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
        ArrayList<Pattern> patterns = new ArrayList<>();

        String[] divided = in.split(" ");
        for (int i = 0; i < divided.length; i++) {
            patterns.add(new Pattern(divided[i]));
        }

        return patterns;
    }

}
