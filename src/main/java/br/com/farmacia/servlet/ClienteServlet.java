/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.servlet;

import br.com.farmacia.DAO.ClienteDAO;
import br.com.farmacia.Model.Cliente;
import java.io.IOException;
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
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/cadastrarCliente.jsp";
    private static String LIST_CLIENTE = "/listaCliente.jsp";
    private static String SUCESSO = "/sucesso.jsp";
    private static String ERROR = "/erro.jsp";
    private ClienteDAO dao;

    public ClienteServlet() {
        super();
        dao = new ClienteDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        try {
            if (action.equalsIgnoreCase("delete")) {
                String cpf = request.getParameter("clienteCpf");
                dao.deleteCliente(cpf);
                forward = LIST_CLIENTE;
                request.setAttribute("clientes", dao.getClientes());
            } else if (action.equalsIgnoreCase("edit")) {
                forward = INSERT_OR_EDIT;
                String cpf = request.getParameter("clienteCpf");
                Cliente cliente = dao.getCliente(cpf);
                request.setAttribute("cliente", cliente);
            } else if (action.equalsIgnoreCase("listaCliente")) {
                forward = LIST_CLIENTE;
                request.setAttribute("clientes", dao.getClientes());
            } else {
                forward = INSERT_OR_EDIT;
            }
        } catch (Exception e) {
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";

        Cliente cliente = new Cliente();
        cliente.setNome(request.getParameter("nome"));
        cliente.setCpf(request.getParameter("cpf"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setCel(request.getParameter("cel"));
        cliente.setLogradouro(request.getParameter("logradouro"));
        cliente.setBairro(request.getParameter("bairro"));
        cliente.setCidade(request.getParameter("cidade"));
        cliente.setUf(request.getParameter("uf"));
        cliente.setCep(request.getParameter("cep"));

        String idCliente = request.getParameter("idCliente");
        boolean verificaExistencia = dao.containCliente(cliente.getCpf());

        try {
            if (verificaExistencia) {
                forward = ERROR;
            }
            if ((idCliente == null || idCliente.isEmpty()) && !(verificaExistencia)) {
                dao.addCliente(cliente);
                forward = SUCESSO;
            } else {
                cliente.setIdCliente(Integer.parseInt(idCliente));
                dao.updateCliente(cliente);
                forward = SUCESSO;
            }

        } catch (Exception e) {
        } finally {
            RequestDispatcher view = request.getRequestDispatcher(forward);
            request.setAttribute("clientes", dao.getClientes());
            view.forward(request, response);
        }

    }

}
