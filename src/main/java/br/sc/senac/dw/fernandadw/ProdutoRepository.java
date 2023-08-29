package br.sc.senac.dw.fernandadw;

public class ProdutoRepository {
	
	@Repository
	public interface ProdutoRepository extends JpaRepository<Produto, Long>, JpaSpecificationExecutor<Produto> {
		//É possível declarar métodos do JpaRepository aqui, combinando atributos e operadores SQL
		
		//https://reflectoring.io/spring-data-specifications/
		//Exemplo
		List<Produto> findAllByNomeLike(String nomeInformado);
	}

}
