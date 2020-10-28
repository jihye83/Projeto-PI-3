/**
*
* @author Felipe Dias Amorim Pessoa
* @author Ji Hye Koo
* @author Marcus
* @author Thyago Rodrigues
* @author Victor Vilela
*/
package br.com.farmacia.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {

	private int id_Produto;
	private String nome_Prod;
	private float preco_Prod;
	private String descricao_Prod;
	private int qtd_Prod;

	public Produto(int id_Produto, String nome_Prod, float preco_Prod, String descricao_Prod, int qtd_Prod) {
		this.id_Produto = id_Produto;
		this.nome_Prod = nome_Prod;
		this.preco_Prod = preco_Prod;
		this.descricao_Prod = descricao_Prod;
		this.qtd_Prod = qtd_Prod;
	}

	@Override
	public String toString() {
		return String.format("Cod %d <br/> Nome %s <br/> Preco %f <br/> Descricao %s <br/> Qtd %d",
				this.getId_Produto(), this.getNome_Prod(), this.getPreco_Prod(), this.getDescricao_Prod(),
				this.getQtd_Prod());
	}

}
