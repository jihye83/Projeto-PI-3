/**
 * @author Felipe Dias Amorim Pessoa
 * @author Ji Hye Koo
 * @author Marcus
 * @author Thyago Rodrigues
 * @author Victor Vilela
 *
 */
package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.farmacia.Model.Filial;
import br.com.farmacia.util.ConexaoDB;

public class FilialDAO {

	public static List<Filial> getFiliais() {
		
		List<Filial> listaFiliais = new ArrayList();
		
		try {
			//USANDO O (CONECTOR) DO BANCO DE DADOS.
			Connection con = ConexaoDB.conector();
			
			String query = "select * from filial";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				int id_Filial = rs.getInt("id_Filial");
				String nome_Loja = rs.getString("nome_Loja");
				String telefone = rs.getString("telefone");
				String logradouro = rs.getString("logradouro");
				String numLogr = rs.getString("numLogr");
				String compLogr = rs.getString("compLogr");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				String uf = rs.getString("uf");
				String cep = rs.getString("cep");
				
				listaFiliais.add(new Filial(id_Filial, nome_Loja, telefone, logradouro, numLogr, compLogr, bairro, cidade, uf, cep));
			}

		} catch (Exception ex) {

			//PRECISA ARRUMAR SERVLET NA PARTE DE CONEXÃO COM BANCO DE DADOS.
			Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listaFiliais;
	}

	public static void adicionaFilial(Filial filial) throws SQLException, ClassNotFoundException {
		Connection con = ConexaoDB.conector();
		String query = "insert into filial(nome_Loja, telefone, logradouro, numLogr, compLogr, bairro, cidade, uf, cep(?,?,?,?,?,?,?,?,?))";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, filial.getNome_Loja());
		ps.setString(2, filial.getTelefone());
		ps.setString(3, filial.getLogradouro());
		ps.setString(3, filial.getNumLogr());
		ps.setString(4, filial.getCompLogr());
		ps.setString(5, filial.getBairro());
		ps.setString(6, filial.getCidade());
		ps.setString(7, filial.getUf());
		ps.setString(8, filial.getCep());
		
		ps.execute();
	}

	public static void alteraProduto(Filial filial) throws SQLException, ClassNotFoundException {
		Connection con = ConexaoDB.conector();
		String query = "update filial set nome_Loja=?,telefone=?,logradouro=?, numLogr=?, compLogr=?, bairro=?, cidade=?, uf=?, cep=?  where id_Filial=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, filial.getNome_Loja());
		ps.setString(2, filial.getTelefone());
		ps.setString(3, filial.getLogradouro());
		ps.setString(3, filial.getNumLogr());
		ps.setString(4, filial.getCompLogr());
		ps.setString(5, filial.getBairro());
		ps.setString(6, filial.getCidade());
		ps.setString(7, filial.getUf());
		ps.setString(8, filial.getCep());
		
		ps.execute();
	}
	
	public static void deletaProduto(int id_Filial) throws SQLException, ClassNotFoundException {
		
		Connection con = ConexaoDB.conector();
		String query = "delete from filial where id_Filial=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id_Filial);
		
		ps.execute();
	}
	
	public static Filial getProduto(int id_Filial) {
		
		Filial filial = null;
		
		try {
			Connection con = ConexaoDB.conector();
			String query = "select * from produto where id_Produto=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id_Filial);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				String nome_Loja = rs.getString("nome_Loja");
				String telefone = rs.getString("telefone");
				String logradouro = rs.getString("logradouro");
				String numLogr = rs.getString("numLogr");
				String compLogr = rs.getString("compLogr");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				String uf = rs.getString("uf");
				String cep = rs.getString("cep");
				
				filial = new Filial(id_Filial, nome_Loja, telefone, logradouro, numLogr, compLogr, bairro, cidade, uf, cep);
							 
			}
		} catch (Exception ex) {

			//PRECISA ARRUMAR SERVLET NA PARTE DE CONEXÃO COM BANCO DE DADOS.
			Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return filial;
	}
	

}