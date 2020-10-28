/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.DAO;

/**
 *
 * @author Felipe Dias Amorim Pessoa
 * @author Ji Hye Koo
 * @author Marcus
 * @author Thyago Rodrigues
 * @author Victor Vilela
 *///

import br.com.farmacia.util.ConexaoDB;
import br.com.farmacia.Model.Cliente;
import br.com.farmacia.servlet.ServletBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author tscarton
 */
public class ClienteDAO {

    public static List<Cliente> getClientes() {
        List<Cliente> listaClientes = new ArrayList();
        try {
            Connection con = ConexaoDB.conector();
            String query = "select * from cliente";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                long cpf = rs.getLong("cpf");
                Date dataNasc = rs.getDate("dataNasc");
                String email = rs.getString("email");
                String cel = rs.getString("cel");
                String logradouro = rs.getString("logradouro");
                String numLogr = rs.getString("numLogr");
                String compLogr = rs.getString("compLogr");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("uf");
                String cep = rs.getString("cep");
                
                
                listaClientes.add(new Cliente(nome, cpf, dataNasc, email, cel, logradouro, numLogr, compLogr, bairro, cidade, uf, cep ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }

    public static void addCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoDB.conector();
        String query = "insert into cliente(nome, email, cpf) values (?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getEmail());
        ps.setLong(3, cliente.getCpf());
        ps.execute();
    }

    public static void updateCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoDB.conector();
        String query = "update cliente set nome=?,email=? where cpf=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getEmail());
        ps.setLong(3, cliente.getCpf());
        ps.execute();
    }

    public static void deleteCliente(Long cpf) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoDB.conector();
        String query = "delete from cliente where cpf=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, cpf);
        ps.execute();
    }

    public static Cliente getCliente(Long cpf) {
        Cliente cliente = null;
        try {
            Connection con = ConexaoDB.conector();
            String query = "select * from cliente where cpf=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setLong(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                Date dataNasc = rs.getDate("dataNasc");
                String email = rs.getString("email");
                String cel = rs.getString("cel");
                String logradouro = rs.getString("logradouro");
                String numLogr = rs.getString("numLogr");
                String compLogr = rs.getString("compLogr");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("uf");
                String cep = rs.getString("cep");
                
                cliente = new Cliente(nome, cpf, dataNasc, email, cel, logradouro, numLogr, compLogr, bairro, cidade, uf, cep );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

}