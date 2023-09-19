package br.sc.senac.dw.fernandadw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.sc.senac.dw.fernandadw.model.entity.Fabricante;
import br.sc.senac.dw.fernandadw.model.exception.CampoInvalidoException;
import br.sc.senac.dw.fernandadw.model.seletor.FabricanteSeletor;
import br.sc.senac.dw.fernandadw.model.specification.FabricanteSpecifications;

@Service
public class FabricanteService {
	
	@Autowired
	private FabricanteService fabricanteRepository;

	public List<Fabricante> listarTodos() {
		return fabricanteRepository.findAll();
	}

	public List<Fabricante> listarComSeletor(FabricanteSeletor seletor) {
		Specification<Fabricante> specification = FabricanteSpecifications.comFiltros(seletor);
		return fabricanteRepository.findAll(specification);
	}

	public Fabricante consultarPorId(Long id) {
		return fabricanteRepository.findById(id.longValue()).get();
	}

	public Fabricante inserir(Fabricante novoFabricante) throws CampoInvalidoException {
		validarCamposObrigatorios(novoFabricante);
		return fabricanteRepository.save(novoFabricante);
	}

	public Fabricante atualizar(Fabricante fabricanteParaAtualizar) throws CampoInvalidoException {
		validarCamposObrigatorios(fabricanteParaAtualizar);
		return fabricanteRepository.save(fabricanteParaAtualizar);
	}

	public boolean excluir(Integer id) {
		fabricanteRepository.deleteById(id.longValue());
		return true;
	}

	private void validarCamposObrigatorios(Fabricante fabricante) throws CampoInvalidoException {
		String mensagemValidacao = "";
		mensagemValidacao += validarCampoString(fabricante.getNome(), "nome");
		mensagemValidacao += validarCampoString(fabricante.getCnpj(), "cnpj");
		mensagemValidacao += validarCampoString(fabricante.getCidade(), "cidade");
		mensagemValidacao += validarCampoString(fabricante.getUf(), "uf");

		if(!mensagemValidacao.isEmpty()) {
			throw new CampoInvalidoException(mensagemValidacao);
		}
	}

	private String validarCampoString(String valorCampo, String nomeCampo) {
		if(valorCampo == null || valorCampo.trim().isEmpty()) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}

	private String validarCampoDouble(Double valorCampo, String nomeCampo) {
		if(valorCampo == null) {
			return "Informe o " + nomeCampo + " \n";
		}
		return "";
	}

	
}
