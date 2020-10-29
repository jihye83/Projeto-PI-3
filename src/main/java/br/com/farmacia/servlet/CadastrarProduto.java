/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.servlet;

import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.Model.Produto;
import br.com.farmacia.Util.Utils;
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
public class CadastrarProduto extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// se tirar o id_Prod está dando erro na contrutor
		int id_Produto = Integer.parseInt(request.getParameter("id_Produto"));
		String nome_Prod = request.getParameter("nome_Prod");
		float preco_Prod = Float.parseFloat(request.getParameter("preco_Prod"));
		String descricao_Prod = request.getParameter("descricao_Prod");
		int qtd_Prod = Integer.parseInt(request.getParameter("qtd_Prod"));
		
		Produto produto = new Produto(nome_Prod, preco_Prod, descricao_Prod, qtd_Prod);
		
                try {
			ProdutoDAO.addProduto(produto);
			response.sendRedirect("sucesso.jsp");
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
			Utils.mostrarTelaErro(ex, request, response);
		}
	}
}
