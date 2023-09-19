package br.sc.senac.dw.fernandadw.model.seletor;

public class FabricanteSeletor extends BaseSeletor{

	private String nome;
    private String cnpj;
    private Double cidade;
    private Double uf;
    
	public FabricanteSeletor(String nome, String cnpj, Double cidade, Double uf) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.cidade = cidade;
		this.uf = uf;
	}

	public FabricanteSeletor() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Double getCidade() {
		return cidade;
	}

	public void setCidade(Double cidade) {
		this.cidade = cidade;
	}

	public Double getUf() {
		return uf;
	}

	public void setUf(Double uf) {
		this.uf = uf;
	}
    
	
}
