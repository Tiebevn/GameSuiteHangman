package domain.model;

import domain.db.WoordenLijst;

/**
 * Created by Tiebe on 10/05/2017.
 */
public class HangMan {

    private Speler speler;
    private WoordenLijst woordenLijst;
    private boolean gameOver, gewonnen;
    private HintWoord woord;

    public HangMan(Speler speler, WoordenLijst lijst) {

        setSpeler(speler);
        setWoordenLijst(lijst);

    }

    public String getHint() {
        return this.woord.getWoord();
    }
    public Tekening getTekening() {
        return new Tekening("Tekening");
    }

    public boolean raad(char c) {
        return woord.raad(c);
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isGewonnen() {
        return gewonnen;
    }

    public void setGewonnen(boolean gewonnen) {
        this.gewonnen = gewonnen;
    }

    public Speler getSpeler() {
        return speler;
    }

    public void setSpeler(Speler speler) {
        this.speler = speler;
    }

    public WoordenLijst getWoordenLijst() {
        return woordenLijst;
    }

    public void setWoordenLijst(WoordenLijst woordenLijst) {
        this.woordenLijst = woordenLijst;
    }
}
