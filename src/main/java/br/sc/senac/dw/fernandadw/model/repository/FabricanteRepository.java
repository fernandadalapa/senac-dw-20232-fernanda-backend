package br.sc.senac.dw.fernandadw.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.sc.senac.dw.fernandadw.model.entity.Fabricante;

@Repository
	public interface FabricanteRepository extends JpaRepository<Fabricante, Long>, JpaSpecificationExecutor<Fabricante> {
		List<Fabricante> findAllByNomeLike(String nomeInformado);
	}
