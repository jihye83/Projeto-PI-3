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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.farmacia.DB.ConexaoDB;
import br.com.farmacia.Model.Cliente;
import br.com.farmacia.servlet.ServletDB;
import java.sql.*;
import java.util.ArrayList;
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
            String query = "select * from Cliente";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String cel = rs.getString("cel");
                String logradouro = rs.getString("logradouro");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("uf");
                String cep = rs.getString("cep");
                
                listaClientes.add(new Cliente(nome, cpf, email, cel, logradouro, bairro, cidade, uf, cep));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }
    
    public static void addCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoDB.conector();
        String query = "insert into Cliente (nome, cpf, email, cel, logradouro, bairro, cidade, uf, cep) values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getEmail());
        ps.setString(4, cliente.getCel());
        ps.setString(5, cliente.getLogradouro());
        ps.setString(6, cliente.getBairro());
        ps.setString(7, cliente.getCidade());
        ps.setString(8, cliente.getUf());
        ps.setString(9, cliente.getCep());
        ps.execute();
    }
    
    public static void updateCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoDB.conector();
        String query = "update cliente set nome=?,email=?,cel=?,logradouro=?,bairro=?,cidade=?,uf=?,cep=? where cpf=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getEmail());
        ps.setString(3, cliente.getCel());
        ps.setString(4, cliente.getLogradouro());
        ps.setString(5, cliente.getBairro());
        ps.setString(6, cliente.getCidade());
        ps.setString(7, cliente.getUf());
        ps.setString(8, cliente.getCep());
        ps.setString(9, cliente.getCpf());
        ps.execute();
    }
    
    public static void deleteCliente(String cpf) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoDB.conector();
        String query = "delete from cliente where cpf=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cpf);
        ps.execute();
    }
    
    public static Cliente getCliente(String cpf) {
        Cliente cliente = null;
        try {
            Connection con = ConexaoDB.conector();
            String query = "select * from cliente where cpf=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cel = rs.getString("cel");
                String logradouro = rs.getString("logradouro");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("uf");
                String cep = rs.getString("cep");
                cliente = new Cliente(nome, cpf, email, cel, logradouro, bairro, cidade, uf, cep);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

}
