/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.Servlet;

import br.com.farmacia.DAO.ClienteDAO;
import br.com.farmacia.Model.Cliente;
import br.com.farmacia.Util.Utils;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tscarton
 */
public class AlterarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        Cliente cliente = ClienteDAO.getCliente(cpf);
        request.setAttribute("cliente", cliente);
        RequestDispatcher rd
                = getServletContext().getRequestDispatcher("/alterarCliente.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String cel = request.getParameter("cel");
        String logradouro = request.getParameter("logradouro");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String cep = request.getParameter("cep");
        Cliente cliente = ClienteDAO.getCliente(cpf);
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setCel(cel);
        cliente.setLogradouro(logradouro);
        cliente.setBairro(bairro);
        cliente.setCidade(cidade);
        cliente.setUf(uf);
        cliente.setCep(cep);

        try {
            ClienteDAO.updateCliente(cliente);
            response.sendRedirect("sucesso.jsp");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlterarCliente.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }
    }
}
