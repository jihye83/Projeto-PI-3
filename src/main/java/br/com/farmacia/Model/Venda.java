/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.Model;

/**
 *
 * @author PICHAU
 */
import java.util.Date;
import java.util.LinkedList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Venda {

    private int cod_Venda;
    private Date data_Venda;
    private float valor_Bruto;
    private float desconto;
    private String pagamento;
    private float total;
    private int id_Cliente;
    private LinkedList<ItemVenda> itens;

    public Venda() {
        this.cod_Venda = 0;
        this.data_Venda = new Date();
        this.valor_Bruto = 0;
        this.desconto = 0;
        this.pagamento = "";
        this.total = 0;
        this.id_Cliente = 0;
        this.itens = new LinkedList<>();
    }

    public Venda(int cod_Venda,
            Date data_Venda,
            float valor_Bruto,
            float desconto,
            String pagamento,
            float total,
            int id_Cliente) {
        this.cod_Venda = cod_Venda;
        this.data_Venda = data_Venda;
        this.valor_Bruto = valor_Bruto;
        this.desconto = desconto;
        this.pagamento = pagamento;
        this.total = total;
        this.id_Cliente = id_Cliente;
    }

    @Override
    public String toString() {
        return String.format(
                "Cod %d <br/> data_Venda %d "
                + "<br/> valor_Bruto %f "
                + "<br/> desconto %f "
                + "<br/> pagamento %s "
                + "<br/> total %f",
                this.getCod_Venda(),
                this.getData_Venda(),
                this.getValor_Bruto(),
                this.getDesconto(),
                this.getPagamento(),
                this.getTotal());
    }
}
