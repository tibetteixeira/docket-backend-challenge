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
	
	public Documento obterDocumento(String nome) {
		return findOrFail(nome);
	}

	public Documento salvarDocumento(Documento documento) {
		if (findExists(documento.getNome()))
			throw new DocumentoExistenteException("Documento já existente");
		
		return documentoRepository.save(documento);
	}

	public Documento atualizarDocumento(String nome, Documento documento) {
		Documento documentoSalvo = findOrFail(nome);
		documentoSalvo = new Documento(documento);
		String novoNome = documentoSalvo.getNome();

		if (!nome.equals(novoNome)) {
			if (findExists(novoNome)) {
				throw new DocumentoExistenteException("Documento já existente");
			} else {
				this.removerDocumento(nome);
			}
		}

		return documentoRepository.save(documentoSalvo);
	}

	public void removerDocumento(String nome) {
		Documento documento = findOrFail(nome);
		documentoRepository.delete(documento);
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
