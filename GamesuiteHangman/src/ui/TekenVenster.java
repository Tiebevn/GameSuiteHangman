package ui;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import domain.Cirkel;
import domain.Driehoek;
import domain.LijnStuk;
import domain.Punt;
import domain.Rechthoek;
import domain.Tekening;
import domain.UiException;

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

    @Override
    public void paint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setStroke(new BasicStroke(5));

        Cirkel boomkruin = new Cirkel(new Punt(70, 70), 60);
        LijnStuk boomstam = new LijnStuk(new Punt(70, 130), new Punt(70, 380));
        Rechthoek gebouw = new Rechthoek(new Punt(100, 200), 200, 180);
        Driehoek dak = new Driehoek(new Punt(100, 200), new Punt(300, 200),
                new Punt(200, 100));

        graphics.drawOval(boomkruin.getOmhullende().getMIN_X(), boomkruin
                .getOmhullende().getMIN_X(), boomkruin.getOmhullende()
                .getBreedte(), boomkruin.getOmhullende().getHoogte());

        graphics.drawRect(gebouw.getLinkerBovenhoek().getX(), gebouw
                .getLinkerBovenhoek().getY(), gebouw.getBreedte(), gebouw
                .getHoogte());

        graphics.drawLine(boomstam.getStartPunt().getX(), boomstam
                .getStartPunt().getY(), boomstam.getEindPunt().getX(), boomstam
                .getEindPunt().getY());

        int[] xPoints = { dak.getHoekpunt1().getX(), dak.getHoekpunt2().getX(),
                dak.getHoekpunt3().getX() };
        int[] yPoints = { dak.getHoekpunt1().getY(), dak.getHoekpunt2().getY(),
                dak.getHoekpunt3().getY() };
        graphics.drawPolygon(xPoints, yPoints, 3);
    }
}