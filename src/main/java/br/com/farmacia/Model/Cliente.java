package br.com.farmacia.Model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {

	private int idCliente;
	private String nome;
	private String email;
	private String logradouro;
	private String numLogr;
	private String compLogr;
	private String cep;
	private String bairro;
	private String cidade;
	private String uf;
	private String cel;
	private Date dataNasc;
	private long cpf;

//	public Cliente(String nome, long cpf, Date dataNasc, String email, String cel, String logradouro, String numLogr, String compLogr,
//			String bairro, String cidade, String uf, String cep) {
//
//	}

	public Cliente() {
	}

	public Cliente(String nome, long cpf, Date dataNasc, String email, String cel, String logradouro, String numLogr, String compLogr,
			String bairro, String cidade, String uf, String cep) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.email = email;
		this.cel = cel;
		this.logradouro = logradouro;
		this.numLogr = numLogr;
		this.compLogr = compLogr;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}

	@Override
	public String toString() {
		return String.format("Nome %s <br/> Email %s <br/> CPF %d", this.getNome(), this.getEmail(), this.getCpf());
	}

}
