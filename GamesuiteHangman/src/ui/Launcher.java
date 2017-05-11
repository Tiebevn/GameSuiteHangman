package ui;

import domain.Speler;
import domain.Tekening;

import javax.swing.*;


public class Launcher {

    public static void main(String[] args) {

        String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
        Speler speler = new Speler(naam);

        JOptionPane.showMessageDialog(null, "... zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);


        GameHoofdScherm view = new GameHoofdScherm(speler.getNaam(), new Tekening("Test"));
        view.setVisible(true);
        view.teken();


    }

}
