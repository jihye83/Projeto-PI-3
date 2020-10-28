/**
*
* @author Felipe Dias Amorim Pessoa
* @author Ji Hye Koo
* @author Marcus
* @author Thyago Rodrigues
* @author Victor Vilela
*/
package br.com.farmacia.Model;

public class Filial {

	private int id_Filial;
	private String nome_Loja;
	private String telefone;
	private String logradouro;
	private String numLogr;
	private String compLogr;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;

	public Filial(int id_Filial, 
			String nome_Loja, 
			String telefone, 
			String logradouro, 
			String numLogr, 
			String compLogr,
			String bairro, 
			String cidade, 
			String uf, 
			String cep) {

		this.id_Filial = id_Filial;
		this.nome_Loja = nome_Loja;
		this.telefone = telefone;
		this.logradouro = logradouro;
		this.numLogr = numLogr;
		this.compLogr = compLogr;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}

	public int getId_Filial() {
		return id_Filial;
	}

	public void setId_Filial(int id_Filial) {
		this.id_Filial = id_Filial;
	}

	public String getNome_Loja() {
		return nome_Loja;
	}

	public void setNome_Loja(String nome_Loja) {
		this.nome_Loja = nome_Loja;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumLogr() {
		return numLogr;
	}

	public void setNumLogr(String numLogr) {
		this.numLogr = numLogr;
	}

	public String getCompLogr() {
		return compLogr;
	}

	public void setCompLogr(String compLogr) {
		this.compLogr = compLogr;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return String.format(
				"Codigo %d <br/> Nome loja %s "
				+ "<br/> Telefone %s "
				+ "<br/> Logradouro %s "
				+ "<br/> Numero %s "
				+ "<br/> Complemento %s "
				+ "<br/> Bairro %s "
				+ "<br/> Cidade %s <br/> "
				+ "UF %s <br/> CEP %s  ",
				this.getId_Filial(), 
				this.getNome_Loja(), 
				this.getTelefone(), 
				this.getLogradouro(), 
				this.getNumLogr(),
				this.getCompLogr(), 
				this.getBairro(), 
				this.getCidade(), 
				this.getUf(), 
				this.getCep());
	}



}