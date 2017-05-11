package ui;

import domain.Tekening;
import domain.UiException;

import java.awt.*;

public class TekenVenster extends Canvas {

    private static final long serialVersionUID = 1L;
    private Tekening tekening = null;


    public TekenVenster(Tekening tekening) {
        this.setPreferredSize(new Dimension(400, 400));
        setTekening(tekening);
    }

    private void setTekening(Tekening tekening) {
        if (tekening == null)
            throw new UiException("Tekening mag niet null zijn");
        this.tekening = tekening;
    }

    public void teken() {
        repaint();
    }

    public void reset(Tekening tekening) {
        setTekening(tekening);
        teken();
    }


    @Override
    public void paint(Graphics graphics) {

        Graphics2D g = (Graphics2D) graphics;
        g.setStroke(new BasicStroke(5));

        tekening.teken(graphics);
    }


}