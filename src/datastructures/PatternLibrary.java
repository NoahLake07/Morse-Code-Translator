package datastructures;

import language.Combinations;
import language.Pattern;

import java.awt.print.Printable;
import java.util.ArrayList;

public class PatternLibrary implements Combinations {

    private ArrayList<Node> tree = new ArrayList<>();

    public PatternLibrary(){
        add(A,'A');
        add(B,'B');
        add(C,'C');
        add(D,'D');
        add(E,'E');
        add(F,'F');
        add(G,'G');
        add(H,'H');
        add(I,'I');
        add(J,'J');
        add(K,'K');
        add(L,'L');
        add(M,'M');
        add(N,'N');
        add(O,'O');
        add(P,'P');
        add(Q,'Q');
        add(R,'R');
        add(S,'S');
        add(T,'T');
        add(U,'U');
        add(V,'V');
        add(W,'W');
        add(X,'X');
        add(Y,'Y');
        add(Z,'Z');
        add(SPACE, ' ');
        add(LETTER_SEPARATOR, "");

    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for (int i = 0; i < tree.size(); i++) {
            sb.append(tree.get(i).key.toString() + "=" + tree.get(i).value.toString());
            if(i!=tree.size()-1){
                sb.append(",");
            }
        }
        sb.append("}");

        return sb.toString();
    }

    public void add(Node n){
        tree.add(n);
    }

    public void add(Pattern k, Character v){
        tree.add(new Node(k,v));
    }

    public void add(Pattern k, String v){
        tree.add(new Node(k,v.charAt(0)));
    }

    public Character get(Pattern key){
        for (int i = 0; i < tree.size(); i++) {
            if(tree.get(i).key.equals(key)){
                return tree.get(i).value;
            }
        }

        return null;
    }

    private class Node {
        Pattern key;
        Character value;

        Node(Pattern k, Character v){
            this.key = k;
            this.value = v;
        }
    }
}
