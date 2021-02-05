package docket.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import docket.domain.model.Administrador;
import docket.domain.model.TipoDocumento;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, String> {
	TipoDocumento findByDescricao(String descricao);

	Boolean existsByDescricao(String descricao);
}
