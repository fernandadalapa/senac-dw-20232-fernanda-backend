package br.sc.senac.dw.fernandadw.model.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.sc.senac.dw.fernandadw.model.entity.Produto;
import br.sc.senac.dw.fernandadw.model.seletor.ProdutoSeletor;
import jakarta.persistence.criteria.Predicate;

public class ProdutoSpecifications {

	public static Specification<Produto> comFiltros(ProdutoSeletor seletor) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (seletor.getNome() != null) {
                predicates.add(cb.like(cb.lower(root.get("nome")), "%" 
                		+ seletor.getNome().toLowerCase() + "%"));
            }
            
            if (seletor.getFabricante() != null) {
                predicates.add(cb.like(cb.lower(root.get("fabricante")), "%" 
                		+ seletor.getFabricante().toLowerCase() + "%"));
            }
            
            if(seletor.getPesoMinimo() != null && seletor.getPesoMaximo() != null) {
            	//WHERE peso BETWEEN min AND max
            	predicates.add(cb.between(root.get("peso"), seletor.getPesoMinimo(), seletor.getPesoMaximo()));
            } else if(seletor.getPesoMinimo() != null) {
            	//WHERE peso >= min
            	predicates.add(cb.greaterThanOrEqualTo(root.get("peso"), seletor.getPesoMinimo()));
            } else if(seletor.getPesoMaximo() != null) {
            	//WHERE peso <= max
            	predicates.add(cb.lessThanOrEqualTo(root.get("peso"), seletor.getPesoMaximo()));
            }
            
            if(seletor.getValorMinimo() != null && seletor.getValorMaximo() != null) {
            	predicates.add(cb.between(root.get("valor"), seletor.getValorMinimo(), seletor.getValorMaximo()));
            } else if (seletor.getValorMinimo() != null) {
            	predicates.add(cb.greaterThanOrEqualTo(root.get("valor"), seletor.getValorMinimo()));
            } else if (seletor.getValorMaximo() != null) {
            	predicates.add(cb.lessThanOrEqualTo(root.get("valor"), seletor.getValorMaximo()));
            }
            
            if(seletor.getDataCadastroInicial() != null && seletor.getDataCadastroFinal() != null) {
            	predicates.add(cb.between(root.get("data"), seletor.getDataCadastroInicial(), seletor.getDataCadastroFinal()));
            }else if (seletor.getDataCadastroInicial() != null) {
            	predicates.add(cb.greaterThanOrEqualTo(root.get("data"), seletor.getDataCadastroInicial()));
            } else if (seletor.getDataCadastroFinal() != null) {
            	predicates.add(cb.lessThanOrEqualTo(root.get("data"), seletor.getDataCadastroFinal()));
            }
            

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
	
}
