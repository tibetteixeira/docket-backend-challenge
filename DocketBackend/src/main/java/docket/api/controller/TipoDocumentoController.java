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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import docket.domain.model.TipoDocumento;
import docket.domain.service.TipoDocumentoService;

@RestController
@RequestMapping(path = "/api/tipo_documento", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipoDocumentoController {

	private TipoDocumentoService tipoDocumentoService;

	@Autowired
	public TipoDocumentoController(TipoDocumentoService tipoDocumentoService) {
		this.tipoDocumentoService = tipoDocumentoService;
	}

	@GetMapping
	public List<TipoDocumento> listar() {
		return tipoDocumentoService.listar();
	}

	@PostMapping
	public ResponseEntity<TipoDocumento> salvar(@RequestBody TipoDocumento tipoDocumento) {
		TipoDocumento tipoDocumentoSalvo = tipoDocumentoService.salvarTipoDocumento(tipoDocumento);

		return ResponseEntity.status(HttpStatus.CREATED).body(tipoDocumentoSalvo);
	}

	@DeleteMapping("/{tipo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String tipo) {
		tipoDocumentoService.removerTipoDocumento(tipo);
	}
}
