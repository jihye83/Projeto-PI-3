/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.servlet;

import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.Model.Produto;
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
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/ProdutoServlet"})
public class ProdutoServlet extends HttpServlet {
  
      private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/protegido/cadastrarProduto.jsp";
    private static String LIST_PRODUTOS = "/protegido/listaProduto.jsp";
    private static String SUCESSO = "/sucesso.jsp";
     private static String ERROR = "/erro.jsp";
    private ProdutoDAO dao;

    public ProdutoServlet() {
        super();
        dao = new ProdutoDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        
        try {
             if (action.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("idProduto"));
            dao.deleteProduto(id);
            forward = LIST_PRODUTOS;
            request.setAttribute("produtos", dao.getProdutos());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("idProduto"));
            Produto produto = dao.getProduto(id);
            request.setAttribute("produto", produto);
        } else if (action.equalsIgnoreCase("listaProduto")){
            forward = LIST_PRODUTOS;
            request.setAttribute("produtos", dao.getProdutos());
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
        
        Produto produto = new Produto();
        produto.setNomeProd(request.getParameter("nomeProd"));
        produto.setDescricaoProd(request.getParameter("descricaoProd"));
        produto.setPrecoProd(Float.parseFloat(request.getParameter("precoProd")));
        produto.setQtdProd(Integer.parseInt(request.getParameter("qtdProd")));
        
        String idProduto = request.getParameter("idProduto");
       // boolean verificaExistencia = dao.containProduto(produto.getNomeProd());
        
        try {
            if(idProduto == null || idProduto.isEmpty())
        {
            dao.addProduto(produto);
            forward = SUCESSO;
        }
        else
        {
            produto.setIdProduto(Integer.parseInt(idProduto));
            dao.updateProduto(produto);
             forward = SUCESSO;
        }
       
        } catch (Exception e) {
        } finally{
             RequestDispatcher view = request.getRequestDispatcher(forward);
        request.setAttribute("produtos", dao.getProdutos());
        view.forward(request, response);
        }
        
       
    }


}
