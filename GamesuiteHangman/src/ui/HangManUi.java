package ui;

import domain.model.HintWoord;
import domain.db.WoordenLijst;

import javax.swing.*;

/**
 * Created by Tiebe on 9/05/2017.
 */
public class HangManUi {

    public static void main(String[] args) {

        WoordenLijst.importWords();

        HintWoord woord = new HintWoord(WoordenLijst.getRandom());


        String text = "";

        text = "Rarara, welk woord zoeken we \n" + woord.getWoord();

        while (!woord.isGeraden()) {
            String guess = JOptionPane.showInputDialog(null, text);

            if (guess.length() == 1) {
                if (woord.raad(guess.toCharArray()[0])) {
                    text = "Super, doe zo voort! \n" + "Rarara, welk woord zoeken we \n" + woord.getWoord();
                } else text = "Helaas, volgende keer beter! \n" + "Rarara, welk woord zoeken we \n" + woord.getWoord();

            } else {
                if (guess.equals(woord.getOplossing())) woord.solved();
            }

            woord.raad(guess.toCharArray()[0]);

        }

        JOptionPane.showMessageDialog(null, "Proficiat, het woord was " + woord.getOplossing());


    }
}
