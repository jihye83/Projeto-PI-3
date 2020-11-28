package br.com.farmacia.Model;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Felipe Dias
 */
@Getter
@Setter

public class ItemVenda {

    private int idItem;
    private Produto produto;
    private int qtd;
    private Venda venda;
    private float valor;
    
    public ItemVenda() {
    }

    public ItemVenda(int idItem, Produto produto, int qtd,Venda venda, float valor) {
        this.idItem = idItem;
        this.produto = produto;
        this.qtd = qtd;
        this.venda = venda;
        this.valor = valor;
    }

    public ItemVenda(Produto produto, int qtd) {
        this.idItem = idItem;
        this.produto = produto;
        this.qtd = qtd;
    } 
    
    

}
