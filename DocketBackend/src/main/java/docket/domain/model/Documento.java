package docket.domain.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	private Integer id;
	
	@Column(name = "nome", nullable = false, length = 50, unique = true)
	private String nome;
	
	@Column(name = "data_emissao", nullable = false)
	private String dataEmissao;
	
	@Column(name = "tipo_documento", nullable = false)
	private Integer tipo;
	
	@ManyToOne
	@JoinColumn(name = "cnpj")
	private Cartorio cartorio;

	public Documento(String nome, String dataEmissao, Cartorio cartorio, Integer tipo) {
		this.nome = nome;
		this.dataEmissao = dataEmissao;
		this.cartorio = cartorio;
		this.tipo = tipo;
	}
}

