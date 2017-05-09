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

    public Punt getStartPunt() {
        return startPunt;
    }

    public void setStartPunt(Punt startPunt) {
        this.startPunt = startPunt;
    }

    public Punt getEindPunt() {
        return eindPunt;
    }

    public void setEindPunt(Punt eindPunt) {
        this.eindPunt = eindPunt;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public String toString() {
        return "";
    }
}
