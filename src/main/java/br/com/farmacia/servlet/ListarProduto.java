/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.servlet;

import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.Model.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JHK
 */
public class ListarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Produto> listaProduto = ProdutoDAO.getProdutos();

        request.setAttribute("listaProduto", listaProduto);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher("/listaProduto.jsp");

        requestDispatcher.forward(request, response);
    }
}
