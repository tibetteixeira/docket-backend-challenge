package docket.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import docket.domain.model.Cartorio;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, String> {
	Cartorio findByCnpj(String cnpj);

	Cartorio findByNome(String nome);

	Boolean existsByNome(String nome);

	Boolean existsByCnpj(String cnpj);
}
