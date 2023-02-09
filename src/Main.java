import datastructures.PatternLibrary;
import freshui.FreshUI;
import freshui.graphics.FButton;
import freshui.gui.Header;
import freshui.program.FreshProgram;
import language.Translator;
import language.Pattern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main extends FreshProgram {

    final static int spacing = 30;
    JTextArea morse, english;

    public void init(){
        this.setSize(600,400);
        this.setBackground(new Color(154, 154, 154));

        Header header = new Header(this.getWidth(),"Morse Translator",CENTER,this);
        header.setColor(new Color(203, 103, 47));
        add(header,0,0);

        int textW = (int) (getWidth()*0.35);
        int textH = getHeight()/3;
        int labelW = textW;
        int labelH = 30;

        morse = new JTextArea();
        english = new JTextArea();
        morse.setSize(textW,textH);
        english.setSize(textW,textH);
        add(morse, spacing,header.getHeight()+spacing);
        add(english,getWidth()-english.getWidth()-spacing,morse.getY());

        JLabel morseLabel = new JLabel("Morse Code:");
        morseLabel.setSize(labelW,labelH);
        JLabel englishLabel = new JLabel("English:");
        englishLabel.setSize(labelW,labelH);
        morseLabel.setHorizontalAlignment(SwingConstants.LEFT);
        englishLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(morseLabel,morse.getX(),morse.getY()-morseLabel.getHeight());
        add(englishLabel,english.getX(),english.getY()-englishLabel.getHeight());

        JButton clear = new JButton("Clear");
        JButton translate = new JButton("Translate");

        add(clear, SOUTH);
        add(translate, SOUTH);

        addActionListeners();

    }

    public void actionPerformed(ActionEvent ae){
        switch (ae.getActionCommand()){
            case "Clear" -> {
                morse.setText("");
                english.setText("");
            }

            case "Translate" -> {
                if(morse.getText().isEmpty() && !english.getText().isEmpty()){
                    //* morse code box is empty, but the english box is not

                    // translate english to morse
                    String englishIn = morse.getText();
                    english.setText(Translator.englishToStringMorse(englishIn));

                } else if (!morse.getText().isEmpty() && english.getText().isEmpty()){
                    //* english box is empty, but the morse code box is not

                    // translate morse to english
                    String morseIn = morse.getText();
                    english.setText(Translator.morseToEnglish(Pattern.decode(morseIn)));

                } else {
                    System.out.println("\t ERROR! Both boxes are full. Clear before translating again.");
                }

            }
        }
    }

    public static void main(String[] args) {
        new Main().start();
    }
}
