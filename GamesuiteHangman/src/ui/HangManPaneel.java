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

        getTekenVenster().reset(spel.getTekening());
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


                spel.raad(guess);

                woord.setText(getSpel().getHint());
                letter.setText("");
                getTekenVenster().teken();


                //toon boodschap als gewonnen of verloren en vraag of speler opnieuw wilt spelen

                if (spel.isGewonnen() || spel.isGameOver()) {

                    int dialogResult = 0;

                    if (spel.isGewonnen()) {
                        dialogResult = JOptionPane.showConfirmDialog(null, "Proficiat! Je hebt gewonnen!\n \n Wil je nog eens spelen?", "Kies", JOptionPane.YES_NO_OPTION);
                    } else {
                        dialogResult = JOptionPane.showConfirmDialog(null, "Jammer, maar helaas\n Het juiste woord was '" + spel.getOplossing() + "'\n \nWil je nog eens spelen?", "Kies", JOptionPane.YES_NO_OPTION);
                    }

                    if (dialogResult == 0) {
                        spel = new HangMan(spel.getSpeler(), spel.getLijst());

                        reset();

                    }
                    if (dialogResult == 1) System.exit((0));
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