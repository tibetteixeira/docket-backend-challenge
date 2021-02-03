package docket.domain.exception;

public class DocumentoExistenteException extends RuntimeException {
	private static final long serialVersionUID = 1252L;

	public DocumentoExistenteException(String message) {
		super(message);
	}
}
