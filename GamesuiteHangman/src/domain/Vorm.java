package domain;

import java.awt.*;

/**
 * Created by tiebe on 9/05/2017.
 */
public abstract class Vorm implements Drawable{

    public abstract boolean equals(Object o);
    public abstract String toString();
    public abstract Omhullende getOmhullende();
    public abstract void teken(Graphics g);

}
