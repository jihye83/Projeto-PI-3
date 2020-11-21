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

    public ItemVenda() {
    }

    public ItemVenda(int idItem, Produto produto, int qtd) {
        this.idItem = idItem;
        this.produto = produto;
        this.qtd = qtd;
    }
    
    public ItemVenda( Produto produto, int qtd) {
        this.idItem = idItem;
        this.produto = produto;
        this.qtd = qtd;
    }
    
    
}
