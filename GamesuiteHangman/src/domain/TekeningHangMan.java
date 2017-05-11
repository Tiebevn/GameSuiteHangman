package domain;

/**
 * Created by tiebe on 11/05/2017.
 */
public class TekeningHangMan {

    public Tekening galg;

    public TekeningHangMan() {
        this.galg = new Tekening("Galg");
        this.addVormen();
    }

    private void addVormen() {
        galg.voegToe(new Rechthoek(new Punt(10, 350), 300, 40));// altijd zichtbaar
        galg.voegToe(new LijnStuk(new Punt(160, 350), new Punt(160, 50)));// altijd zichtbaar
        galg.voegToe(new LijnStuk(new Punt(160, 50), new Punt(280, 50)));// altijd zichtbaar
        galg.voegToe(new LijnStuk(new Punt(280, 50), new Punt(280, 100)));// altijd zichtbaar
        galg.voegToe(new Cirkel(new Punt(280, 125), 25));// zichtbaar na 1 fout
        galg.voegToe(new Cirkel(new Punt(270, 118), 2));// zichtbaar na 2 fouten
        galg.voegToe(new Cirkel(new Punt(290, 118), 2));//…
        galg.voegToe(new Cirkel(new Punt(280, 128), 2));
        galg.voegToe(new LijnStuk(new Punt(270, 138), new Punt(290, 138)));
        galg.voegToe(new LijnStuk(new Punt(280, 150), new Punt(280, 250)));
        galg.voegToe(new LijnStuk(new Punt(280, 250), new Punt(240, 310)));
        galg.voegToe(new LijnStuk(new Punt(280, 250), new Punt(320, 310)));
        galg.voegToe(new Cirkel(new Punt(240, 310), 5));
        galg.voegToe(new Cirkel(new Punt(320, 310), 5));
        galg.voegToe(new LijnStuk(new Punt(280, 200), new Punt(230, 170)));
        galg.voegToe(new LijnStuk(new Punt(280, 200), new Punt(330, 170)));
        galg.voegToe(new Cirkel(new Punt(230, 170), 5));
        galg.voegToe(new Cirkel(new Punt(330, 170), 5));

        for (int i = 4; i < galg.getAantalVormen(); i++) {
            galg.getAllVormen().get(i).setOnZichtbaar();
        }
    }

    public boolean zetVolgendeZichtBaar() {
        for (Vorm v : galg.getAllVormen()) {
            if (!v.zichtbaar) {
                v.zichtbaar = true;
                return true;
            }

        }
            return false;

    }

    public Tekening getTekening() {
        return galg;
    }
}
