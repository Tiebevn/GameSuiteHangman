package domain;

/**
 * Created by Tiebe on 10/05/2017.
 */
public class HangMan {


    private Speler speler;
    private WoordenLijst lijst;
    private HintWoord woord;
    private TekeningHangMan galg;

    private boolean gewonnen = false, gameOver = false;

    public HangMan(Speler speler, WoordenLijst lijst) {
        this.setSpeler(speler);
        this.setLijst(lijst);
        this.pickWord();
        this.galg = new TekeningHangMan();

    }

    public TekeningHangMan getGalg() {
        return galg;
    }

    private void setGalg(TekeningHangMan galg) {
        this.galg = galg;
    }

    private void pickWord() {
        woord = new HintWoord(lijst.getRandom());
    }

    public Tekening getTekening() {
        return this.galg.getTekening();
    }

    public String getHint() {
        return this.woord.toString();
    }

    public boolean raad(char c) {

        if (!woord.raad(c)) {
            if (galg.zetVolgendeZichtBaar()) {

                if (galg.getTekening().getAantalOnzichtbaar() == 0) {
                    this.gameOver = true;
                }

                return false;
            }

        }
        if (this.woord.isGeraden()) this.gewonnen = true;

        return true;
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

        if (lijst == null || lijst.getAantalWoorden() == 0) throw new DomainException("");

        this.lijst = lijst;
    }
}
