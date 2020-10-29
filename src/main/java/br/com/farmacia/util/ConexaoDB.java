/**
*
* @author Felipe Dias Amorim Pessoa
* @author Ji Hye Koo
* @author Marcus
* @author Thyago Rodrigues
* @author Victor Vilela
*/
package br.com.farmacia.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoDB {

	    public static Connection CONEXAO;
	    static {
	        try {
	            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	            
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(ConexaoDB.class.getName())
	                    .log(Level.SEVERE, null, ex);
	        }
	       
	    }
	    
	    public static Connection conector() 
	            throws ClassNotFoundException, SQLException {
	        String url = "jdbc:mysql://localhost:3306/TADES";
	        String user = "root";
	        String password = "";
	        CONEXAO = DriverManager.getConnection(url, user, password);
	        return CONEXAO;
	    }
	    /**
	     * Método para encerrar a conexão com o banco de dados
	     * @return boolean true = sucesso , false = falha
	     */
	    public static boolean fecharConexao() {
	        boolean retorno = false;
	        try {
	            if (CONEXAO != null) {
	                if (!CONEXAO.isClosed()) {
	                    CONEXAO.close();
	                }
	            }
	            retorno = true;

	        } catch (SQLException e) {
	            retorno = false;
	        }
	        return retorno;
	    }
}