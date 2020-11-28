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
import java.sql.Statement;
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
    
    public List<ItemVenda> getItensVenda(int idVenda) {
        List<ItemVenda> listaItens = new ArrayList<>();
        try {
            // colocando o conector de BD
            Connection con = ConexaoDB.conector();
            String query = "select * from Item_compra where id_Compra = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idVenda);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("cod_ItemCompra");
                int qtd = rs.getInt("qtd");
                int idCompra = rs.getInt("id_Compra");
                int idProduto = rs.getInt("id_Produto");
                float valor = rs.getFloat("valor_Unitario");
                Produto produto = produtoDao.getProduto(idProduto);
                Venda venda = vendaDao.getVenda(idCompra);
                listaItens.add(new ItemVenda(id,produto,qtd,venda,valor));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaItens;
    }

    public int addItemVenda(ItemVenda item) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoDB.conector();
        String query = "insert into Item_compra(qtd,id_Compra,id_Produto,valor_Unitario) values (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, item.getQtd());
        ps.setInt(2, item.getVenda().getCod_Venda());
        ps.setInt(3, item.getProduto().getIdProduto());
        ps.setFloat(4, item.getValor());
        int rs = ps.executeUpdate();
        
        if(rs>0){
             ResultSet generatedKeys = ps.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int key = generatedKeys.getInt(1);
                        item.setIdItem(key);
                        return key;
                    } else {
                        throw new SQLException("Falha ao obter o ID");
                    }
        }
        
        return -1;
    }


    public static void deleteItemVenda(int idITemVenda) throws SQLException, ClassNotFoundException {
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
                  float valor = rs.getFloat("valor_Unitario");
                Produto produto = produtoDao.getProduto(idProduto);
                Venda venda = vendaDao.getVenda(idCompra);
                item = new ItemVenda(id,produto,qtd,venda,valor);
            }else{
                System.out.println("nao foi possivel encontrar item!!!");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return item;
    }
    
}
