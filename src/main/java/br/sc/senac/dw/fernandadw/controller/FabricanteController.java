package br.sc.senac.dw.fernandadw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.dw.fernandadw.model.entity.Fabricante;
import br.sc.senac.dw.fernandadw.model.exception.CampoInvalidoException;
import br.sc.senac.dw.fernandadw.model.seletor.FabricanteSeletor;
import br.sc.senac.dw.fernandadw.service.FabricanteService;

@RestController
@RequestMapping(path = "/api/produtos")
public class FabricanteController {
	
	@Autowired
	private FabricanteService fabricanteService;
	
	@GetMapping("/todos")  
	public List<Fabricante> listarTodos() {
		return fabricanteService.listarTodos();
	}


	@PostMapping("/filtro")
	public List<Fabricante> listarComSeletor(@RequestBody FabricanteSeletor seletor){
		return fabricanteService.listarComSeletor(seletor);
	}

	@GetMapping("/{id}")
	public Fabricante pesquisarPorId(@PathVariable Integer id){
		return fabricanteService.consultarPorId(id.longValue());
	}
	
	@PostMapping
	public Fabricante salvar(@RequestBody Fabricante novoProduto) 
			throws CampoInvalidoException {
		return fabricanteService.inserir(novoProduto);
	}
	
	@PutMapping()
	public boolean atualizar(@RequestBody Fabricante fabricanteParaAtualizar) 
			throws CampoInvalidoException {
		return fabricanteService.atualizar(fabricanteParaAtualizar) != null;
	}
	
	@DeleteMapping("/{id}")
	public boolean excluir(@PathVariable Integer id) {
		return fabricanteService.excluir(id);
	}

}
