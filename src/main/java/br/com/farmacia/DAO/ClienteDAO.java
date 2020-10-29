/**
*
* @author Felipe Dias Amorim Pessoa
* @author Ji Hye Koo
* @author Marcus
* @author Thyago Rodrigues
* @author Victor Vilela
*/
package br.com.farmacia.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.farmacia.Model.Cliente;
import br.com.farmacia.servlet.ServletBD;
import br.com.farmacia.util.ConexaoDB;

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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
            log(Level.SEVERE, null, ex);
} catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        } finally {
			ConexaoDB.fecharConexao();
		}
        return listaClientes;
    }

    public static void addCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection con = ConexaoDB.conector();
        String query = "insert into cliente(nome, cpf, data_Nasc, email, cel, logradouro, numLogr, "
        		+ "compLogr, bairro, cidade, uf, cep) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cliente.getNome());
        ps.setLong(2, cliente.getCpf());
        ps.setDate(3, (java.sql.Date) cliente.getDataNasc());
        ps.setString(4, cliente.getEmail());
        ps.setString(5, cliente.getCel());
        ps.setString(6, cliente.getLogradouro());
        ps.setString(7, cliente.getNumLogr());
        ps.setString(8, cliente.getCompLogr());
        ps.setString(9, cliente.getBairro());
        ps.setString(10, cliente.getCidade());
        ps.setString(11, cliente.getUf());
        ps.setString(12, cliente.getCep());
        ps.execute();
    }

    public static void updateCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoDB.conector();
        String query = "update cliente set ,nome=?,data_Nasc=?,email=?,cel=?,logradouro=?,numLogr=?,"
        		+ "compLogr=?,bairro=?,cidade=?,uf=?,cep=? where cpf=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cliente.getNome());
        ps.setDate(2, (java.sql.Date) cliente.getDataNasc());
        ps.setString(3, cliente.getEmail());
        ps.setString(4, cliente.getCel());
        ps.setString(5, cliente.getLogradouro());
        ps.setString(6, cliente.getNumLogr());
        ps.setString(7, cliente.getCompLogr());
        ps.setString(8, cliente.getBairro());
        ps.setString(9, cliente.getCidade());
        ps.setString(10, cliente.getUf());
        ps.setString(11, cliente.getCep());
        ps.setLong(12, cliente.getCpf());
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
            	cliente.setNome(rs.getString("nome"));
            	cliente.setDataNasc(rs.getDate("dataNasc"));
            	cliente.setEmail(rs.getString("email"));
            	cliente.setCel(rs.getString("cel"));
            	cliente.setLogradouro(rs.getString("logradouro"));
            	cliente.setNumLogr(rs.getString("numLogr"));
            	cliente.setCompLogr(rs.getString("compLogr"));
            	cliente.setBairro(rs.getString("bairro"));
            	cliente.setCidade(rs.getString("cidade"));
            	cliente.setUf(rs.getString("uf"));
            	cliente.setCep(rs.getString("cep"));
            }
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletBD.class.getName()).
            log(Level.SEVERE, null, ex);
}  catch (SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return cliente;
    }

}