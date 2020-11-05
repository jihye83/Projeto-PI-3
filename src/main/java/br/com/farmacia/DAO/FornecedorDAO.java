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
            String query = "selecy * from fornecedor";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String razaoSocial = rs.getString("razaoSocial");
                String cnpj = rs.getString("cnpj");
                String Tel = rs.getString("Tel");
                String logradouro = rs.getString("logradouro");
                String numLogr = rs.getString("numLogr");
                String compLogr = rs.getString("compLogr");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("uf");
                String cep = rs.getString("cep");

                listaFornecedores.add(new Fornecedor(razaoSocial, cnpj, Tel, logradouro, numLogr, compLogr, bairro, cidade, uf, cep));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaFornecedores;
    }

    public static void addFornecedor(Fornecedor fornecedor) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoDB.conector();
        String query = "insert into fornecedor (razaoSocial, cnpj, Tel, logradouro, numLogr, compLogr, bairro, cidade, uf, cep) values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, fornecedor.getRazaoSocial());
        ps.setString(2, fornecedor.getCnpj());
        ps.setString(3, fornecedor.getTel());
        ps.setString(4, fornecedor.getLogradouro());
        ps.setString(5, fornecedor.getNumLogr());
        ps.setString(6, fornecedor.getCompLogr());
        ps.setString(7, fornecedor.getBairro());
        ps.setString(8, fornecedor.getCidade());
        ps.setString(9, fornecedor.getUf());
        ps.setString(10, fornecedor.getCep());
        ps.execute();
    }

    public static void updateFornecedor(Fornecedor fornecedor) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoDB.conector();
        String query = "update fornecedor set razaoSocial=?,cnpj=?,Tel=?,logradouro=?,numLogr=?,compLogr=?,bairro=?,cidade=?,uf=?,cep=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, fornecedor.getRazaoSocial());
        ps.setString(2, fornecedor.getCnpj());
        ps.setString(3, fornecedor.getTel());
        ps.setString(4, fornecedor.getLogradouro());
        ps.setString(5, fornecedor.getNumLogr());
        ps.setString(6, fornecedor.getCompLogr());
        ps.setString(7, fornecedor.getBairro());
        ps.setString(8, fornecedor.getCidade());
        ps.setString(9, fornecedor.getUf());
        ps.setString(10, fornecedor.getCep());
        ps.execute();
    }

    public static void deleteFornecedor(String cnpj) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoDB.conector();
        String query = "delete from fornecedor where cnpj=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cnpj);
        ps.execute();
    }

    public static Fornecedor getFornecedor(String cnpj) {
        Fornecedor fornecedor = null;
        try {
            Connection con = ConexaoDB.conector();
            String query = "select * from fornecedor where cnpj=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cnpj);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String razaoSocial = rs.getString("razaoSocial");
                String Tel = rs.getString("Tel");
                String logradouro = rs.getString("logradouro");
                String numLogr = rs.getString("numLogr");
                String compLogr = rs.getString("compLogr");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("uf");
                String cep = rs.getString("cep");
                fornecedor = new Fornecedor(razaoSocial, cnpj, Tel, logradouro, numLogr, compLogr, bairro, cidade, uf, cep);
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
}
