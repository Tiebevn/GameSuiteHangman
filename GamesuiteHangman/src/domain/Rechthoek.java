package domain;

/**
 * Created by tiebe on 9/05/2017.
 */
public class Rechthoek extends Vorm{


    private Punt linkerBovenhoek;
    private int breedte, hoogte;

    public Rechthoek(Punt linkerBovenhoek, int breedte, int hoogte) {
        this.setBreedte(breedte);
        this.setHoogte(hoogte);
        this.setLinkerBovenhoek(linkerBovenhoek);
    }

    public Punt getLinkerBovenhoek() {
        return linkerBovenhoek;
    }

    public void setLinkerBovenhoek(Punt linkerBovenhoek) {
        if (linkerBovenhoek == null) throw new DomainException("Punt mag niet null zijn");
        this.linkerBovenhoek = linkerBovenhoek;
    }

    public int getBreedte() {
        return breedte;
    }

    public void setBreedte(int breedte) {
        if (breedte <= 0) throw new DomainException("Breedte mag niet kleiner dan of gelijk aan 0 zijn");
        this.breedte = breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public void setHoogte(int hoogte) {
        if (hoogte <= 0) throw new DomainException("Hoogte mag niet kleiner dan of gelijk aan 0 zijn");
        this.hoogte = hoogte;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null) return false;
        if (o instanceof Rechthoek) {

            Rechthoek rechthoek = (Rechthoek)o;

            return  (rechthoek.getLinkerBovenhoek().equals(this.getLinkerBovenhoek()) && rechthoek.getBreedte() == this.getBreedte() && rechthoek.getHoogte() == this.getHoogte());

        }

        return false;
    }

    public Omhullende getOmhullende() {
        return new Omhullende(this.linkerBovenhoek, this.breedte, this.hoogte);
    }

    @Override
    public String toString() {
    return "Rechthoek: positie: " + this.getLinkerBovenhoek().toString() + " - breedte: " + this.getBreedte() + " - hoogte: " + this.getHoogte();
    }
}
