/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.DAO;

/**
 *
 * @author JHK
 */
import br.com.farmacia.DB.ConexaoDB;
import br.com.farmacia.Model.Produto;
import br.com.farmacia.servlet.ServletDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {

    public static List<Produto> getProdutos() {
        List<Produto> listaProdutos = new ArrayList();
        try {
            // colocando o conector de BD
            Connection con = ConexaoDB.conector();
            String query = "select * from Produto";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nome_Prod = rs.getString("nome_Prod");
                float preco_Prod = rs.getFloat("preco_Prod");
                String descricao_Prod = rs.getString("descricao_Prod");
                int qtd_Prod = rs.getInt("qtd_Prod");
                listaProdutos.add(new Produto(nome_Prod, preco_Prod, descricao_Prod, qtd_Prod));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaProdutos;
    }

    public static void addProduto(Produto produto) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoDB.conector();
        String query = "insert into Produto(nome_Prod, preco_Prod, descricao_Prod, qtd_Prod) values (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, produto.getNome_Prod());
        ps.setFloat(2, produto.getPreco_Prod());
        ps.setString(3, produto.getDescricao_Prod());
        ps.setInt(4, produto.getQtd_Prod());
        ps.execute();
    }

    public static void updateProduto(Produto produto) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoDB.conector();
        String query = "update Produto set nome_Prod=?,preco_Prod=?,descricao_Prod=?, qtd_Prod=? where id_Produto=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, produto.getNome_Prod());
        ps.setFloat(1, produto.getPreco_Prod());
        ps.setString(3, produto.getDescricao_Prod());
        ps.setInt(4, produto.getQtd_Prod());
        ps.execute();
    }

    public static void deleteProduto(int id_Produto) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoDB.conector();
        String query = "delete from Produto where id_Produto=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id_Produto);
        ps.execute();
    }

    public static Produto getProduto(int id_Produto) {
        Produto produto = null;
        try {
            Connection con = ConexaoDB.conector();
            String query = "select * from Produto where id_Produto=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id_Produto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nome_Prod = rs.getString("nome_Prod");
                float preco_Prod = rs.getFloat("preco_Prod");
                String descricao_Prod = rs.getString("descricao_Prod");
                int qtd_Prod = rs.getInt("qtd_Prod");
                produto = new Produto(nome_Prod, preco_Prod, descricao_Prod, qtd_Prod);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return produto;
    }
}
