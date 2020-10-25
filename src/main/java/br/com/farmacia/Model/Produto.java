package br.com.farmacia.Model;

public class Produto {

	private int id_Produto;
	private String nome_Prod;
	private double preco_Prod;
	private String descricao_Prod;
	private int qtd_Prod;

	public Produto(int id_Produto, String nome_Prod, double preco_Prod, String descricao_Prod, int qtd_Prod) {
		this.id_Produto = id_Produto;
		this.nome_Prod = nome_Prod;
		this.preco_Prod = preco_Prod;
		this.descricao_Prod = descricao_Prod;
		this.qtd_Prod = qtd_Prod;
	}

	public int getId_Produto() {
		return id_Produto;
	}

	public void setId_Produto(int id_Produto) {
		this.id_Produto = id_Produto;
	}

	public String getNome_Prod() {
		return nome_Prod;
	}

	public void setNome_Prod(String nome_Prod) {
		this.nome_Prod = nome_Prod;
	}

	public double getPreco_Prod() {
		return preco_Prod;
	}

	public void setPreco_Prod(double preco_Prod) {
		this.preco_Prod = preco_Prod;
	}

	public String getDescricao_Prod() {
		return descricao_Prod;
	}

	public void setDescricao_Prod(String descricao_Prod) {
		this.descricao_Prod = descricao_Prod;
	}

	public int getQtd_Prod() {
		return qtd_Prod;
	}

	public void setQtd_Prod(int qtd_Prod) {
		this.qtd_Prod = qtd_Prod;
	}

	@Override
	public String toString() {
		return String.format("Cod %d <br/> Nome %s <br/> Preco %f <br/> Descricao %s <br/> Qtd %d",
				this.getId_Produto(), this.getNome_Prod(), this.getPreco_Prod(), this.getDescricao_Prod(),
				this.getQtd_Prod());
	}

}
