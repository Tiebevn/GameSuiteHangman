package domain;

/**
 * Created by tiebe on 9/05/2017.
 */
public class Cirkel extends Vorm {
    private Punt middelPunt;
    private int radius;

    public Cirkel(Punt punt, int radius) {
        this.setMiddelPunt(punt);
        this.setRadius(radius);
    }

    public Punt getMiddelPunt() {
        return middelPunt;
    }

    public void setMiddelPunt(Punt middelPunt) {
        if (middelPunt == null) throw new DomainException("Middelpunt mag niet null zijn")

        this.middelPunt = middelPunt;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius < 0) throw new DomainException("Radius mag niet kleiner dan 0 zijn");

        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;

        if (o instanceof Cirkel) {

            Cirkel cirkel = (Cirkel)o;

            return  (cirkel.getMiddelPunt().equals(this.getMiddelPunt()) && cirkel.getRadius() == this.getRadius());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cirkel: middelpunt: " + this.getMiddelPunt().toString() + " - straal: " + this.getRadius();
    }
}
