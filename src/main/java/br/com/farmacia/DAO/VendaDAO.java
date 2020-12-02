/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.DAO;

/**
 *
 * @author PICHAU
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.farmacia.Model.Cliente;
import br.com.farmacia.Model.Venda;
import br.com.farmacia.servlet.ServletDB;
import br.com.farmacia.DB.ConexaoDB;
import java.sql.Statement;

public class VendaDAO {

    public static List<Venda> getVendas() {
        List<Venda> listaVendas = new ArrayList();
        try {
            Connection con = ConexaoDB.conector();
            String sql = "select * from Compra";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Venda venda = new Venda();
                venda.setCod_Venda(rs.getInt("cod_Compra"));
                venda.setData_Venda(rs.getDate("data_Compra"));
                venda.setValor_Bruto(rs.getFloat("valor_Bruto"));
                venda.setDesconto(rs.getFloat("desconto"));
                venda.setTotal(rs.getFloat("total"));
                venda.setPagamento(rs.getString("pagamento"));
                Cliente cliCompra = new Cliente();
                cliCompra.setIdCliente(rs.getInt("id_Cliente"));
                venda.setId_Cliente(rs.getInt("id_Cliente"));
                listaVendas.add(venda);
            }

        } catch (Exception ex) {
            Logger.getLogger(ServletDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVendas;
    }
    public static List<Venda> getVendasFilial( int idFilial) {
        List<Venda> listaVendas = new ArrayList();
        try {
            Connection con = ConexaoDB.conector();
            String sql = "select * from Compra where id_Filial = ?";
            PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, idFilial);
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                Venda venda = new Venda();
                venda.setCod_Venda(rs.getInt("cod_Compra"));
                venda.setData_Venda(rs.getDate("data_Compra"));
                venda.setValor_Bruto(rs.getFloat("valor_Bruto"));
                venda.setDesconto(rs.getFloat("desconto"));
                venda.setTotal(rs.getFloat("total"));
                venda.setPagamento(rs.getString("pagamento"));
                Cliente cliCompra = new Cliente();
                cliCompra.setIdCliente(rs.getInt("id_Cliente"));
                venda.setId_Cliente(rs.getInt("id_Cliente"));
                listaVendas.add(venda);
            }

        } catch (Exception ex) {
            Logger.getLogger(ServletDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVendas;
    }

    public static void adicionaVenda(Venda venda) throws SQLException, ClassNotFoundException {

        try {
            Connection con = ConexaoDB.conector();
            String sql = "insert into Compra(data_Compra, valor_Bruto,desconto,total,pagamento) values (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pst.setDate(1, new Date(venda.getData_Venda().getTime()));
            pst.setFloat(2, venda.getValor_Bruto());
            pst.setFloat(3, venda.getDesconto());
            pst.setFloat(4, venda.getTotal());
            pst.setString(5, venda.getPagamento());
            int rs = pst.executeUpdate();
            if (rs > 0) {
               
                    ResultSet generatedKeys = pst.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int key = generatedKeys.getInt(1);
                        venda.setCod_Venda(key);
                    } else {
                        throw new SQLException("Falha ao obter o ID");
                    }
                System.out.println("inserido na tabela de compras com sucesso!");
            } else {
                System.out.println("erro ao inserir na tabela de compras");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
      public static void updateVenda(Venda venda) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoDB.conector();
        String query = "update Compra set valor_Bruto=?,total=?,desconto=?, pagamento=?, id_Cliente=? where cod_compra=?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setFloat(1, venda.getValor_Bruto());
         pst.setFloat(2, venda.getTotal());
            pst.setFloat(3, venda.getDesconto());       
            pst.setString(4, venda.getPagamento());
            pst.setInt(5, venda.getId_Cliente());
            pst.setInt(6, venda.getCod_Venda());
        pst.execute();
    }

    public static boolean deletaVenda(int id_Compra) throws SQLException, ClassNotFoundException {
        try {
            Connection con = ConexaoDB.conector();
            String sql = "delete from Compra where cod_compra=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_Compra);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("removido com sucesso");
                return true;
            } else {
                System.out.println("falha ao apagar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Venda getVenda(int cod_Compra) {
        Venda venda = null;
        try {
            Connection con = ConexaoDB.conector();
            String sql = "select * from Compra where cod_Compra=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cod_Compra);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                venda = new Venda();
                venda.setCod_Venda(rs.getInt("cod_Compra"));
                venda.setTotal(rs.getFloat("total"));
                venda.setDesconto(rs.getFloat("desconto"));
                venda.setValor_Bruto(rs.getInt("valor_Bruto"));
                venda.setData_Venda(rs.getDate("data_Compra"));
                venda.setPagamento(rs.getString("pagamento"));
                rs.getInt("id_Cliente");
            }else{
                System.out.println("error ao pegar venda!!!");
            }
        } catch (Exception ex) {
            Logger.getLogger(ServletDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return venda;
    }
}
