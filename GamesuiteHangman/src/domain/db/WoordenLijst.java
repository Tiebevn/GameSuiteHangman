package domain.db;

import domain.exceptions.DomainException;

import java.io.IOException;
import java.util.List;

/**
 * Created by tiebe on 10/05/2017.
 */
public class WoordenLijst {

    private  List<String> lijst;



    public  void importWords() {
        try {
            lijst =WoordenLezer.lees();
        } catch (IOException e) {

        }
    }

    public  List<String> get() {
        return lijst;
    }

    public  void voegToe(String woord) {
        if (woord == null || woord.isEmpty()) throw new DomainException("");
        lijst.add(woord);
    }

    public  String getRandom() {

        return lijst.get((int) (Math.random() * lijst.size()));
    }

    public int getAantalWoorden() {
        return this.lijst.size();
    }

}
