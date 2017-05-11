package ui;

import domain.HangMan;
import domain.Speler;
import domain.WoordenLijst;

import javax.swing.*;


public class Launcher {

    public static void main(String[] args) {

        String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
        Speler speler = new Speler(naam);

        JOptionPane.showMessageDialog(null, speler.getNaam() + " zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);


        WoordenLijst lijst = new WoordenLijst();
        lijst.importWords();


        HangMan hangMan = new HangMan(speler, lijst);

        HangManPaneel panel = new HangManPaneel(hangMan);

        HangManHoofdScherm view = new HangManHoofdScherm(hangMan, panel);
        view.setVisible(true);


    }

}
