package br.com.farmacia.servlet;



import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.Model.Produto;
/**
* @author Felipe Dias Amorim Pessoa
* @author Ji Hye Koo
* @author Marcus
* @author Thyago Rodrigues
* @author Victor Vilela
*/
public class ListarProduto extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		List<Produto> listaProdutos = ProdutoDAO.getProdutos();
		request.setAttribute("listaProdutos", listaProdutos);
		
		RequestDispatcher requestDispatcher = getServletContext()
				.getRequestDispatcher("/listaProdutos.jsp");
		requestDispatcher.forward(request, response);	
	}
}
