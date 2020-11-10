package br.com.farmacia.DAO;

import br.com.farmacia.DB.ConexaoDB;
import br.com.farmacia.Model.Cliente;
import br.com.farmacia.servlet.ServletDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {

    public static List<Cliente> getClientes() {
        List<Cliente> listaClientes = new ArrayList();
        try {
            Connection con = ConexaoDB.conector();
            String query = "select * from Cliente";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idCliente = rs.getInt("id_Cliente");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String cel = rs.getString("cel");
                String logradouro = rs.getString("logradouro");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("uf");
                String cep = rs.getString("cep");
                
                listaClientes.add(new Cliente(idCliente, nome, cpf, email, cel, logradouro, bairro, cidade, uf, cep));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
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
        String query = "update cliente set nome=?,cpf=?,email=?,cel=?,logradouro=?,bairro=?,cidade=?,uf=?,cep=? where id_Cliente=?";
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
        ps.setInt(10, cliente.getIdCliente());
        ps.execute();
    }
    
    public static void deleteCliente(String cpf) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoDB.conector();
        String query = "delete from Cliente where cpf=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cpf);
        ps.execute();
    }
    
    public static Cliente getCliente(String cpf) {
        Cliente cliente = null;
        try {
            Connection con = ConexaoDB.conector();
            String query = "select * from Cliente where cpf=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idCliente = rs.getInt("id_Cliente");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cel = rs.getString("cel");
                String logradouro = rs.getString("logradouro");
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("uf");
                String cep = rs.getString("cep");
                cliente = new Cliente(idCliente, nome, cpf, email, cel, logradouro, bairro, cidade, uf, cep);
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
    
    public static boolean containCliente(String cpf) {
        try {
            Connection con = ConexaoDB.conector();
            String query = "select * from Cliente where cpf=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
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
