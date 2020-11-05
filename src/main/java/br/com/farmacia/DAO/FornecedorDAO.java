/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.DAO;

import br.com.farmacia.DB.ConexaoDB;
import br.com.farmacia.Model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JHK
 */
public class FornecedorDAO {

    public static List<Fornecedor> getFornecedor() {
        List<Fornecedor> listaFornecedor = new ArrayList();
        try {
            Connection con = ConexaoDB.conector();
            String query = "selecy * from fornecedor";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String razaoSocial = rs.getString("razaoSocial");
            }
        } catch (Exception e) {
        }
        return listaFornecedor;
    }
}
