/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.servlet;

import br.com.farmacia.DAO.ClienteDAO;
import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.DAO.VendaDAO;
import br.com.farmacia.Model.Venda;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "VendaServlet", urlPatterns = {"/VendaServlet"})
public class VendaServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/cadastrarCliente.jsp";
    private static String LIST_CLIENTE_PRODUTO = "/venda.jsp";
    private static String SUCESSO = "/sucesso.jsp";
    private static String ERROR = "/erro.jsp";
    private ClienteDAO daoCliente;
    private ProdutoDAO daoProduto;

    public VendaServlet() {
        super();
        daoCliente = new ClienteDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        try {
            if (action.equalsIgnoreCase("listaClienteProduto")) {
                forward = LIST_CLIENTE_PRODUTO;
                request.setAttribute("clientes", daoCliente.getClientes());
                request.setAttribute("produtos", daoProduto.getProdutos());
            }
        } catch (Exception e) {
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
  

}
