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

import docket.domain.model.Documento;
import docket.domain.service.DocumentoService;

@RestController
@RequestMapping(path = "/api/documento", produces = MediaType.APPLICATION_JSON_VALUE)
public class DocumentoController {

	private DocumentoService documentoService;

	@Autowired
	public DocumentoController(DocumentoService documentoService) {
		this.documentoService = documentoService;
	}

	@GetMapping
	public List<Documento> listar() {
		return documentoService.listar();
	}

	@GetMapping("/{nome}")
	public ResponseEntity<Documento> buscar(@PathVariable String nome) {
		return ResponseEntity.ok(documentoService.obterDocumento(nome));
	}

	@PostMapping
	public ResponseEntity<Documento> salvar(@RequestBody Documento documento) {
		Documento documentoSalvo = documentoService.salvarDocumento(documento);

		return ResponseEntity.status(HttpStatus.CREATED).body(documentoSalvo);
	}

	@PutMapping("/{nome}")
	public ResponseEntity<Documento> atualizar(@PathVariable String nome, @RequestBody Documento documento) {
		return ResponseEntity.ok(documentoService.atualizarDocumento(nome, documento));
	}

	@DeleteMapping("/{nome}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String nome) {
		documentoService.removerDocumento(nome);
	}
}
