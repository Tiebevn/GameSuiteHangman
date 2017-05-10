package domain;

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

    public Punt getHoekPunt1() {
        return hoekpunt1;
    }

    public void setHoekPunt1(Punt hoekpunt1) {
        if(hoekpunt1 == null) throw new DomainException("hoekpunt mag niet null zijn");
        this.hoekpunt1 = hoekpunt1;
    }

    public Punt getHoekPunt2() {
        return hoekpunt2;
    }

    public void setHoekPunt2(Punt hoekpunt2) {
        if(hoekpunt2 == null) throw new DomainException("hoekpunt mag niet null zijn");
        this.hoekpunt2 = hoekpunt2;
    }

    public Punt getHoekPunt3() {
        return hoekpunt3;
    }

    public void setHoekPunt3(Punt hoekpunt3) {
        if(hoekpunt3 == null) throw new DomainException("hoekpunt mag niet null zijn");
        this.hoekpunt3 = hoekpunt3;
    }

    public Omhullende getOmhullende() {
        int breedte = 0, hoogte = 0;
        Punt linkerBovenhoek = new Punt(0, 0);

        breedte = Math.max(this.getHoekPunt1().getX(), Math.min(this.getHoekPunt2().getX(), this.getHoekPunt3().getX()));
        hoogte = Math.max(this.getHoekPunt1().getY(), Math.min(this.getHoekPunt2().getY(), this.getHoekPunt3().getY()));

        linkerBovenhoek.setX(Math.min(this.getHoekPunt1().getX(), Math.min(this.getHoekPunt2().getX(), this.getHoekPunt3().getX())));
        linkerBovenhoek.setX(Math.max(this.getHoekPunt1().getY(), Math.min(this.getHoekPunt2().getY(), this.getHoekPunt3().getY())));

        return new Omhullende(linkerBovenhoek, breedte, hoogte);
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(o instanceof Driehoek){
            Driehoek driehoek = (Driehoek)o;
            return (this.getHoekPunt1().equals(driehoek.getHoekPunt1()) && this.getHoekPunt2().equals(driehoek.getHoekPunt2()) && this.getHoekPunt3().equals(driehoek.getHoekPunt3()));
        }
        return false;
    }

    @Override
    public String toString() {
        return "Driehoek: hoekpunt1: " + this.getHoekPunt1().toString() + " - hoekpunt2: " + this.getHoekPunt2().toString() + " - hoekpunt3: " + this.getHoekPunt3().toString();
    }
}
