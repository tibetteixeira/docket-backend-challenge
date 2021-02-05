package docket.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import docket.domain.repository.CartorioRepository;
import docket.domain.model.Cartorio;
import docket.domain.exception.CartorioExistenteException;
import docket.domain.exception.CartorioNaoEncontradoException;

@Service
public class CartorioService {
	private CartorioRepository cartorioRepository;

	@Autowired
	public CartorioService(CartorioRepository cartorioRepository) {
		this.cartorioRepository = cartorioRepository;
	}

	public List<Cartorio> listar() {
		return cartorioRepository.findAll();
	}

	public Cartorio obterCartorio(String nome) {
		return findOrFail(nome);
	}

	public Cartorio salvarCartorio(Cartorio cartorio) {
		if (findExists(cartorio.getNome()))
			throw new CartorioExistenteException("Cartório já existente");
		
		return cartorioRepository.save(cartorio);
	}

	public Cartorio atualizarCartorio(String nome, Cartorio cartorio) {
		Cartorio cartorioSalvo = findOrFail(nome);
		cartorioSalvo = new Cartorio(cartorio);
		String novoNome = cartorioSalvo.getNome();

		if (!nome.equals(novoNome)) {
			if (findExists(novoNome)) {
				throw new CartorioExistenteException("Cartório já existente");
			} else {
				this.removerCartorio(nome);
			}
		}

		return cartorioRepository.save(cartorioSalvo);
	}

	public void removerCartorio(String nome) {
		Cartorio cartorio = findOrFail(nome);
		cartorioRepository.delete(cartorio);
	}

	private Cartorio findOrFail(String nome) {
		Cartorio cartorioEncontrado = cartorioRepository.findByNome(nome);

		if (cartorioEncontrado == null)
			throw new CartorioNaoEncontradoException("Cartorio não localizado");

		return cartorioEncontrado;
	}

	private Boolean findExists(String nome) {
		return cartorioRepository.existsByNome(nome);
	}
}
