package br.com.farmacia.servlet;

import br.com.farmacia.DAO.FuncionarioDAO;
import br.com.farmacia.Model.Funcionario;
import br.com.farmacia.Util.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author trodrsil
 */
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/FuncionarioServlet"})
public class FuncionarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/cadastrarFuncionario.jsp";
    private static String LIST_FUNCIONARIO = "/listaFuncionario.jsp";
    private FuncionarioDAO dao;

    public FuncionarioServlet() {
        super();
        dao = new FuncionarioDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        try {
            if (action.equalsIgnoreCase("delete")) {
                String cpf = request.getParameter("funcionarioCpf");
                dao.deleteFuncionario(cpf);
                forward = LIST_FUNCIONARIO;
                request.setAttribute("funcionario", dao.getFuncionario());
            } else if (action.equalsIgnoreCase("edit")) {
                forward = INSERT_OR_EDIT;
                String cpf = request.getParameter("funcionarioCpf");
                Funcionario funcionario = dao.getFuncionario(cpf);
                request.setAttribute("funcionario", funcionario);
            } else if (action.equalsIgnoreCase("listaFuncionario")) {
                forward = LIST_FUNCIONARIO;
                request.setAttribute("funcionario", dao.getFuncionario());
            } else {
                forward = INSERT_OR_EDIT;
            }
        } catch (Exception e) {
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Funcionario funcionario = new Funcionario();

        funcionario.setNome("nome");
        funcionario.setData_Nasc("data_Nasc");
        funcionario.setCpf("cpf");
        funcionario.setCel("cel");
        funcionario.setEmail("email");
        funcionario.setSalario_Func(Double.parseDouble(request.getParameter("salario_Func")));
        funcionario.setData_Admissao("data_Admissao");
        funcionario.setLogradouro("logradouro");
        funcionario.setNumLogr("numLogr");
        funcionario.setCompLogr("compLogr");
        funcionario.setBairro("bairro");
        funcionario.setCidade("cidade");
        funcionario.setUf("uf");
        funcionario.setCep("cep");
        funcionario.setUsuario("usuario");
        funcionario.setSenha("senha");
        funcionario.setPerfil_Func("perfil_Func");

        String idFunc = request.getParameter("idFunc");
        boolean verificaExistencia = dao.containFuncionario(funcionario.getCpf());

        try {
            if (idFunc == null || idFunc.isEmpty()) {
                dao.addFuncionario(funcionario);
            } else {
                funcionario.setIdFunc(Integer.parseInt(idFunc));
                dao.updateFuncionario(funcionario);
            }
            RequestDispatcher view = request.getRequestDispatcher(LIST_FUNCIONARIO);
            request.setAttribute("funcionario", dao.getFuncionario());
            view.forward(request, response);
        } catch (Exception e) {
        }

    }
}
