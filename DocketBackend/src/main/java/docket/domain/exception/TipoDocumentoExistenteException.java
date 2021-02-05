package docket.domain.exception;

public class TipoDocumentoExistenteException extends RuntimeException{
	private static final long serialVersionUID = 1953L;
	
	public TipoDocumentoExistenteException(String messagem) {
		super(messagem);
	}
}
