/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.Model;

/**
 *
 * @author PICHAU
 */
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    
    private String nome;
    private String login;
    private String senha;
    private String perfil;
    
    public boolean isAdmin() {
        return this.perfil.equalsIgnoreCase("admin");
    }
}
