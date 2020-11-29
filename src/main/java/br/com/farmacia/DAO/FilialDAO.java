/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.DAO;

import br.com.farmacia.DB.ConexaoDB;
import br.com.farmacia.Model.Filial;
import br.com.farmacia.servlet.ServletDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Felipe Dias Amorim Pessoa
 * @author Ji Hye Koo
 * @author Marcus
 * @author Thyago Rodrigues
 * @author Victor Vilela
 */
public class FilialDAO {

    public static List<Filial> getFilial() {
        List<Filial> listaFiliais = new ArrayList();
        try {
            Connection con = ConexaoDB.conector();
            String query = "select * from Filial";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_Filial");
                String nomeLoja = rs.getString("nome_Loja");
                String Tel = rs.getString("Tel");
                String logradouro = rs.getString("logradouro");
                String numLogr = rs.getString("numLogr");
                String compLogr = rs.getString("compLogr");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("uf");
                String cep = rs.getString("cep");

                listaFiliais.add(new Filial(id, nomeLoja, Tel, logradouro, numLogr, compLogr, bairro, cidade, uf, cep));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaFiliais;
    }

    public static void addFilial(Filial filial) throws SQLException, ClassNotFoundException {
        try {
            Connection con = ConexaoDB.conector();
            String query = "insert into Filial (nome_Loja, Tel, logradouro, numLogr, compLogr, bairro, cidade, uf, cep) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, filial.getNomeLoja());
            ps.setString(2, filial.getTel());
            ps.setString(3, filial.getLogradouro());
            ps.setString(4, filial.getNumLogr());
            ps.setString(5, filial.getCompLogr());
            ps.setString(6, filial.getBairro());
            ps.setString(7, filial.getCidade());
            ps.setString(8, filial.getUf());
            ps.setString(9, filial.getCep());
            ps.execute();
        } catch (Exception e) {
        }
    }

    public static void updateFilial(Filial filial) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoDB.conector();
        String query = "update Filial set nome_Loja=?,Tel=?,logradouro=?,numLogr=?,compLogr=?,bairro=?,cidade=?,uf=?,cep=? where id_Filial=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, filial.getNomeLoja());
        ps.setString(2, filial.getTel());
        ps.setString(3, filial.getLogradouro());
        ps.setString(4, filial.getNumLogr());
        ps.setString(5, filial.getCompLogr());
        ps.setString(6, filial.getBairro());
        ps.setString(7, filial.getCidade());
        ps.setString(8, filial.getUf());
        ps.setString(9, filial.getCep());
        ps.setInt(10, filial.getIdFilial());
        ps.execute();
    }

    public static void deleteFilial(String nomeLoja) throws ClassNotFoundException, SQLException {
        try {
            Connection con = ConexaoDB.conector();
            String query = "delete from Filial where id_Filial=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nomeLoja);
            ps.execute();
        } catch (Exception e) {
        }
    }

    public static Filial getFilial(String nomeLoja) {
        Filial filial = null;
        try {
            Connection con = ConexaoDB.conector();
            String query = "select * from Filial where nome_Loja=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nomeLoja);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id_Filial");
                String tel = rs.getString("Tel");
                String logradouro = rs.getString("logradouro");
                String numLogr = rs.getString("numLogr");
                String compLogr = rs.getString("compLogr");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("uf");
                String cep = rs.getString("cep");
                filial = new Filial(id, nomeLoja, tel, logradouro, numLogr, compLogr, bairro, cidade, uf, cep);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return filial;
    }

    public static boolean containFilial(String nomeLoja) {
        try {
            Connection con = ConexaoDB.conector();
            String query = "select * from Filial where nome_Loja=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nomeLoja);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
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
