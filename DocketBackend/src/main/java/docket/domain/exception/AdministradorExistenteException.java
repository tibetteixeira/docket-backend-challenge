package docket.domain.exception;

public class AdministradorExistenteException extends RuntimeException {
	private static final long serialVersionUID = 1251L;

	public AdministradorExistenteException(String message) {
		super(message);
	}
}
