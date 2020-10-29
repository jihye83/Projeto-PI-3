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
import br.com.farmacia.Model.Produto;
import br.com.farmacia.util.Utils;

public class CadastrarProduto extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// se tirar o id_Prod está dando erro na contrutor
		//String id_ProdutoStr = request.getParameter("id_Produto");
	//	int id_Produto = (id_ProdutoStr!=null) ? Integer.parseInt(id_ProdutoStr) : 0;
		String nome_Prod = request.getParameter("nome_Prod");
		String preco_ProdStr = request.getParameter("preco_Prod");
		float preco_Prod = (preco_ProdStr!=null) ? Float.parseFloat(preco_ProdStr) : 0 ;
		String descricao_Prod = request.getParameter("descricao_Prod");
		String qtd_ProdStr = request.getParameter("qtd_Prod");
		int qtd_Prod = (qtd_ProdStr!=null) ? Integer.parseInt(qtd_ProdStr) : 0;
		
		Produto produto = new Produto(nome_Prod, preco_Prod, descricao_Prod, qtd_Prod);
		try {
			System.out.println("erro aqui");
			ProdutoDAO.adicionaProduto(produto);
			response.sendRedirect("sucesso.jsp");
		} catch (ClassNotFoundException | SQLException ex) {
			
			Logger.getLogger(CadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
			Utils.mostrarTelaErro(ex, request, response);
		}
	}
}