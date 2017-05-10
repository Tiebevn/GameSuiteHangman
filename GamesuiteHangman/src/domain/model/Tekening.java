package domain.model;

import domain.exceptions.DomainException;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Tiebe on 8/05/2017.
 */
public class Tekening implements Drawable{

    private String naam;
    private static final int MinX = 0;
    private static final int MinY = 0;
    private static final int MaxX = 399;
    private static final int MaxY = 399;
    private ArrayList<Vorm> vormen;

    public Tekening(String naam) {
        this.vormen = new ArrayList<>();

        this.setNaam(naam);
    }

    public void teken(Graphics g) {

        for (Vorm v : vormen) {
            v.teken(g);
        }

    }

    private boolean isInFigure(Vorm v) {
        return v.getOmhullende().getMinX() >= this.MinX || v.getOmhullende().getMinY() >= this.MinY || v.getOmhullende().getMaxX() <= this.MaxX || v.getOmhullende().getMaxY() <= this.MaxY;
    }

    public void voegToe(Vorm vorm) {
        if (isInFigure(vorm)) {

            this.vormen.add(vorm);
        } else {
            throw new DomainException("Deze figuur is niet in de vorm");
        }
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
            Tekening tekening = (Tekening)o;

            if (tekening.getAantalVormen() != this.getAantalVormen()) return false;

            for (Vorm v : this.vormen) {
                if (!tekening.bevat(v)) return false;
            }

            return true;

        } return false;
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
