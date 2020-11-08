/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.DAO;

import br.com.farmacia.DB.ConexaoDB;
import br.com.farmacia.Model.Fornecedor;
import br.com.farmacia.servlet.ServletDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JHK
 */
public class FornecedorDAO {

    public static List<Fornecedor> getFornecedores() {
        List<Fornecedor> listaFornecedores = new ArrayList();
        try {
            Connection con = ConexaoDB.conector();
            String query = "select * from Fornecedor";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 int id = rs.getInt("id_Fornecedor");
                String razaoSocial = rs.getString("razaoSocial");
                String cnpj = rs.getString("cnpj");
                String tel = rs.getString("Tel");
                String logradouro = rs.getString("logradouro");
                String numLogr = rs.getString("numLogr");
                String compLogr = rs.getString("compLogr");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("uf");
                String cep = rs.getString("cep");

                listaFornecedores.add(new Fornecedor(id,razaoSocial, cnpj, tel, logradouro, numLogr, compLogr, bairro, cidade, uf, cep));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
        return listaFornecedores;
    }

    public static void addFornecedor(Fornecedor fornecedor) throws SQLException, ClassNotFoundException {
        try {
             Connection con = ConexaoDB.conector();
        String query = "insert into Fornecedor (razaoSocial, cnpj, cel, logradouro, numLogr, compLogr, bairro, cidade, uf, cep) values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, fornecedor.getRazaoSocial());
        ps.setString(2, fornecedor.getCnpj());
        ps.setString(3, fornecedor.getCel());
        ps.setString(4, fornecedor.getLogradouro());
        ps.setString(5, fornecedor.getNumLogr());
        ps.setString(6, fornecedor.getCompLogr());
        ps.setString(7, fornecedor.getBairro());
        ps.setString(8, fornecedor.getCidade());
        ps.setString(9, fornecedor.getUf());
        ps.setString(10, fornecedor.getCep());
        ps.execute();
        } catch (Exception e) {
        }
       
    }

    public static void updateFornecedor(Fornecedor fornecedor) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoDB.conector();
        String query = "update Fornecedor set razaoSocial=?,cnpj=?,Tel=?,logradouro=?,numLogr=?,compLogr=?,bairro=?,cidade=?,uf=?,cep=? where id_Fornecedor=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, fornecedor.getRazaoSocial());
        ps.setString(2, fornecedor.getCnpj());
        ps.setString(3, fornecedor.getCel());
        ps.setString(4, fornecedor.getLogradouro());
        ps.setString(5, fornecedor.getNumLogr());
        ps.setString(6, fornecedor.getCompLogr());
        ps.setString(7, fornecedor.getBairro());
        ps.setString(8, fornecedor.getCidade());
        ps.setString(9, fornecedor.getUf());
        ps.setString(10, fornecedor.getCep());
        ps.setInt(11, fornecedor.getIdFornecedor());
        ps.execute();
    }

    public static void deleteFornecedor(String cnpj) throws ClassNotFoundException, SQLException {
        try {
            Connection con = ConexaoDB.conector();
        String query = "delete from Fornecedor where cnpj=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cnpj);
        ps.execute(); 
        } catch (Exception e) {
        }
       
    }

    public static Fornecedor getFornecedor(String cnpj) {
        Fornecedor fornecedor = null;
        try {
            Connection con = ConexaoDB.conector();
            String query = "select * from Fornecedor where cnpj=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cnpj);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id = rs.getInt("id_Fornecedor");
                String razaoSocial = rs.getString("razaoSocial");
                String tel = rs.getString("Tel");
                String logradouro = rs.getString("logradouro");
                String numLogr = rs.getString("numLogr");
                String compLogr = rs.getString("compLogr");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("uf");
                String cep = rs.getString("cep");
                fornecedor = new Fornecedor(id,razaoSocial, cnpj, tel, logradouro, numLogr, compLogr, bairro, cidade, uf, cep);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return fornecedor;
    }
    
    public static boolean containFornecedor(String cnpj) {
        try {
            Connection con = ConexaoDB.conector();
            String query = "select * from Fornecedor where cnpj=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cnpj);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
