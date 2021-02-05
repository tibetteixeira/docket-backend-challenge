package docket.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import docket.domain.model.Cartorio;
import docket.domain.service.CartorioService;

@RestController
@RequestMapping(path = "/api/cartorio", produces = MediaType.APPLICATION_JSON_VALUE)
public class CartorioController {

	private CartorioService cartorioService;

	@Autowired
	public CartorioController(CartorioService cartorioService) {
		this.cartorioService = cartorioService;
	}

	@GetMapping
	public List<Cartorio> listar() {
		return cartorioService.listar();
	}

	@GetMapping("/{nome}")
	public ResponseEntity<Cartorio> buscar(@PathVariable String nome) {
		return ResponseEntity.ok(cartorioService.obterCartorio(nome));
	}

	@PostMapping
	public ResponseEntity<Cartorio> salvar(@RequestBody Cartorio cartorio) {
		Cartorio cartorioSalvo = cartorioService.salvarCartorio(cartorio);

		return ResponseEntity.status(HttpStatus.CREATED).body(cartorioSalvo);
	}

	@PutMapping("/{nome}")
	public ResponseEntity<Cartorio> atualizar(@PathVariable String nome, @RequestBody Cartorio cartorio) {
		return ResponseEntity.ok(cartorioService.atualizarCartorio(nome, cartorio));
	}

	@DeleteMapping("/{nome}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String nome) {
		cartorioService.removerCartorio(nome);
	}
}
