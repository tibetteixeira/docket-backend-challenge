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

import docket.domain.model.Administrador;
import docket.domain.service.AdministradorService;

@RestController
@RequestMapping(path = "/api/administrador", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdministradorController {

	private AdministradorService administradorService;

	@Autowired
	public AdministradorController(AdministradorService administradorService) {
		this.administradorService = administradorService;
	}

	@GetMapping
	public List<Administrador> listar() {
		return administradorService.listar();
	}

	@GetMapping("/{usuario}")
	public ResponseEntity<Administrador> buscar(@PathVariable String usuario) {
		return ResponseEntity.ok(administradorService.obterAdministrador(usuario));
	}

	@PostMapping
	public ResponseEntity<Administrador> salvar(@RequestBody Administrador administrador) {
		Administrador administradorSalvo = administradorService.salvarAdministrador(administrador);

		return ResponseEntity.status(HttpStatus.CREATED).body(administradorSalvo);
	}

	@PutMapping("/{usuario}")
	public ResponseEntity<Administrador> atualizar(@PathVariable String usuario, @RequestBody Administrador administrador) {
		return ResponseEntity.ok(administradorService.atualizarAdministrador(usuario, administrador));
	}

	@DeleteMapping("/{usuario}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String usuario) {
		administradorService.removerAdministrador(usuario);
	}
}
