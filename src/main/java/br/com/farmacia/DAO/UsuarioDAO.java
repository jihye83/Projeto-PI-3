/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.DAO;

import br.com.farmacia.DB.ConexaoDB;
import br.com.farmacia.Model.Cliente;
import br.com.farmacia.Model.Usuario;
import br.com.farmacia.servlet.ServletDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
public class UsuarioDAO {
    
    public static Usuario getUsuario(String login, String senha) {
        Usuario usuario = null;
        try {
            Connection con = ConexaoDB.conector();
            String query = "select * from Usuario where login=? and senha=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String perfil = rs.getString("perfil");
                usuario = new Usuario();
                usuario.setNome(nome);
                usuario.setLogin(login);
                usuario.setSenha(senha);
                usuario.setPerfil(perfil);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletDB.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
}
