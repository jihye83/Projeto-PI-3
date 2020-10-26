package br.com.farmacia.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.Model.Produto;
import br.com.farmacia.util.Utils;

public class AlterarProduto extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id_Produto = Integer.parseInt(request.getParameter("id_Produto"));
		Produto produto = ProdutoDAO.getProduto(id_Produto);
		request.setAttribute("produto", produto);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/AlterarProduto.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id_Produto = Integer.parseInt(request.getParameter("id_Produto"));
		String nome_Prod = request.getParameter("nome_Produto");
		double preco_Prod = Double.parseDouble(request.getParameter("preco_Prod"));
		String descricao_Prod = request.getParameter("descricao_Prod");
		int qtd_Prod = Integer.parseInt("qtd_Prod");
		
		Produto produto = ProdutoDAO.getProduto(id_Produto);
		produto.setNome_Prod(nome_Prod);
		produto.setPreco_Prod(preco_Prod);
		produto.setDescricao_Prod(descricao_Prod);
		produto.setQtd_Prod(qtd_Prod);
		
		try {
			ProdutoDAO.adicionaProduto(produto);
			response.sendRedirect("sucesso.jsp");
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(AlterarProduto.class.getName()).log(Level.SEVERE, null, ex);
			Utils.mostrarTelaErro(ex, request, response);
		}
	}

}
