package domain;


/**
 * Created by tiebe on 9/05/2017.
 */
public class DomainException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DomainException(String message) {
        super(message);
    }
}
