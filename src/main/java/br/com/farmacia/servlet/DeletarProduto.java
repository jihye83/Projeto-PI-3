/**
*
* @author Felipe Dias Amorim Pessoa
* @author Ji Hye Koo
* @author Marcus
* @author Thyago Rodrigues
* @author Victor Vilela
*/
package br.com.farmacia.servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.farmacia.DAO.ProdutoDAO;

public class DeletarProduto extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		int id_Produto = Integer.parseInt(request.getParameter("id_produto"));
		try {
			ProdutoDAO.deletaProduto(id_Produto);
			response.getWriter().print(true);
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(DeletarProduto.class.getName()).log(Level.SEVERE, null, ex);
			response.getWriter().print(false);
		}
	}
}
