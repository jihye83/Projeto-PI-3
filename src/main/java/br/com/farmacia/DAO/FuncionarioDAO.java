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

    public static List<Funcionario> getFuncionarios() {
        List<Funcionario> listaFuncionarios = new ArrayList();
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
                String bairro = rs.getString("bairro");
                String cidade = rs.getString("cidade");
                String uf = rs.getString("uf");
                String cep = rs.getString("cep");
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                String cargo = rs.getString("cargo");

                listaFuncionarios.add(new Funcionario(idFunc, nome, data_Nasc, cpf, cel, email, salario_Func,
                        data_Admissao, logradouro, numLogr, compLogr, bairro, cidade, uf, cep, login, senha,
                        cargo));
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaFuncionarios;
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
                + "login,"
                + "senha,"
                + "cargo)"
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
        ps.setString(15, funcionario.getLogin());
        ps.setString(16, funcionario.codificarSenha(funcionario.getSenha()));
        ps.setString(17, funcionario.getCargo());
        ps.execute();

    }

    public static void updateFuncionario(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        try {
            Connection con = ConexaoDB.conector();
            String query = "update Funcionario set nome=?, data_Nasc=?, cpf=?, cel=?, email=?, "
                    + "salario_Func=?, data_Admissao=?, logradouro=?, numLogr=?, compLogr=?, bairro=?, "
                    + "cidade=?, uf=?, cep=?, login=?, senha=?, cargo=? where id_Func = ?;";//where id_Func=?

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
            ps.setString(15, funcionario.getLogin());
            ps.setString(16, funcionario.getSenha());
            ps.setString(17, funcionario.getCargo());
            ps.setInt(18, funcionario.getIdFunc());

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas < 1) {
                String m = "Nenhuma linha afetada.";
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteFuncionario(String cpf) throws ClassNotFoundException, SQLException {
        Connection con = ConexaoDB.conector();
        String query = "delete from funcionario where cpf=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, cpf);
        ps.execute();
    }

    public static Funcionario getFuncionario(String cpf) {
        Funcionario funcionario = new Funcionario();
        try {
            Connection con = ConexaoDB.conector();

            String query = "select * from Funcionario where cpf = ?;";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cpf);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                funcionario.setIdFunc(rs.getInt("id_Func"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setData_Nasc(rs.getString("data_Nasc"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setCel(rs.getString("cel"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setSalario_Func(rs.getDouble("salario_Func"));
                funcionario.setData_Admissao(rs.getString("data_Admissao"));
                funcionario.setLogradouro(rs.getString("logradouro"));
                funcionario.setNumLogr(rs.getString("numLogr"));
                funcionario.setCompLogr(rs.getString("compLogr"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setUf(rs.getString("uf"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setLogin(rs.getString("login"));
                funcionario.setSenha(rs.getString("senha"));                
                funcionario.setCargo(rs.getString("cargo"));
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
    
    public static Funcionario getAcesso(String login) {
        Funcionario funcionario = null;
        try {
            Connection con = ConexaoDB.conector();
            String query = "select * from Funcionario where login=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String cargo = rs.getString("cargo");
                String senha = rs.getString("senha");
                funcionario = new Funcionario();
                funcionario.setLogin(login);
                funcionario.setSenha(senha);
                funcionario.setCargo(cargo);
                funcionario.setIdFunc(rs.getInt("id_Func"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setData_Nasc(rs.getString("data_Nasc"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setCel(rs.getString("cel"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setSalario_Func(rs.getDouble("salario_Func"));
                funcionario.setData_Admissao(rs.getString("data_Admissao"));
                funcionario.setLogradouro(rs.getString("logradouro"));
                funcionario.setNumLogr(rs.getString("numLogr"));
                funcionario.setCompLogr(rs.getString("compLogr"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setUf(rs.getString("uf"));
                funcionario.setCep(rs.getString("cep"));
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
}
