/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote;

import br.com.farmacia.Model.Funcionario;

/**
 *
 * @author PICHAU
 */
public class main {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        String senhaCripto = funcionario.codificarSenha("admin");
        System.out.println("senha " + senhaCripto);
    }
}
