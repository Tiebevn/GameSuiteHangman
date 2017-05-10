package domain;

/**
 * Created by Tiebe on 10/05/2017.
 */
public class HangMan {


    private Speler speler;
    private WoordenLijst lijst;

    private boolean gewonnen, gameOver;

    public HangMan(Speler speler, WoordenLijst lijst) {
        this.setSpeler(speler);
        this.setLijst(lijst);
    }

    public Tekening getTekening() {
        return new Tekening("Test");
    }

    public String getHint() {
        return "";
    }

    public boolean raad(char c) {
        return false;
    }

    public boolean isGewonnen() {
        return gewonnen;
    }

    public void setGewonnen(boolean gewonnen) {
        this.gewonnen = gewonnen;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Speler getSpeler() {
        return speler;
    }

    public void setSpeler(Speler speler) {
        if (speler == null) throw new DomainException("");
        this.speler = speler;
    }

    public WoordenLijst getLijst() {
        return lijst;
    }

    public void setLijst(WoordenLijst lijst) {
        this.lijst = lijst;
    }
}
