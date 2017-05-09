package domain;

import java.util.ArrayList;

/**
 * Created by Tiebe on 9/05/2017.
 */
public class HintWoord {

    private ArrayList<HintLetter> hintLetters;

    public HintWoord(String woord) {
        hintLetters = new ArrayList<>();
        this.create(woord);
    }

    private void create(String woord) {
        char[] chars = woord.toCharArray();

        for (char c : chars) {
            hintLetters.add(new HintLetter(c));
        }
    }

    public boolean raad(char c) {


        boolean flag = false;
        for (HintLetter h : hintLetters) {
            h.raad(c);
            if (h.raad(c)) flag = true;
        }

        return flag;
    }

    public boolean isGeraden() {


        for (HintLetter h : hintLetters) {
            if (!(h.isGeraden())) return false;
        }
        return true;
    }

    public String getWoord() {
        String result = "";

        for (HintLetter h : hintLetters) {
                result = result + " " + h.getLetter() + " ";
        }

        return result;
    }



}
