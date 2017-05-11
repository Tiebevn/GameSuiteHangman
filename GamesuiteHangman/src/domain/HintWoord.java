package domain;

import java.util.ArrayList;

/**
 * Created by Tiebe on 9/05/2017.
 */
public class HintWoord {

    private String woord;
    private ArrayList<HintLetter> hint;

    public HintWoord(String woord) {
        this.setWoord(woord);
        this.createHint(woord);

    }

    private void createHint(String woord) {
        if (woord == null || woord.isEmpty()) throw new DomainException("");

        this.hint = new ArrayList<>();

        for (char c : woord.toCharArray()) {
            this.hint.add(new HintLetter(c));
        }
    }

    public boolean raad(char c) {
        boolean flag = false;
        for (HintLetter h : hint) {
            if (h.raad(c)) flag = true;
        }

        return flag;

    }

    public boolean isGeraden() {
        for (HintLetter h : hint) {
            if (!h.isGeraden()) return false;
        }
        return true;
    }

    public String getWoord() {
        return woord;
    }

    public void setWoord(String woord) {
        if (woord == null || woord.isEmpty()) throw new DomainException("");
        this.woord = woord;
    }

    @Override
    public String toString() {
        String result = "";

        for (HintLetter h : hint) {
            result += " " + h.toChar();
        }
        return result.trim();
    }
}