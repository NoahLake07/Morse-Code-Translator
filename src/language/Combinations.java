package language;

public interface Combinations {

    // ALL SIMPLE 26 ENGLISH ALPHABET CHARACTERS
    public final static Pattern A = new Pattern("._");
    public final static Pattern B = new Pattern("_...");
    public final static Pattern C = new Pattern("_._.");
    public final static Pattern D = new Pattern("_..");
    public final static Pattern E = new Pattern(".");
    public final static Pattern F = new Pattern(".._.");
    public final static Pattern G = new Pattern("_ _ .");
    public final static Pattern H = new Pattern("....");
    public final static Pattern I = new Pattern(". .");
    public final static Pattern J = new Pattern(". _ _ _");
    public final static Pattern K = new Pattern("_ . _");
    public final static Pattern L = new Pattern(". _ . .");
    public final static Pattern M = new Pattern("_ _");
    public final static Pattern N = new Pattern("_.");
    public final static Pattern O = new Pattern("_ _ _");
    public final static Pattern P = new Pattern(". _ _ .");
    public final static Pattern Q = new Pattern("_ _ . _");
    public final static Pattern R = new Pattern(". _ .");
    public final static Pattern S = new Pattern(". . .");
    public final static Pattern T = new Pattern("_");
    public final static Pattern U = new Pattern(". . _");
    public final static Pattern V = new Pattern(". . . _");
    public final static Pattern W = new Pattern(". _ _");
    public final static Pattern X = new Pattern("_ . . _");
    public final static Pattern Y = new Pattern("_ . _ _");
    public final static Pattern Z = new Pattern("_ _ . .");
    public final static Pattern LETTER_SEPARATOR = new Pattern("/");
    public final static Pattern SPACE = new Pattern("//");

    // ALL NUMBERS 0-9
    public final static Pattern ONE = new Pattern("._");
    public final static Pattern TWO = new Pattern(".._");
    public final static Pattern THREE = new Pattern("..._");
    public final static Pattern FOUR = new Pattern("...._");
    public final static Pattern FIVE = new Pattern(".");
    public final static Pattern SIX = new Pattern("_....");
    public final static Pattern SEVEN = new Pattern("_...");
    public final static Pattern EIGHT = new Pattern("_..");
    public final static Pattern NINE = new Pattern("_.");
    public final static Pattern ZERO = new Pattern("_____");

}
