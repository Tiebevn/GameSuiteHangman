package domain;

/**
 * Created by Tiebe on 9/05/2017.
 */
public class HintLetter {

    private char letter;
    private boolean geraden;

    public HintLetter(char letter) {
        this.letter = letter;
        this.geraden = false;
    }

    public boolean raad(char c) {


        if (c == this.letter ||Character.toUpperCase(c) == this.letter || Character.toLowerCase(c) == this.letter) {

            if (this.isGeraden()) return false;

            this.geraden = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean isGeraden() {
        return this.geraden;
    }
    public char getLetter() {
        return this.letter;
    }

    public char toChar() {


        if (isGeraden()) return this.letter;
        return '_';
    }
}