package domain;

/**
 * Created by tiebe on 11/05/2017.
 */
public class TekeningHangMan extends Tekening{



    public TekeningHangMan() {
        super("test");
        this.addVormen();
    }

    private void addVormen() {
        this.voegToe(new Rechthoek(new Punt(10, 350), 300, 40));// altijd zichtbaar
        this.voegToe(new LijnStuk(new Punt(160, 350), new Punt(160, 50)));// altijd zichtbaar
        this.voegToe(new LijnStuk(new Punt(160, 50), new Punt(280, 50)));// altijd zichtbaar
        this.voegToe(new LijnStuk(new Punt(280, 50), new Punt(280, 100)));// altijd zichtbaar
        this.voegToe(new Cirkel(new Punt(256, 101), 49));// zichtbaar na 1 fout
        this.voegToe(new Cirkel(new Punt(270, 118), 2));// zichtbaar na 2 fouten
        this.voegToe(new Cirkel(new Punt(290, 118), 2));//…
        this.voegToe(new Cirkel(new Punt(280, 128), 2));
        this.voegToe(new LijnStuk(new Punt(270, 138), new Punt(290, 138)));
        this.voegToe(new LijnStuk(new Punt(280, 150), new Punt(280, 250)));
        this.voegToe(new LijnStuk(new Punt(280, 250), new Punt(240, 310)));
        this.voegToe(new LijnStuk(new Punt(280, 250), new Punt(320, 310)));
        this.voegToe(new Cirkel(new Punt(240, 310), 5));
        this.voegToe(new Cirkel(new Punt(320, 310), 5));
        this.voegToe(new LijnStuk(new Punt(280, 200), new Punt(230, 170)));
        this.voegToe(new LijnStuk(new Punt(280, 200), new Punt(330, 170)));
        this.voegToe(new Cirkel(new Punt(230, 170), 5));
        this.voegToe(new Cirkel(new Punt(330, 170), 5));

        for (int i = 4; i < this.getAantalVormen(); i++) {
            this.getAllVormen().get(i).setOnZichtbaar();
        }


    }

    public boolean zetVolgendeZichtBaar() {
        for (Vorm v : this.getAllVormen()) {
            if (!v.zichtbaar) {
                v.zichtbaar = true;
                return true;
            }

        }
        return false;

    }

    public Tekening getTekening() {
        return this;
    }
}
