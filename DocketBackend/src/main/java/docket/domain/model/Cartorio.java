package docket.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cartorio")
public class Cartorio {

	@Id
	@Column(nullable = false, length = 20, unique = true)
	private String cnpj;

	@Column(nullable = false, length = 50, unique = true)
	private String nome;

	@Column(nullable = false, length = 50)
	private String rua;

	@Column(nullable = false, length = 10)
	private String cep;

	@Column(nullable = false, length = 10)
	private String numero;

	@Column(nullable = false, length = 50)
	private String cidade;

	@Column(nullable = false, length = 25)
	private String estado;

	@ManyToMany
	@JoinTable(name = "documentos_emitidos", 
				joinColumns = @JoinColumn(name = "cartorio_cnpj"), 
				inverseJoinColumns = @JoinColumn(name = "tipo_documento_id"))
	private List<TipoDocumento> documentosEmitidos;

	public Cartorio() {
	}

	public Cartorio(String cnpj, String nome, String rua, String cep, String numero, String cidade, String estado,
			List<TipoDocumento> documentosEmitidos) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.rua = rua;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.documentosEmitidos = documentosEmitidos;
	}

	public Cartorio(Cartorio cartorio) {
		this.cnpj = cartorio.cnpj;
		this.nome = cartorio.nome;
		this.rua = cartorio.rua;
		this.cep = cartorio.cep;
		this.numero = cartorio.numero;
		this.cidade = cartorio.cidade;
		this.estado = cartorio.estado;
		this.documentosEmitidos = cartorio.documentosEmitidos;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<TipoDocumento> getDocumentosEmitidos() {
		return documentosEmitidos;
	}

	public void setDocumentosEmitidos(List<TipoDocumento> documentosEmitidos) {
		this.documentosEmitidos = documentosEmitidos;
	}
}
