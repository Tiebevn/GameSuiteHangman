package domain;

import domain.shapes.Vorm;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Tiebe on 8/05/2017.
 */
public class Tekening {

    private static final int MIN_X = 0;
    private static final int MIN_Y = 0;
    private static final int MAX_X = 399;
    private static final int MAX_Y = 399;
    private String naam;
    private ArrayList<Vorm> vormen;

    public Tekening(String naam) {
        this.vormen = new ArrayList<>();

        this.setNaam(naam);
    }

    public ArrayList<Vorm> getAllVormen() {
        return vormen;
    }


    public void teken(Graphics g) {
        for (Vorm v : vormen) {
            v.teken(g);
        }
    }

    public void setOnzichtbaar(Vorm v) {
        v.zichtbaar = false;
    }

    public int getAantalOnzichtbaar() {
        int teller = 0;

        for (Vorm v : vormen) {
            if (!v.zichtbaar) teller++;
        }

        return teller;
    }


    private boolean isInBounds(Vorm v) {
        return v.getOmhullende().getMIN_X() >= Tekening.MIN_X || v.getOmhullende().getMIN_Y() >= Tekening.MIN_Y || v.getOmhullende().getMAX_X() <= Tekening.MAX_X || v.getOmhullende().getMAX_Y() <= Tekening.MAX_Y;
    }

    public void voegToe(Vorm vorm) {

        if (isInBounds(vorm)) this.vormen.add(vorm);

    }

    public int getAantalVormen() {
        return this.vormen.size();
    }

    public void verwijder(Vorm vorm) {
        this.vormen.remove(vorm);
    }

    public boolean bevat(Vorm vorm) {
        return this.vormen.contains(vorm);
    }


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (naam == null || naam.trim().equals("")) throw new IllegalArgumentException("");

        this.naam = naam;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;

        if (o instanceof Tekening) {
            Tekening tekening = (Tekening) o;

            if (tekening.getAantalVormen() != this.getAantalVormen()) return false;

            for (Vorm v : this.vormen) {
                if (!tekening.bevat(v)) return false;
            }

            return true;

        }
        return false;
    }

    @Override
    public String toString() {
        String result = "";

        result = result + " Tekening met naam " + this.getNaam() + " bestaat uit " + this.getAantalVormen() + " vomren: \n";

        for (Vorm v : this.vormen) {
            result = result + v.toString();
        }
        return result;
    }


}
