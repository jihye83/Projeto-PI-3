package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.farmacia.Model.Produto;
import br.com.farmacia.servlet.ServletBD;
import br.com.farmacia.util.ConexaoDB;

public class ProdutoDAO {

	public static List<Produto> getProdutos() {
		List<Produto> listaProdutos = new ArrayList();
		try {
			// colocando o conector de BD
			Connection con = ConexaoDB.conector();
			String query = "select * from produto";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id_Produto = rs.getInt("id_Produto");
				String nome_Prod = rs.getString("nome_Prod");
				float preco_Prod = rs.getFloat("preco_Prod");
				String descricao_Prod = rs.getString("descricao_Prod");
				int qtd_Prod = rs.getInt("qtd_Prod");
				listaProdutos.add(new Produto(id_Produto, nome_Prod, preco_Prod, descricao_Prod, qtd_Prod));
			}

		} catch (Exception ex) {
			Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listaProdutos;
	}

	public static void adicionaProduto(Produto produto) throws SQLException, ClassNotFoundException {
		Connection con = ConexaoDB.conector();
		String query = "insert into produto(nome_Prod, preco_Prod, descricao_Prod, qtd_Prod(?,?,?,?))";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, produto.getNome_Prod());
		ps.setFloat(2, produto.getPreco_Prod());
		ps.setString(3, produto.getDescricao_Prod());
		ps.setInt(4, produto.getQtd_Prod());
		ps.execute();
	}

	public static void alteraProduto(Produto produto) throws SQLException, ClassNotFoundException {
		Connection con = ConexaoDB.conector();
		String query = "update produto set nome_Prod=?,preco_Prod=?,descricao_Prod=?, qtd_Prod=? where id_Produto=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, produto.getNome_Prod());
		ps.setFloat(1, produto.getPreco_Prod());
		ps.setString(3, produto.getDescricao_Prod());
		ps.setInt(4, produto.getQtd_Prod());
		ps.execute();
	}
	
	public static void deletaProduto(int id_Produto) throws SQLException, ClassNotFoundException {
		Connection con = ConexaoDB.conector();
		String query = "delete from produto where id_Produto=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id_Produto);
		ps.execute();
	}
	
	public static Produto getProduto(int id_Produto) {
		Produto produto = null;
		try {
			Connection con = ConexaoDB.conector();
			String query = "select * from produto where id_Produto=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id_Produto);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String nome_Prod = rs.getString("nome_Prod");
				float preco_Prod = rs.getFloat("preco_Prod");
				String descricao_Prod = rs.getString("descricao_Prod");
				int qtd_Prod = rs.getInt("qtd_Prod");
				produto = new Produto(id_Produto, nome_Prod, preco_Prod, descricao_Prod, qtd_Prod);
			}
		} catch (Exception ex) {
			Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
		}	
		return produto;
	}
}
