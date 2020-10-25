/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.servlet;

import br.com.farmacia.DAO.ClienteDAO;
import br.com.farmacia.Model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author PICHAU
 */
public class AlterarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long cpf = Long.parseLong(request.getParameter("cpf"));
        Cliente cliente = ClienteDAO.getCliente(cpf);
        request.setAttribute("cliente", cliente);
        RequestDispatcher rd
                = getServletContext().getRequestDispatcher("/alterarCliente.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long cpf = Long.parseLong(request.getParameter("cpf"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String logradouro = request.getParameter("logradouro");
        String numLogr = request.getParameter("numLogr");
        String compLogr = request.getParameter("compLogr");
        String cep = request.getParameter("cep");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String telefone = request.getParameter("telefone");
        String dataNascStr = request.getParameter("dataNasc");
        Date dataNasc = null;
        try {
            dataNasc = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascStr);
        } catch (ParseException e) {
            out.println("Erro de conversão da data");
        }
        Cliente cliente = ClienteDAO.getCliente(cpf);
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setLogradouro(logradouro);
        cliente.setNumLogr(numLogr);
        cliente.setCompLogr(compLogr);
        cliente.setCep(cep);
        cliente.setBairro(bairro);
        cliente.setCidade(cidade);
        cliente.setUf(uf);
        cliente.setTelefone(telefone);
        cliente.setDataNasc(dataNasc);

        try {
            ClienteDAO.updateCliente(cliente);
            response.sendRedirect("sucesso.jsp");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AlterarCliente.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }
    }
}
