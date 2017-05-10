package ui;

import domain.db.WoordenLijst;

/**
 * Created by tiebe on 10/05/2017.
 */
public class TestUi {

    public static void main(String[] args) {



        WoordenLijst.importWords();
        WoordenLijst.voegToe("Andere");
        System.out.print(WoordenLijst.getRandom());
    }

}
