package docket.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import docket.domain.repository.TipoDocumentoRepository;
import docket.domain.model.TipoDocumento;
import docket.domain.exception.TipoDocumentoExistenteException;
import docket.domain.exception.TipoDocumentoNaoEncontradoException;

@Service
public class TipoDocumentoService {
	private TipoDocumentoRepository tipoDocumentoRepository;

	@Autowired
	public TipoDocumentoService(TipoDocumentoRepository tipoDocumentoRepository) {
		this.tipoDocumentoRepository = tipoDocumentoRepository;
	}

	public List<TipoDocumento> listar() {
		return tipoDocumentoRepository.findAll();
	}

	public TipoDocumento salvarTipoDocumento(TipoDocumento tipoDocumento) {
		if (findExists(tipoDocumento.getDescricao()))
			throw new TipoDocumentoExistenteException("Tipo de documento já existente");

		return tipoDocumentoRepository.save(tipoDocumento);
	}

	public void removerTipoDocumento(String tipo) {
		TipoDocumento tipoDocumento = findOrFail(tipo);
		tipoDocumentoRepository.delete(tipoDocumento);
	}

	private TipoDocumento findOrFail(String tipo) {
		TipoDocumento tipoDocumentoEncontrado = tipoDocumentoRepository.findByDescricao(tipo);

		if (tipoDocumentoEncontrado == null)
			throw new TipoDocumentoNaoEncontradoException("Tipo de documento não localizado");

		return tipoDocumentoEncontrado;
	}

	private Boolean findExists(String tipo) {
		return tipoDocumentoRepository.existsByDescricao(tipo);
	}
}
