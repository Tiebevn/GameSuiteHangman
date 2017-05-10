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
        if (c == this.letter) {
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
        if (isGeraden()) return this.letter;
        return '_';
    }

    public char toChar() {
        return this.letter;
    }
}