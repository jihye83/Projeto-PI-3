/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.servlet;

import br.com.farmacia.DAO.ProdutoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JHK
 */
public class ExcluirProduto extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		int id_Produto = Integer.parseInt(request.getParameter("id_produto"));
		try {
			ProdutoDAO.deleteProduto(id_Produto);
			response.getWriter().print(true);
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(ExcluirProduto.class.getName()).log(Level.SEVERE, null, ex);
			response.getWriter().print(false);
		}
	}
}
