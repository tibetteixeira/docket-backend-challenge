package docket.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administrador")
public class Administrador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "usuario", nullable = false, length = 16, unique = true)
	private String usuario;

	@Column(name = "nome", nullable = false, length = 30)
	private String nome;

	@Column(name = "senha", nullable = false, length = 16)
	private String senha;

	public Administrador() {

	}

	public Administrador(String usuario, String nome, String senha) {
		this.usuario = usuario;
		this.nome = nome;
		this.senha = senha;
	}

	public Administrador(Administrador administrador) {
		this.usuario = administrador.usuario;
		this.nome = administrador.nome;
		this.senha = administrador.senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
