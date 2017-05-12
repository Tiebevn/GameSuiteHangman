package ui;

import domain.HangMan;
import domain.Speler;
import domain.WoordenLijst;
import domain.exceptions.DomainException;

import javax.swing.*;


public class Launcher {

    public static void main(String[] args) {

        String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");

        try {
            Speler speler = new Speler(naam);
            maakKeuze(speler);
        } catch (DomainException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            main(null);
        }


    }

    private static void maakKeuze(Speler s) {
        String[] keuzes = {"Hangman", "Pictionary", "Afsluiten"};

        selecteerKeuze(JOptionPane.showInputDialog(null, "Welkom " + s.getNaam() + "\n \n Wat wilt u doen?", "input", JOptionPane.INFORMATION_MESSAGE, null, keuzes, null), s);


    }

    private static void selecteerKeuze(Object o, Speler s) {
        try {
            if (o.equals("Hangman")) {


                WoordenLijst lijst = new WoordenLijst();
                lijst.importWords();


                HangMan hangMan = new HangMan(s, lijst);

                HangManPaneel panel = new HangManPaneel(hangMan);

                HangManHoofdScherm view = new HangManHoofdScherm(hangMan, panel);
                view.setVisible(true);

            } else if (o.equals("Pictionary")) {
                JOptionPane.showMessageDialog(null, "Pictionary is nog niet geïmplementeerd");
                maakKeuze(s);
            } else {
                System.exit((0));
            }
        } catch (DomainException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
