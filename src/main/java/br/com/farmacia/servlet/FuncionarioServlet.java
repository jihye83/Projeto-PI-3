package br.com.farmacia.servlet;

import br.com.farmacia.DAO.FuncionarioDAO;
import br.com.farmacia.Model.Funcionario;
import java.io.IOException;
import java.util.Date;
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
    private static String SUCESSO = "/sucesso.jsp";
    private static String ERROR = "/erro.jsp";
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
        String forward = "";
        
        //Date data = new Date(request.getParameter("data_Nasc"));
        //Date data2 = new Date(request.getParameter("data_Admissao"));
        
        
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(request.getParameter("nome"));
        funcionario.setData_Nasc(request.getParameter("data_Nasc"));
        //funcionario.setData_Nasc(data);
        funcionario.setCpf(request.getParameter("cpf"));
        funcionario.setCel(request.getParameter("cel"));
        funcionario.setEmail(request.getParameter("email"));
        funcionario.setSalario_Func(Double.parseDouble(request.getParameter("salario_Func")));
        funcionario.setData_Admissao(request.getParameter("data_Admissao"));
        //funcionario.setData_Admissao(data2);
        funcionario.setLogradouro(request.getParameter("logradouro"));
        funcionario.setNumLogr(request.getParameter("numLogr"));
        funcionario.setCompLogr(request.getParameter("compLogr"));
        funcionario.setBairro(request.getParameter("bairro"));
        funcionario.setCidade(request.getParameter("cidade"));
        funcionario.setUf(request.getParameter("uf"));
        funcionario.setCep(request.getParameter("cep"));
        funcionario.setUsuario(request.getParameter("usuario"));
        funcionario.setSenha(request.getParameter("senha"));
        funcionario.setPerfil_Func(request.getParameter("perfil_Func"));

        String idFunc = request.getParameter("idFunc");
        //boolean verificaExistencia = dao.containFuncionario(funcionario.getCpf());

        try {
            if(idFunc == null || idFunc.isEmpty())
        {
            dao.addFuncionario(funcionario);
            forward = SUCESSO;
        }
        else
        {
            funcionario.setIdFunc(Integer.parseInt(idFunc));
            dao.updateFuncionario(funcionario);
             forward = SUCESSO;
        }
       
        } catch (Exception e) {
        } finally{
             RequestDispatcher view = request.getRequestDispatcher(forward);
        request.setAttribute("funcionario", dao.getFuncionario());
        view.forward(request, response);
        }
    }
}
