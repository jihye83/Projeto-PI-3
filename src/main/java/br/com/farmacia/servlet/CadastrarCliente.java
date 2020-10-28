/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.servlet;

/**
* @author Victor Felipe Dias Amorim Pessoa
* @author Ji Hye Koo
* @author Marcus
* @author Thyago Rodrigues
* @author Victor Vilela
*///

import br.com.farmacia.DAO.ClienteDAO;
import br.com.farmacia.Model.Cliente;
import br.com.farmacia.util.Utils;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PICHAU
 */
@WebServlet(name = "CadastrarCliente", urlPatterns = {"/CadastrarCliente"})
public class CadastrarCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String cpfStr = request.getParameter("cpf");
        String dataNascStr = request.getParameter("dataNasc");
        String email = request.getParameter("email");
        String cel = request.getParameter("cel");
        String logradouro = request.getParameter("logradouro");
        String numLogr = request.getParameter("numLogr");
        String compLogr = request.getParameter("compLogr");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String cep = request.getParameter("cep");

        Long cpf = Long.parseLong(cpfStr);
        Date dataNasc = null;
        try {
            dataNasc = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascStr);
        } catch (ParseException e) {
            out.println("Erro de conversão da data");
        }

        Cliente cliente = new Cliente(nome, cpf, dataNasc, email, cel, logradouro, numLogr, compLogr, bairro, cidade, uf, cep);

        try {
            ClienteDAO.addCliente(cliente);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }
    }
}