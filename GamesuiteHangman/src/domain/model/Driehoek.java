package domain.model;

import domain.exceptions.DomainException;

import java.awt.*;

/**
 * Created by tiebe on 9/05/2017.
 */
public class Driehoek extends Vorm {
    private Punt hoekpunt1, hoekpunt2, hoekpunt3;

    public Driehoek(Punt hoekpunt1, Punt hoekpunt2, Punt hoekpunt3) {
        this.setHoekpunt1(hoekpunt1);
        this.setHoekpunt2(hoekpunt2);
        this.setHoekpunt3(hoekpunt3);
    }

    public void teken(Graphics g) {
        g.drawLine(getHoekpunt1().getX(), getHoekpunt1().getY(), getHoekpunt2().getX(), getHoekpunt2().getY());
        g.drawLine(getHoekpunt2().getX(), getHoekpunt2().getY(), getHoekpunt3().getX(), getHoekpunt3().getY());
        g.drawLine(getHoekpunt3().getX(), getHoekpunt3().getY(), getHoekpunt1().getX(), getHoekpunt1().getX());
    }

    public Punt getHoekpunt1() {
        return hoekpunt1;
    }

    public void setHoekpunt1(Punt hoekpunt1) {
        if(hoekpunt1 == null) throw new DomainException("hoekpunt mag niet null zijn");
        this.hoekpunt1 = hoekpunt1;
    }

    public Punt getHoekpunt2() {
        return hoekpunt2;
    }

    public void setHoekpunt2(Punt hoekpunt2) {
        if(hoekpunt2 == null) throw new DomainException("hoekpunt mag niet null zijn");
        this.hoekpunt2 = hoekpunt2;
    }

    public Punt getHoekpunt3() {
        return hoekpunt3;
    }

    public void setHoekpunt3(Punt hoekpunt3) {
        if(hoekpunt3 == null) throw new DomainException("hoekpunt mag niet null zijn");
        this.hoekpunt3 = hoekpunt3;
    }

    public Omhullende getOmhullende() {
        int breedte = 0, hoogte = 0;
        Punt linkerBovenhoek = new Punt(0, 0);

        breedte = Math.max(this.getHoekpunt1().getX(), Math.min(this.getHoekpunt2().getX(), this.getHoekpunt3().getX()));
        hoogte = Math.max(this.getHoekpunt1().getY(), Math.min(this.getHoekpunt2().getY(), this.getHoekpunt3().getY()));

        linkerBovenhoek.setX(Math.min(this.getHoekpunt1().getX(), Math.min(this.getHoekpunt2().getX(), this.getHoekpunt3().getX())));
        linkerBovenhoek.setX(Math.max(this.getHoekpunt1().getY(), Math.min(this.getHoekpunt2().getY(), this.getHoekpunt3().getY())));

        return new Omhullende(linkerBovenhoek, breedte, hoogte);
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(o instanceof Driehoek){
            Driehoek driehoek = (Driehoek)o;
            return (this.getHoekpunt1().equals(driehoek.getHoekpunt1()) && this.getHoekpunt2().equals(driehoek.getHoekpunt2()) && this.getHoekpunt3().equals(driehoek.getHoekpunt3()));
        }
        return false;
    }

    @Override
    public String toString() {
        return "Driehoek: hoekpunt1: " + this.getHoekpunt1().toString() + " - hoekpunt2: " + this.getHoekpunt2().toString() + " - hoekpunt3: " + this.getHoekpunt3().toString();
    }
}
