package br.sc.senac.dw.fernandadw.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "fabricantes")
	public class Fabricante {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String nome;
		private String cnpj;
		private String cidade;
		private String uf;
		
		@JsonBackReference
	    @OneToMany(mappedBy = "fabricante")
	    private List<Produto> produtos;

		public Fabricante(Integer id, String nome, String cnpj, String cidade, String uf, List<Produto> produtos) {
			super();
			this.id = id;
			this.nome = nome;
			this.cnpj = cnpj;
			this.cidade = cidade;
			this.uf = uf;
			this.produtos = produtos;
		}

		public Fabricante() {
			super();
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
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

		public String getCidade() {
			return cidade;
		}

		public void setCidade(String cidade) {
			this.cidade = cidade;
		}

		public String getUf() {
			return uf;
		}

		public void setUf(String uf) {
			this.uf = uf;
		}

		public List<Produto> getProdutos() {
			return produtos;
		}

		public void setProdutos(List<Produto> produtos) {
			this.produtos = produtos;
		}
	
		
	}