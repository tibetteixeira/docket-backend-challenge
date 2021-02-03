package docket.domain.model;

public enum TipoDocumentoEnum {
	CERTIDAO_CASAMENTO("CERTIDAO_CASAMENTO"), CERTIDAO_OBITO("CERTIDAO_OBITO"),
	CERTIDAO_NASCIMENTO("CERTIDAO_NASCIMENTO");

	private final String tipo;

	TipoDocumentoEnum(String tipo) {
		this.tipo = tipo;
	}

	public boolean equals(TipoDocumentoEnum outroTipo) {
		if (this.tipo.equals(outroTipo.tipo))
			return true;

		return false;
	}

	public String toString() {
		return this.tipo;
	}
}
