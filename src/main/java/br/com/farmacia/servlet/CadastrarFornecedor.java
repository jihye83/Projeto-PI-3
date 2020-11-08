package br.com.farmacia.servlet;

import br.com.farmacia.DAO.FornecedorDAO;
import br.com.farmacia.Model.Fornecedor;
import br.com.farmacia.Util.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author felipe
 */
@WebServlet(name = "CadastrarFornecedor", urlPatterns = {"/CadastrarFornecedor"})
public class CadastrarFornecedor extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String razaoSocial = request.getParameter("razaoSocial");
        String cnpj = request.getParameter("cnpj");
        String cel = request.getParameter("cel");
        String logradouro = request.getParameter("logradouro");
        String numLogradouro = request.getParameter("numLogr");
        String comprLogr = request.getParameter("compLogr");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String cep = request.getParameter("cep");
        
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setBairro(bairro);
        fornecedor.setCep(cep);
        fornecedor.setCidade(cidade);
        fornecedor.setCnpj(cnpj);
        fornecedor.setCompLogr(comprLogr);
        fornecedor.setLogradouro(logradouro);
        fornecedor.setNumLogr(numLogradouro);
        fornecedor.setRazaoSocial(razaoSocial);
        fornecedor.setCel(cel);
        fornecedor.setUf(uf);
        try {
            FornecedorDAO.addFornecedor(fornecedor);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }
    }


}
