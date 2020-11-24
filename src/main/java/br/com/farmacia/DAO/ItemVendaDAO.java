/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.DAO;

import br.com.farmacia.DB.ConexaoDB;
import br.com.farmacia.Model.ItemVenda;
import br.com.farmacia.Model.Produto;
import br.com.farmacia.Model.Venda;
import br.com.farmacia.servlet.ServletDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lipes
 */
public class ItemVendaDAO {
    ProdutoDAO produtoDao = new ProdutoDAO();
    VendaDAO vendaDao = new VendaDAO();
    
    public List<ItemVenda> getItensVenda() {
        List<ItemVenda> listaItens = new ArrayList<>();
        try {
            // colocando o conector de BD
            Connection con = ConexaoDB.conector();
            String query = "select * from Item_compra";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("cod_ItemCompra");
                int qtd = rs.getInt("qtd");
                int idCompra = rs.getInt("id_Compra");
                int idProduto = rs.getInt("id_Produto");
                Produto produto = produtoDao.getProduto(idProduto);
                Venda venda = vendaDao.getVenda(idCompra);
                listaItens.add(new ItemVenda(id,produto,qtd,venda));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaItens;
    }

    public static void addItemVenda(ItemVenda item) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoDB.conector();
        String query = "insert into Item_compra(qtd,id_Compra,id_Produto) values (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, item.getQtd());
        ps.setInt(2, item.getVenda().getCod_Venda());
        ps.setInt(3, item.getProduto().getIdProduto());
        ps.execute();
    }


    public static void deleteProduto(int idITemVenda) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoDB.conector();
        String query = "delete from Item_compra where cod_ItemCompra=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, idITemVenda);
        ps.execute();
    }

    public ItemVenda getItemVenda(int idItemVenda) {
        ItemVenda item = null;
        try {
            Connection con = ConexaoDB.conector();
            String query = "select * from Item_compra where cod_ItemCompra=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idItemVenda);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                    int id = rs.getInt("cod_ItemCompra");
                int qtd = rs.getInt("qtd");
                int idCompra = rs.getInt("id_Compra");
                int idProduto = rs.getInt("id_Produto");
                Produto produto = produtoDao.getProduto(idProduto);
                Venda venda = vendaDao.getVenda(idCompra);
                item = new ItemVenda(id,produto,qtd,venda);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return item;
    }
    
}
