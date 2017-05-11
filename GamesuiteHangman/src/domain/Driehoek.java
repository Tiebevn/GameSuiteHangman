package domain;

import java.awt.*;

/**
 * Created by tiebe on 9/05/2017.
 */
public class Driehoek extends Vorm {
    private Punt hoekpunt1, hoekpunt2, hoekpunt3;

    public Driehoek(Punt hoekpunt1, Punt hoekpunt2, Punt hoekpunt3) {
        this.setHoekPunt1(hoekpunt1);
        this.setHoekPunt2(hoekpunt2);
        this.setHoekPunt3(hoekpunt3);
    }

    public void teken(Graphics g) {
        if (this.zichtbaar) {
            g.drawLine(hoekpunt1.getX(), hoekpunt1.getY(), hoekpunt2.getX(), hoekpunt2.getY());
            g.drawLine(hoekpunt1.getX(), hoekpunt1.getY(), hoekpunt3.getX(), hoekpunt3.getY());
            g.drawLine(hoekpunt3.getX(), hoekpunt3.getY(), hoekpunt2.getX(), hoekpunt2.getY());
        }
    }

    public Punt getHoekpunt1() {
        return hoekpunt1;
    }

    public void setHoekPunt1(Punt hoekpunt1) {
        if (hoekpunt1 == null) throw new DomainException("hoekpunt mag niet null zijn");
        this.hoekpunt1 = hoekpunt1;
    }

    public Punt getHoekpunt2() {
        return hoekpunt2;
    }

    public void setHoekPunt2(Punt hoekpunt2) {
        if (hoekpunt2 == null) throw new DomainException("hoekpunt mag niet null zijn");
        this.hoekpunt2 = hoekpunt2;
    }

    public Punt getHoekpunt3() {
        return hoekpunt3;
    }

    public void setHoekPunt3(Punt hoekpunt3) {
        if (hoekpunt3 == null) throw new DomainException("hoekpunt mag niet null zijn");
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
        if (o == null) return false;
        if (o instanceof Driehoek) {
            Driehoek driehoek = (Driehoek) o;
            return (this.getHoekpunt1().equals(driehoek.getHoekpunt1()) && this.getHoekpunt2().equals(driehoek.getHoekpunt2()) && this.getHoekpunt3().equals(driehoek.getHoekpunt3()));
        }
        return false;
    }

    @Override
    public String toString() {
        return "Driehoek: hoekpunt1: " + this.getHoekpunt1().toString() + " - hoekpunt2: " + this.getHoekpunt2().toString() + " - hoekpunt3: " + this.getHoekpunt3().toString();
    }
}
