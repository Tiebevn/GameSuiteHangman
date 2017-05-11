package domain.shapes;

import java.awt.*;

/**
 * Created by tiebe on 9/05/2017.
 */
public abstract class Vorm {

    public boolean zichtbaar = true;

    public abstract boolean equals(Object o);

    public abstract String toString();

    public abstract void teken(Graphics g);


    public abstract Omhullende getOmhullende();

    public void setZichtbaar() {
        this.zichtbaar = true;
    }

    public void setOnZichtbaar() {
        this.zichtbaar = false;
    }

}
