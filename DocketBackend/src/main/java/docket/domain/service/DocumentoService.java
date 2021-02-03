package docket.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import docket.domain.repository.DocumentoRepository;
import docket.domain.model.Documento;
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

	public Documento obterDocumento(Integer id) {
		return null;
	}
	
	public Documento obterDocumento(String nome) {
		return null;
	}

	public Documento salvarDocumento(Documento documento) {
		return documentoRepository.save(documento);
	}

	public Documento atualizarDocumento(Integer id, Documento documento) {
		return null;
	}

	public void removerDocumento(Integer id) {
		
	}

	private Documento findOrFail(String nome) {
		Documento documentoEncontrado = documentoRepository.findByNome(nome);

		if (documentoEncontrado == null)
			throw new DocumentoNaoEncontradoException("Documento não localizado");

		return documentoEncontrado;
	}

	private Boolean findExists(String nome) {
		return documentoRepository.existsByNome(nome);
	}
}
