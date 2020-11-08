/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.servlet;

import br.com.farmacia.DAO.FornecedorDAO;
import br.com.farmacia.Model.Fornecedor;
import br.com.farmacia.Util.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author felipe
 */
@WebServlet(name = "FornecedorServlet", urlPatterns = {"/FornecedorServlet"})
public class FornecedorServlet extends HttpServlet {

      private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/cadastrarFornecedor.jsp";
    private static String LIST_FORNECEDOR = "/listaFornecedor.jsp";
    private FornecedorDAO dao;

    public FornecedorServlet() {
        super();
        dao = new FornecedorDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        
        try {
             if (action.equalsIgnoreCase("delete")){
            String cnpj = request.getParameter("fornecedorCnpj");
            dao.deleteFornecedor(cnpj);
            forward = LIST_FORNECEDOR;
            request.setAttribute("fornecedores", dao.getFornecedores());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            String cnpj = request.getParameter("fornecedorCnpj");
            Fornecedor fornecedor = dao.getFornecedor(cnpj);
            request.setAttribute("fornecedor", fornecedor);
        } else if (action.equalsIgnoreCase("listaFornecedor")){
            forward = LIST_FORNECEDOR;
            request.setAttribute("fornecedores", dao.getFornecedores());
        } else {
            forward = INSERT_OR_EDIT;
        }
        } catch (Exception e) {
        }
       

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setRazaoSocial(request.getParameter("razaoSocial"));
        fornecedor.setCnpj(request.getParameter("cnpj"));
        fornecedor.setCep(request.getParameter("cep"));
        fornecedor.setNumLogr(request.getParameter("numLogr"));
        fornecedor.setCompLogr(request.getParameter("compLogr"));
        fornecedor.setCidade(request.getParameter("cidade"));
        fornecedor.setBairro(request.getParameter("bairro"));
        fornecedor.setTel(request.getParameter("tel"));
        fornecedor.setUf(request.getParameter("uf"));
      
        fornecedor.setLogradouro(request.getParameter("logradouro"));
        String idFornecedor = request.getParameter("idFornecedor");
        boolean verificaExistencia = dao.containFornecedor(fornecedor.getCnpj());
        
        try {
             if(idFornecedor == null || idFornecedor.isEmpty())
        {
            dao.addFornecedor(fornecedor);
        }
        else
        {
            fornecedor.setIdFornecedor(Integer.parseInt(idFornecedor));
            dao.updateFornecedor(fornecedor);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_FORNECEDOR);
        request.setAttribute("fornecedores", dao.getFornecedores());
        view.forward(request, response);
        } catch (Exception e) {
        }
        
       
    }

}
