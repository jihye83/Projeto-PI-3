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
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletarCliente extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long cpf = Long.parseLong(request.getParameter("cpf"));
       try {
           ClienteDAO.deleteCliente(cpf);
           response.getWriter().print(true);
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(DeletarCliente.class.getName()).log(Level.SEVERE, null, ex);
           response.getWriter().print(false);
       } 
    }
}
