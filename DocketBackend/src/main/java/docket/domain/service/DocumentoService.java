package docket.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import docket.domain.repository.DocumentoRepository;
import docket.domain.model.Documento;
import docket.domain.exception.DocumentoExistenteException;
import docket.domain.exception.DocumentoNaoEncontradoException;

@Service
public class DocumentoService {
	private DocumentoRepository documentoRepository;

	@Autowired
	public DocumentoService(DocumentoRepository documentoRepository) {
		this.documentoRepository = documentoRepository;
	}

	public List<Documento> listar() {
		return documentoRepository.findAll();
	}

	public List<Documento> obterDocumento(String nome) {
		return findOrFail(nome);
	}

	public Documento salvarDocumento(Documento documento) {
		if (findExists(documento))
			throw new DocumentoExistenteException("Documento já existente");

		return documentoRepository.save(documento);
	}

	private List<Documento> findOrFail(String nome) {
		List<Documento> documentosEncontrados = documentoRepository.findByNome(nome);

		if (documentosEncontrados.size() == 0)
			throw new DocumentoNaoEncontradoException("Documento não localizado");

		return documentosEncontrados;
	}

	private Documento findOrFail(String nome, String tipo) {
		List<Documento> documentosEncontrados = documentoRepository.findByNome(nome);

		if (documentosEncontrados.size() == 0)
			throw new DocumentoNaoEncontradoException("Documento não localizado");

		for (Documento documentoEncontrado : documentoRepository.findByNome(nome)) {
			if (documentoEncontrado.getTipoDocumento().equals(tipo)) {
				return documentoEncontrado;
			}
		}
		throw new DocumentoNaoEncontradoException("Documento não localizado");
	}

	private Boolean findExists(Documento documento) {
		if (documentoRepository.existsByNome(documento.getNome())) {
			for (Documento documentoEncontrado : documentoRepository.findByNome(documento.getNome())) {
				if (documento.getTipoDocumento().equals(documentoEncontrado.getTipoDocumento())) {
					return true;
				}
			}

			return false;
		}
		return false;
	}
}
