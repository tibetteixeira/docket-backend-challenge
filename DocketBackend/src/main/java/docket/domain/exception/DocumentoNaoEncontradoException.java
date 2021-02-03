package docket.domain.exception;

public class DocumentoNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1244L;

	public DocumentoNaoEncontradoException(String message) {
		super(message);
	}
}
