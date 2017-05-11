package domain;

/**
 * Created by tiebe on 11/05/2017.
 */
public class UiException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UiException(String message) {
        super(message);
    }
}
