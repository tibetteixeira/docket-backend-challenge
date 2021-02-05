package docket.domain.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import docket.domain.model.Administrador;
import docket.domain.model.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, String>{
	List<Documento> findByNome(String nome);
	
	Boolean existsByNome(String nome);
}
