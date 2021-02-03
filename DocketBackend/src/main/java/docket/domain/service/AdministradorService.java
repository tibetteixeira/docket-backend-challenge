package docket.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import docket.domain.repository.AdministradorRepository;
import docket.domain.model.Administrador;
import docket.domain.exception.AdministradorExistenteException;
import docket.domain.exception.AdministradorNaoEncontradoException;

@Service
public class AdministradorService {
	private AdministradorRepository administradorRepository;

	@Autowired
	public AdministradorService(AdministradorRepository administradorRepository) {
		this.administradorRepository = administradorRepository;
	}

	public List<Administrador> listar() {
		return administradorRepository.findAll();
	}

	public Administrador obterAdministrador(String usuario) {
		return findOrFail(usuario);
	}

	public Administrador salvarAdministrador(Administrador administrador) {
		if (findExists(administrador.getUsuario()))
			throw new AdministradorExistenteException("Usuário já existente");

		return administradorRepository.save(administrador);
	}

	public Administrador atualizarAdministrador(String usuario, Administrador administrador) {
		Administrador administradorSalvo = findOrFail(usuario);		
		administradorSalvo  = new Administrador(administrador);
		String novoUsuario = administradorSalvo.getUsuario();
		
		if (!usuario.equals(novoUsuario)) {
			if (findExists(novoUsuario)) {
				throw new AdministradorExistenteException("Usuário já existente");
			} else {
				this.removerAdministrador(usuario);
			}
		}

		return administradorRepository.save(administradorSalvo);
	}

	public void removerAdministrador(String usuario) {
		Administrador administrador = findOrFail(usuario);
		administradorRepository.delete(administrador);
	}

	private Administrador findOrFail(String usuario) {
		Administrador administradorEncontrado = administradorRepository.findByUsuario(usuario);

		if (administradorEncontrado == null)
			throw new AdministradorNaoEncontradoException("Administrador não localizado");

		return administradorEncontrado;
	}

	private Boolean findExists(String usuario) {
		return administradorRepository.existsByUsuario(usuario);
	}
}
