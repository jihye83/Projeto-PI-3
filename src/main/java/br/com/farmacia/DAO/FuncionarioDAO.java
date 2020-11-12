package br.com.farmacia.DAO;

import br.com.farmacia.DB.ConexaoDB;
import br.com.farmacia.Model.Funcionario;
import br.com.farmacia.servlet.ServletDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDAO {

    public static List<Funcionario> getFuncionario() {
        List<Funcionario> listaFuncionario = new ArrayList();
        try {
            Connection con = ConexaoDB.conector();
            String query = "select * from Funcionario";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idFunc = rs.getInt("id_Func");
                String nome = rs.getString("nome");
                String data_Nasc = rs.getString("data_Nasc");
                String cpf = rs.getString("cpf");
                String cel = rs.getString("cel");
                String email = rs.getString("email");
                double salario_Func = rs.getDouble("salario_Func");
                String data_Admissao = rs.getString("data_Admissao");
                String logradouro = rs.getString("logradouro");
                String numLogr = rs.getString("numLogr");
                String compLogr = rs.getString("compLogr");
                String bairro = rs.getString("bairro ");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("uf");
                String cep = rs.getString("cep");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                String perfil_Func = rs.getString("perfil_Func");

                listaFuncionario.add(new Funcionario(idFunc, nome, data_Nasc, cpf, cel, email, salario_Func,
                        data_Admissao, logradouro, numLogr, compLogr, bairro, cidade, uf, cep, usuario, senha,
                        perfil_Func));
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaFuncionario;
    }

    public static void addFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection con = null;
        
        try {
            con = ConexaoDB.conector();
        } catch (Exception E) {
            
        }
        

        String query = "insert into Funcionario (nome,"
                + "data_Nasc,"
                + "cpf,"
                + "cel,"
                + "email,"
                + "salario_Func,"
                + "data_Admissao,"
                + "logradouro,"
                + "numLogr,"
                + "compLogr,"
                + "bairro,"
                + "cidade,"
                + "uf,"
                + "cep,"
                + "usuario,"
                + "senha,"
                + "perfil_Func)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, funcionario.getNome());
        ps.setString(2, funcionario.getData_Nasc());
        //ps.setDate(2, new Date(funcionario.getData_Nasc().getTime()));
        ps.setString(3, funcionario.getCpf());
        ps.setString(4, funcionario.getCel());
        ps.setString(5, funcionario.getEmail());
        ps.setDouble(6, funcionario.getSalario_Func());
        ps.setString(7, funcionario.getData_Admissao());
        //ps.setDate(7, new Date (funcionario.getData_Admissao().getTime()));
        ps.setString(8, funcionario.getLogradouro());
        ps.setString(9, funcionario.getNumLogr());
        ps.setString(10, funcionario.getCompLogr());
        ps.setString(11, funcionario.getBairro());
        ps.setString(12, funcionario.getCidade());
        ps.setString(13, funcionario.getUf());
        ps.setString(14, funcionario.getCep());
        ps.setString(15, funcionario.getUsuario());
        ps.setString(16, funcionario.getSenha());
        ps.setString(17, funcionario.getPerfil_Func());
        ps.execute();

    }

    public static void updateFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoDB.conector();
        String query = "update Funcionario set nome=?, data_Nasc=?, cpf=?, cel=?, email=?, "
                + "salario_Func=?, data_Admissao=?,logradouro=?, numLogr=?, compLogr=?, bairro=?, "
                + "cidade=?, uf=?, cep=?, usuario=?, senha=?, perfil_Func=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, funcionario.getNome());
        ps.setString(2, funcionario.getData_Nasc());
        ps.setString(3, funcionario.getCpf());
        ps.setString(4, funcionario.getCel());
        ps.setString(5, funcionario.getEmail());
        ps.setDouble(6, funcionario.getSalario_Func());
        ps.setString(7, funcionario.getData_Admissao());
        ps.setString(8, funcionario.getLogradouro());
        ps.setString(9, funcionario.getNumLogr());
        ps.setString(10, funcionario.getCompLogr());
        ps.setString(11, funcionario.getBairro());
        ps.setString(12, funcionario.getCidade());
        ps.setString(13, funcionario.getUf());
        ps.setString(14, funcionario.getCep());
        ps.setString(15, funcionario.getUsuario());
        ps.setString(16, funcionario.getSenha());
        ps.setString(17, funcionario.getPerfil_Func());
        ps.execute();
    }

    public static void deleteFuncionario(String cpf) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoDB.conector();
        String query = "delete from cliente where cpf=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cpf);
        ps.execute();
    }

    public static Funcionario getFuncionario(String cpf) {
        Funcionario funcionario = null;
        try {
            Connection con = ConexaoDB.conector();
            String query = "select * from Funcionario where cpf=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String data_Nasc = rs.getString("data_Nasc");
                String cel = rs.getString("cel");
                String email = rs.getString("email");
                double salario_Func = rs.getDouble("salario_Func");
                String data_Admissao = rs.getString("data_Admissao");
                String logradouro = rs.getString("logradouro");
                String numLogr = rs.getString("numLogr");
                String compLogr = rs.getString("compLogr");
                String bairro = rs.getString("bairro ");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("uf");
                String cep = rs.getString("cep");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                String perfil_Func = rs.getString("perfil_Func");

                funcionario = new Funcionario(nome,
                        data_Nasc,
                        cpf,
                        cel,
                        email,
                        salario_Func,
                        data_Admissao,
                        logradouro,
                        numLogr,
                        compLogr,
                        bairro,
                        cidade,
                        uf,
                        cep,
                        usuario,
                        senha,
                        perfil_Func);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return funcionario;
    }

    public static boolean containFuncionario(String cpf) {
        try {
            Connection con = ConexaoDB.conector();
            String query = "select * from Funcionario where cpf=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);
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
