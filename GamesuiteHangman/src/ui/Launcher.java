package ui;

import domain.model.*;

import javax.swing.*;

public class Launcher {

    public static void main(String[] args) {

        // VOEG EEN SPELER TOE
        String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
        Speler speler = new Speler(naam);

        JOptionPane.showMessageDialog(null, speler.getNaam() + " zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);

        String[] shapes = {"Cirkel", "Rechthoek", "Lijnstuk", "Driehoek"};
        String input = (String) JOptionPane.showInputDialog(null, "Kies wat u wilt doen", "Input", JOptionPane.QUESTION_MESSAGE, null, shapes, shapes[0]);


        switch (input) {
            case "Cirkel":
                cirkel();
            case "Rechthoek":
                rechthoek();
            case "Lijnstuk":
                lijnStuk();
            case "Driehoek":
                driehoek();

        }


    }

    private static Punt punt() {

        Punt punt = new Punt(0, 0);

        punt.setX(Integer.parseInt(JOptionPane.showInputDialog(null, "Geef een X-waarde")));
        punt.setY(Integer.parseInt(JOptionPane.showInputDialog(null, "Geef een Y-waarde")));

        return punt;
    }

    private static Cirkel cirkel() {

        Punt middelPunt = punt();
        Cirkel cirkel = new Cirkel(middelPunt, Integer.parseInt(JOptionPane.showInputDialog(null, "Geef een straal")));

        JOptionPane.showMessageDialog(null, "U heeft een correcte cirkel aangemaakt " + cirkel.toString());
        return cirkel;
    }

    private static Rechthoek rechthoek() {

        Punt linkerBovenhoek = punt();

        int breedte = Integer.parseInt(JOptionPane.showInputDialog(null, "Geef een breedte"));
        int hoogte = Integer.parseInt(JOptionPane.showInputDialog(null, "Geef een hoogte"));


        Rechthoek rechthoek = new Rechthoek(linkerBovenhoek, breedte, hoogte);

        JOptionPane.showMessageDialog(null, "U heeft een correcte rechthoek aangemaakt " + rechthoek.toString());
        return rechthoek;
    }

    private static Driehoek driehoek() {

        Driehoek driehoek = new Driehoek(punt(), punt(), punt());

        JOptionPane.showMessageDialog(null, "U heeft een correcte rechthoek aangemaakt " + driehoek.toString());
        return driehoek;


    }

    private static LijnStuk lijnStuk() {
        LijnStuk lijnStuk = new LijnStuk(punt(), punt());
        JOptionPane.showMessageDialog(null, "U heeft een correcte rechthoek aangemaakt " + lijnStuk.toString());
        return lijnStuk;
    }

}
