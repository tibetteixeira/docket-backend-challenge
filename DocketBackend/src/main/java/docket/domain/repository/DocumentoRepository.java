package docket.domain.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import docket.domain.model.Administrador;
import docket.domain.model.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, String>{
	Documento findById(Integer id);
	Documento findByNome(String nome);
	
//	@Query("SELECT * FROM categoria where descricao like :tipo")
//	Integer getIdCategoria(@Param("tipo") String tipo);
	
	Boolean existsByNome(String nome);
}
