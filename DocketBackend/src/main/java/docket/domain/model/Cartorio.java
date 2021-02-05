package docket.domain.model;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

//	@JsonIgnoreProperties("cartorio")
//	@OneToMany(targetEntity = Documento.class, mappedBy = "cartorio", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Documento> documentos = new ArrayList<>();

//	@Column(name = "rua", nullable = false, length = 20)
//	private List<TipoDocumentoEnum> documentosEmitidos;

	public Cartorio() {
	}

	public Cartorio(String cnpj, String nome, String rua, String cep, String numero, String cidade, String estado) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.rua = rua;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Cartorio(Cartorio cartorio) {
		this.cnpj = cartorio.cnpj;
		this.nome = cartorio.nome;
		this.rua = cartorio.rua;
		this.cep = cartorio.cep;
		this.numero = cartorio.numero;
		this.cidade = cartorio.cidade;
		this.estado = cartorio.estado;
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

}
