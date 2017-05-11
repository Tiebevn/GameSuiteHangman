package domain;

import db.WoordenLezer;
import domain.exceptions.DomainException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiebe on 10/05/2017.
 */
public class WoordenLijst {

    private ArrayList<String> lijst;


    public WoordenLijst() {
        this.lijst = new ArrayList<>();
    }


    public void importWords() {
        try {
            lijst = WoordenLezer.lees();
        } catch (IOException e) {

        }
    }

    public int getAantalWoorden() {
        return this.lijst.size();
    }

    public List<String> get() {
        return lijst;
    }

    public void voegToe(String woord) {
        if (woord == null || woord.isEmpty() || this.lijst.contains(woord)) throw new DomainException("");
        lijst.add(woord);
    }

    public String getRandom() {

        return lijst.get((int) (Math.random() * lijst.size()));
    }

}