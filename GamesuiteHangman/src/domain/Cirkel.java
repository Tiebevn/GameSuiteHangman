package domain;

/**
 * Created by tiebe on 9/05/2017.
 */
public class Cirkel extends Vorm {
    private Punt middelPunt;
    private int radius;

    public Cirkel(Punt middelPunt, int radius) {
        this.setMiddelPunt(middelPunt);
        this.setRadius(radius);
    }

    public Punt getMiddelPunt() {
        return middelPunt;
    }

    public void setMiddelPunt(Punt middelPunt) {
        if (middelPunt == null) throw new DomainException("Middelpunt mag niet null zijn");

        this.middelPunt = middelPunt;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius <= 0) throw new DomainException("Radius moet groter zijn dan 0");

        this.radius = radius;
    }

    @Override
    public Omhullende getOmhullende() {
        int breedte = this.radius * 2, hoogte = this.radius * 2;
        Punt linkerBovenhoek = new Punt(0, 0);

        linkerBovenhoek.setX(this.getMiddelPunt().getX() - this.getRadius());
        linkerBovenhoek.setY(this.getMiddelPunt().getY() - this.getRadius());

        return new Omhullende(linkerBovenhoek, breedte, hoogte);
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
