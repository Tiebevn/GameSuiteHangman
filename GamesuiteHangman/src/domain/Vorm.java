package domain;

/**
 * Created by tiebe on 9/05/2017.
 */
public abstract class Vorm {

    public abstract boolean equals(Object o);
    public abstract String toString();
    public abstract Omhullende getOmhullende();
    public boolean zichtbaar = true;

    public void setZichtbaar() {
        this.zichtbaar = true;
    }

    public void setOnZichtbaar() {
        this.zichtbaar = false;
    }

}
