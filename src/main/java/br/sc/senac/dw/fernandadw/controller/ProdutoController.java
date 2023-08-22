package br.sc.senac.dw.fernandadw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.dw.fernandadw.ProdutoService;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {

	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(path = "/todos")
	public List<Produto> listarTodos() {
		return produtoService.listarTodos();
	}
}
