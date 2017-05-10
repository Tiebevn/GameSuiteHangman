package domain;

import domain.DomainException;

import java.io.IOException;
import java.util.List;

/**
 * Created by tiebe on 10/05/2017.
 */
public class WoordenLijst {

    private static List<String> lijst;



    public static void importWords() {
        try {
            lijst =WoordenLezer.lees();
        } catch (IOException e) {

        }
    }

    public static List<String> get() {
        return lijst;
    }

    public static void voegToe(String woord) {
        if (woord == null || woord.isEmpty()) throw new DomainException("");
        lijst.add(woord);
    }

    public static String getRandom() {

        return lijst.get((int) (Math.random() * lijst.size()));
    }

}