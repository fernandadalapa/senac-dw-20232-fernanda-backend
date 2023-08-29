package br.sc.senac.dw.fernandadw;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.sc.senac.dw.fernandadw.controller.Produto;

@Repository
	public interface ProdutoRepository extends JpaRepository<Produto, Long>, JpaSpecificationExecutor<Produto> {
		List<Produto> findAllByNomeLike(String nomeInformado);
	}
