/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.servlet;

import br.com.farmacia.DAO.ItemVendaDAO;
import br.com.farmacia.DAO.VendaDAO;
import br.com.farmacia.Model.ItemVenda;
import br.com.farmacia.Model.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lipes
 */
public class RelatorioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String RELATORIO_GERAL = "/relatorioGeral.jsp";
    private static String RELATORIO_FILIAL = "/relatorioFilial.jsp";
    private static int IDFILIAL;
    private VendaDAO dao;
    private ItemVendaDAO daoItem;

    ;

    public RelatorioServlet() {
        super();
        dao = new VendaDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        try {
            if (action.equalsIgnoreCase("listaRelatorioGeral")) {
                forward = RELATORIO_GERAL;
                List<Venda> vendasGeral = dao.getVendas();

                request.setAttribute("vendasGeral", vendasGeral);
            } else if (action.equalsIgnoreCase("listaItens")) {
                forward = RELATORIO_GERAL;
                daoItem = new ItemVendaDAO();
                int idVenda = Integer.parseInt(request.getParameter("idVenda"));
                List<ItemVenda> itens = daoItem.getItensVenda(idVenda);

                List<Venda> vendasGeral = dao.getVendas();

                request.setAttribute("vendasGeral", vendasGeral);
                request.setAttribute("itensVenda", itens);
            }
             else if (action.equalsIgnoreCase("listaItensFilial")) {
                forward = RELATORIO_FILIAL;
                daoItem = new ItemVendaDAO();
                int idVenda = Integer.parseInt(request.getParameter("idVenda"));
                 List<ItemVenda> itens = daoItem.getItensVenda(idVenda);
                 List<Venda> vendasFilial = dao.getVendasFilial(IDFILIAL);

                request.setAttribute("vendasFilial", vendasFilial);

                request.setAttribute("vendasFilial", vendasFilial);
                request.setAttribute("itensVenda", itens);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        try {
            if (action.equalsIgnoreCase("listaRelatorioFilial")) {
                forward = RELATORIO_FILIAL;
                IDFILIAL = Integer.parseInt(request.getParameter("idFilial"));
                System.out.println(IDFILIAL);
                List<Venda> vendasFilial = dao.getVendasFilial(IDFILIAL);

                request.setAttribute("vendasFilial", vendasFilial);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {

            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        }
    }

}
