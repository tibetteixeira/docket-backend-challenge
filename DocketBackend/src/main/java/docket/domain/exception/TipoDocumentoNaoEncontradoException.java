package docket.domain.exception;

public class TipoDocumentoNaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 1853L;
	
	public TipoDocumentoNaoEncontradoException(String messagem) {
		super(messagem);
	}
}
