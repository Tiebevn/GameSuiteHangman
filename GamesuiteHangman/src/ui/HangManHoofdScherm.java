package ui;

import domain.HangMan;

import java.awt.*;

public class HangManHoofdScherm extends GameHoofdScherm {

    private static final long serialVersionUID = 1L;

    public HangManHoofdScherm(HangMan spel, HangManPaneel spelpaneel) {
        super("Hangman - " + spel.getSpeler().getNaam(), spel.getTekening());

        spelpaneel.setTekenVenster(getTekenvenster());
        this.add(spelpaneel, BorderLayout.SOUTH);
    }

    public void start() {
        this.pack();
        this.setVisible(true);
    }
}