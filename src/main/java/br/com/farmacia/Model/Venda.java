package br.com.farmacia.Model;

import java.util.Date;

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
	
	public Venda() {
		
	}
	
	public Venda(int cod_Venda, Date data_Venda, float valor_Bruto, float desconto, String pagamento, float total, int id_Cliente) {
		this.cod_Venda = cod_Venda;
		this.data_Venda = data_Venda;
		this.valor_Bruto = valor_Bruto;
		this.desconto = desconto;
		this.pagamento = pagamento;
		this.total= total;
		this.id_Cliente = id_Cliente;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Cod %d <br/> data_Venda %d <br/> valor_Bruto %f <br/> desconto %f <br/> pagamento %s <br/> total %f",
				this.getCod_Venda(), this.getData_Venda(), this.getValor_Bruto(), this.getDesconto(), this.getPagamento(),
				this.getTotal());
	}
}