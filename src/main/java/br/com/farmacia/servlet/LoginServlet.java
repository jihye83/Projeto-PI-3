/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.servlet;

import br.com.farmacia.DAO.FuncionarioDAO;
import br.com.farmacia.Model.Funcionario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PICHAU
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        //query no bd
        
        Funcionario funcionario = FuncionarioDAO.getAcesso(login);
        if (funcionario == null || !funcionario.validarSenha(senha)) {
            response.sendRedirect(request.getContextPath() + "/login.jsp?erro=UserNotFound");
    } else {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("login", funcionario);
            response.sendRedirect(request.getContextPath() + "/protegido/index.jsp");
        }
        
//        HttpSession sessao = request.getSession();
//        sessao.setAttribute("usuario", usuario);
    }
}
