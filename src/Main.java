import datastructures.PatternLibrary;
import freshui.gui.Header;
import freshui.program.FreshProgram;
import language.Translator;
import language.Pattern;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;

public class Main extends FreshProgram {

    final static int spacing = 45;
    JTextArea morse, english;
    Translator translator;

    /**
     Contains the last search data. Slot 0 contains the morse data,
     while slot 1 contains the english data.
     **/
    String[] history = new String[2];

    public void init(){
        this.setSize(600,400);
        this.setBackground(new Color(211, 211, 211));
        this.setProgramName("Morse Code Translation Tool");

        Header header = new Header(this.getWidth(),"Morse Translator",CENTER,this);
        header.setColor(new Color(67, 169, 130));
        add(header,0,0);

        int textW = (int) (getWidth()*0.3);
        int textH = (int) (getHeight()*0.35);
        int labelW = textW;
        int labelH = 30;

        morse = new JTextArea();
        english = new JTextArea();
        morse.setSize(textW,textH);
        english.setSize(textW,textH);
        add(morse, spacing,header.getHeight()+spacing);
        add(english,getWidth()-english.getWidth()-spacing,morse.getY());
        morse.setWrapStyleWord(true);
        english.setWrapStyleWord(true);
        morse.setLineWrap(true);
        english.setLineWrap(true);

        JLabel morseLabel = new JLabel("Morse Code:");
        morseLabel.setSize(labelW,labelH);
        JLabel englishLabel = new JLabel("English:");
        englishLabel.setSize(labelW,labelH);
        morseLabel.setHorizontalAlignment(SwingConstants.LEFT);
        englishLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(morseLabel,morse.getX(),morse.getY()-morseLabel.getHeight());
        add(englishLabel,english.getX(),english.getY()-englishLabel.getHeight());

        JButton clear = new JButton("Clear All");
        JButton translate = new JButton("Translate");
        JButton copyEnglish = new JButton("Copy English");
        JButton copyMorse = new JButton("Copy Morse");
        JButton clearEnglish = new JButton("Clear");
        JButton clearMorse = new JButton("Clear");

        add(clear, SOUTH);
        add(translate, SOUTH);

        add(copyMorse, morse.getX(), morse.getY()+morse.getHeight() + 10);
        add(copyEnglish, english.getX(), english.getY()+english.getHeight() + 10);

        add(clearMorse,morse.getX(),morse.getY());
        clearMorse.setLocation(morse.getX()+morse.getWidth()-clearMorse.getWidth(), copyMorse.getY());

        add(clearEnglish,english.getX(),english.getY());
        clearEnglish.setLocation(english.getX()+english.getWidth()-clearEnglish.getWidth(), copyEnglish.getY());

        translator = new Translator();

        addActionListeners();

    }

    public void actionPerformed(ActionEvent ae){
        switch (ae.getActionCommand()){
            case "Clear All" -> {
                morse.setText("");
                english.setText("");
            }

            case "Translate" -> {
                if(morse.getText().isEmpty() && !english.getText().isEmpty()){
                    // morse code box is empty, but the english box is not
                    doEnglishToMorse();
                } else if (!morse.getText().isEmpty() && english.getText().isEmpty()){
                    // english box is empty, but the morse code box is not
                    doMorseToEnglish();
                } else {

                    if(history[0].equals(morse.getText()) && !history[1].equals(english.getText())){
                        // morse stayed the same, but english did not
                        doEnglishToMorse();

                    } else if (!history[0].equals(morse.getText()) && history[1].equals(english.getText())) {
                        // morse did not stay the same, but english did
                        doMorseToEnglish();

                    } else if (history[0].equals(morse.getText()) && history[1].equals(english.getText())){
                        // both stayed the same
                        System.out.println("\t* NOTHING NEW TO TRANSLATE");
                    } else if (!(history[0].equals(morse.getText()) && history[1].equals(english.getText()))){
                        // neither the english nor morse stayed the same, but morse takes precedence
                        doMorseToEnglish();
                    } else {
                        System.out.println("ERROR.");
                    }
                }

            }

            case "Copy Morse" -> {
                copyToClipboard(morse.getText());
            }

            case "Copy English" -> {
                copyToClipboard(english.getText());
            }

        }
    }

    public void copyToClipboard(String s){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(s);
        clipboard.setContents(strSel, null);
    }

    public void doMorseToEnglish(){
        System.out.println("\t func.MorseToEnglish");
        // get data
        String morseIn = morse.getText();
        String englishOut = translator.morseToEnglish(Pattern.decode(morseIn));

        // set data
        english.setText(englishOut);
        history[0] = englishOut;
        history[1] = morseIn;

    }

    public void doEnglishToMorse(){
        System.out.println("\t func.EnglishToMorse");
        // get data
        String englishIn = english.getText();
        String morseOut = Translator.englishToStringMorse(englishIn);

        // set data
        morse.setText(morseOut);
        history[0] = morseOut;
        history[1] = englishIn;
    }

    public static void main(String[] args) {
        new Main().start();
    }
}
