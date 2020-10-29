/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.farmacia.DAO.VendaDAO;
import br.com.farmacia.Model.Venda;
import br.com.farmacia.Util.Utils;

@WebServlet(name = "CadastrarVenda", urlPatterns = {"/CadastrarVenda"})
public class CadastrarVenda extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codCompra = Integer.parseInt(request.getParameter("cod_compra"));
        Date dataCompra = new Date(request.getParameter("data_compra"));
        Long valorBruto = Long.parseLong(request.getParameter("valor_Bruto"));
        Long desconto = Long.parseLong(request.getParameter("desconto"));
        String pagamento = request.getParameter("pagamento");
        Long total = Long.parseLong(request.getParameter("total"));
        int idCliente = Integer.parseInt(request.getParameter("id_Cliente"));

        Venda venda = new Venda(codCompra, dataCompra, valorBruto, desconto, pagamento, total, idCliente);
        try {
            VendaDAO.adicionaVenda(venda);
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }
    }
}
