package docket.domain.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "documento")
public class Documento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@Column(nullable = false, length = 50)
	private String nome;

	@Column(nullable = false)
	private String dataEmissao;

	@ManyToOne
	@JoinColumn(name = "tipo_documento", nullable = false)
	private TipoDocumento tipoDocumento;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "cnpj_cartorio", nullable = false)
	private Cartorio cartorio;

	public Documento() {
	}

	public Documento(Documento documento) {
		this.codigo = documento.codigo;
		this.nome = documento.nome;
		this.dataEmissao = documento.dataEmissao;
		this.cartorio = documento.cartorio;
		this.tipoDocumento = documento.tipoDocumento;
	}

	public Documento(String nome, String dataEmissao, TipoDocumento tipoDocumento, Cartorio cartorio) {
		this.nome = nome;
		this.dataEmissao = dataEmissao;
		this.tipoDocumento = tipoDocumento;
		this.cartorio = cartorio;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Cartorio getCartorio() {
		return cartorio;
	}

	public void setCartorio(Cartorio cartorio) {
		this.cartorio = cartorio;
	}
}