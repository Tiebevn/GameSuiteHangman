package domain;

/**
 * Created by tiebe on 9/05/2017.
 */
public class LijnStuk extends Vorm {

    private Punt startPunt, eindPunt;

    public LijnStuk(Punt startPunt, Punt eindPunt) {
        this.setEindPunt(eindPunt);
        this.setStartPunt(startPunt);
    }

    public Omhullende getOmhullende() {
        int breedte = 0, hoogte = 0;
        Punt linkerBovenhoek = new Punt(0, 0);

        breedte = Math.max(this.getStartPunt().getX(), this.getEindPunt().getX());
        hoogte = Math.max(this.getStartPunt().getY(), this.getEindPunt().getY());

        linkerBovenhoek.setX(Math.min(this.getStartPunt().getX(), this.getEindPunt().getX()));
        linkerBovenhoek.setY(Math.max(this.getStartPunt().getY(), this.getEindPunt().getY()));

        return new Omhullende(linkerBovenhoek, breedte, hoogte);
    }

    public Punt getStartPunt() {
        return startPunt;
    }

    public void setStartPunt(Punt startPunt) {
        if (startPunt == null) throw new DomainException("startpunt mag niet null zijn");
        this.startPunt = startPunt;
    }

    public Punt getEindPunt() {
        return eindPunt;
    }

    public void setEindPunt(Punt eindPunt) {
        if (eindPunt == null) throw new DomainException("eindpunt mag niet null zijn");
        this.eindPunt = eindPunt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o instanceof LijnStuk) {
            LijnStuk lijnstuk = (LijnStuk) o;
            return (lijnstuk.getStartPunt().equals(this.getStartPunt()) && lijnstuk.getEindPunt().equals(this.getEindPunt()));
        }
        return false;
    }

    @Override
    public String toString() {
        return "Lijn: startpunt: " + this.getStartPunt().toString() + " - eindpunt: " + this.getEindPunt().toString();
    }
}
