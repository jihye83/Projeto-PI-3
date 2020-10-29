/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.Model;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author JHK
 */
@Getter
@Setter
public class Produto {
    private int id_Produto;
	private String nome_Prod;
	private float preco_Prod;
	private String descricao_Prod;
	private int qtd_Prod;

	public Produto(String nome_Prod, float preco_Prod, String descricao_Prod, int qtd_Prod) {
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


