/**
*
* @author Felipe Dias Amorim Pessoa
* @author Ji Hye Koo
* @author Marcus
* @author Thyago Rodrigues
* @author Victor Vilela
*/
package br.com.farmacia.servlet;

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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        
        String nome = request.getParameter("nome");
        Long cpf = Long.parseLong(request.getParameter("cpf"));
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
       
        Date dataNasc = null;
        try {
            dataNasc = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascStr);
        } catch (ParseException e) {
            out.println("Erro de conversão da data");
        }
        Cliente cliente = ClienteDAO.getCliente(cpf);
        cliente.setNome(nome);
        cliente.setDataNasc(dataNasc);
        cliente.setEmail(email);
        cliente.setCel(cel);
        cliente.setLogradouro(logradouro);
        cliente.setNumLogr(numLogr);
        cliente.setCompLogr(compLogr);
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