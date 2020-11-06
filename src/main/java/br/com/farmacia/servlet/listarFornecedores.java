/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.servlet;

import br.com.farmacia.DAO.FornecedorDAO;
import br.com.farmacia.Model.Fornecedor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "listarFornecedores", urlPatterns = {"/listarFornecedores"})
public class listarFornecedores extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Fornecedor> listafornecedores = FornecedorDAO.getFornecedores();
        request.setAttribute("listaFornecedores", listafornecedores);
        
         RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/listaFornecedor.jsp");
         requestDispatcher.forward(request, response);
    }

}
