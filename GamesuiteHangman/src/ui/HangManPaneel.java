package ui;

import domain.HangMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HangManPaneel extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField letter;
    private JLabel woord;

    private TekenVenster tekenVenster;
    private HangMan spel;

    public HangManPaneel(HangMan spel) {
        super();
        setSpel(spel);
        init();
    }

    private void init() {
        letter = new JTextField("", 5);
        woord = new JLabel("");

        this.setLayout(new BorderLayout());
        this.add(letter, BorderLayout.EAST);
        this.add(woord, BorderLayout.CENTER);

        letter.addKeyListener(new RaadLuisteraar());
    }

    private void reset() {
        woord.setText(getSpel().getHint());
        getTekenVenster().teken();
    }

    private HangMan getSpel() {
        return spel;
    }

    private void setSpel(HangMan spel) {
        this.spel = spel;
    }

    private TekenVenster getTekenVenster() {
        return tekenVenster;
    }

    public void setTekenVenster(TekenVenster tekenVenster) {
        this.tekenVenster = tekenVenster;

        reset();
    }

    public class RaadLuisteraar implements KeyListener {

        @Override
        public void keyPressed(KeyEvent arg0) {
            if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
                String input = letter.getText();
                char guess = '\u0000';
                if (input.length() > 0) {
                    guess = input.charAt(0);
                }
                //TODO raad

                if (!spel.raad(guess)) {

                    spel.getGalg().zetVolgendeZichtBaar();
                }

                woord.setText(getSpel().getHint());
                letter.setText("");
                getTekenVenster().teken();

                //TODO
                //toon boodschap als gewonnen of verloren en vraag of speler opnieuw wilt spelen

                if (spel.isGewonnen()) {
                    // GEWONNEN
                } else if (spel.isGameOver()) {
                    // VERLOREN
                }

                //als de speler opnieuw wilt spelen: herzet het spel en het paneel
                //anders stop (System.exit(0))
            }
        }

        @Override
        public void keyReleased(KeyEvent arg0) {/* Niet nodig*/}

        @Override
        public void keyTyped(KeyEvent arg0) {/* Niet nodig*/}
    }
}