package docket.domain.exception;

public class CartorioExistenteException extends RuntimeException {
	private static final long serialVersionUID = 1253L;

	public CartorioExistenteException(String message) {
		super(message);
	}
}
