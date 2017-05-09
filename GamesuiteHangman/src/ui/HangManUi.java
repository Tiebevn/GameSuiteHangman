package ui;

import domain.HintWoord;

import javax.swing.*;

/**
 * Created by Tiebe on 9/05/2017.
 */
public class HangManUi {

    public static void main(String[] args) {

        HintWoord woord = new HintWoord("Woord");

        while (!woord.isGeraden()) {

            String  guess = JOptionPane.showInputDialog(null, woord.getWoord());

            woord.raad(guess.toCharArray()[0]);

        }


    }
}
