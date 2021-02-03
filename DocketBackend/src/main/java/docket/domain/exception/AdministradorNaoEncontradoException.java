package docket.domain.exception;

public class AdministradorNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1245L;

	public AdministradorNaoEncontradoException(String message) {
		super(message);
	}
}
