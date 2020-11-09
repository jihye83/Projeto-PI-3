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
        
        private int idProduto;
	private String nomeProd;
	private float precoProd;
	private String descricaoProd;
	private int qtdProd;

        public Produto() {
            
        }
        
	public Produto(int id_Produto, String nome_Prod, float preco_Prod, String descricao_Prod, int qtd_Prod) {
		this.idProduto = id_Produto;
                this.nomeProd = nome_Prod;
		this.precoProd = preco_Prod;
		this.descricaoProd = descricao_Prod;
		this.qtdProd = qtd_Prod;
	}

    public Produto(String nome_Prod, float preco_Prod, String descricao_Prod, int qtd_Prod) {
        
    }

    @Override
    public String toString() {
        return "Produto{" + "idProduto=" + idProduto + ", nomeProd=" + nomeProd + ", precoProd=" + precoProd + ", descricaoProd=" + descricaoProd + ", qtdProd=" + qtdProd + '}';
    }
        
	
}


