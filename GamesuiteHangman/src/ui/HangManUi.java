package ui;

import domain.HintWoord;

import javax.swing.*;

/**
 * Created by Tiebe on 9/05/2017.
 */
public class HangManUi {

    public static void main(String[] args) {

        HintWoord woord = new HintWoord("Woord");

        String text = "";

        text = "Rarara, welk woord zoeken we \n" + woord.getWoord();

        while (!woord.isGeraden()) {
            String guess = JOptionPane.showInputDialog(null, text);

            if (woord.raad(guess.toCharArray()[0])) {
                text = "Super, doe zo voort! \n" + "Rarara, welk woord zoeken we \n" + woord.getWoord();
            } else text = "Helaas, volgende keer beter! \n" + "Rarara, welk woord zoeken we \n" + woord.getWoord();


            woord.raad(guess.toCharArray()[0]);

        }


    }
}
