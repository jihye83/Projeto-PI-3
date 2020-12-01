/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.servlet;

import br.com.farmacia.DAO.FilialDAO;
import br.com.farmacia.Model.Filial;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Felipe Dias Amorim Pessoa
 * @author Ji Hye Koo
 * @author Marcus
 * @author Thyago Rodrigues
 * @author Victor Vilela
 */
@WebServlet(name = "FilialServlet", urlPatterns = {"/FilialServlet"})
public class FilialServlet extends HttpServlet {

    private static final long seralVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/protegido/cadastrarFilial.jsp";
    private static String LIST_FILIAL = "/protegido/listaFilial.jsp";
    private static String SUCESSO = "/sucesso.jsp";
    private static String ERROR = "/erro.jsp";
    private FilialDAO dao;

    public FilialServlet() {
        super();
        dao = new FilialDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        try {
            if (action.equalsIgnoreCase("delete")) {
                String idFilial = request.getParameter("idFilial");
                dao.deleteFilial(idFilial);
                forward = LIST_FILIAL;
                request.setAttribute("filiais", dao.getFilial());
            } else if (action.equalsIgnoreCase("edit")) {
                forward = INSERT_OR_EDIT;
                String nomeLoja = request.getParameter("filialNomeLoja");
                Filial filial = dao.getFilial(nomeLoja);
                request.setAttribute("filial", filial);
            } else if (action.equalsIgnoreCase("listaFilial")) {
                forward = LIST_FILIAL;
                request.setAttribute("filiais", dao.getFilial());
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

        Filial filial = new Filial();
        filial.setNomeLoja(request.getParameter("nome_Loja"));
        filial.setCel(request.getParameter("cel"));
        filial.setLogradouro(request.getParameter("logradouro"));
        filial.setNumLogr(request.getParameter("numLogr"));
        filial.setCompLogr(request.getParameter("compLogr"));
        filial.setBairro(request.getParameter("bairro"));
        filial.setCidade(request.getParameter("cidade"));
        filial.setUf(request.getParameter("uf"));
        filial.setCep(request.getParameter("cep"));

        String idFilial = request.getParameter("id_Filial");
        boolean verificaExistencia = dao.containFilial(filial.getNomeLoja());

        try {
            if (verificaExistencia) {
                forward = ERROR;
            }
            if ((idFilial == null || idFilial.isEmpty()) && !(verificaExistencia)) {
                dao.addFilial(filial);
                forward = SUCESSO;
            } else {
                filial.setIdFilial(Integer.parseInt(idFilial));
                dao.updateFilial(filial);
                forward = SUCESSO;
            }
        } catch (Exception e) {
        } finally {
            RequestDispatcher view = request.getRequestDispatcher(forward);
            request.setAttribute("filiais", dao.getFilial());
            view.forward(request, response);
        }
    }
}

