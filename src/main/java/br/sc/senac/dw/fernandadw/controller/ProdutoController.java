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

import br.sc.senac.dw.fernandadw.model.entity.Produto;
import br.sc.senac.dw.fernandadw.model.exception.CampoInvalidoException;
import br.sc.senac.dw.fernandadw.model.seletor.ProdutoSeletor;
import br.sc.senac.dw.fernandadw.service.ProdutoService;

@RestController
@RequestMapping(path = "/api/produtos") //caminho que o controlador vai responder
// /produto???
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/todos")  //quando faz uma requisição web, tem que informar qual é o verbo http que você está usando (GET, POST, ...)
	public List<Produto> listarTodos() {
		return produtoService.listarTodos();
	}


	@PostMapping("/filtro")
	public List<Produto> listarComSeletor(@RequestBody ProdutoSeletor seletor){
		return produtoService.listarComSeletor(seletor);
	}

	@GetMapping("/{id}")
	public Produto pesquisarPorId(@PathVariable Integer id){
		return produtoService.consultarPorId(id.longValue());
	}
	
	@PostMapping
	public Produto salvar(@RequestBody Produto novoProduto) 
			throws CampoInvalidoException {
		return produtoService.inserir(novoProduto);
	}
	
	@PutMapping()
	public boolean atualizar(@RequestBody Produto produtoParaAtualizar) 
			throws CampoInvalidoException {
		return produtoService.atualizar(produtoParaAtualizar) != null;
	}
	
	@DeleteMapping("/{id}")
	public boolean excluir(@PathVariable Integer id) {
		return produtoService.excluir(id);
	}

}