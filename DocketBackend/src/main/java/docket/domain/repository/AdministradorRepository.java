package docket.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import docket.domain.model.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, String>{
	Administrador findByUsuario(String usuario);
	
	Boolean existsByUsuario(String usuario);
}
