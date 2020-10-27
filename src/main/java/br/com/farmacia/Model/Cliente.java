/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.Model;

/**
 *
 * @author Victor Vilela
 */

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class Cliente {

    private int idCliente;
    private String nome;
    private String email;
    private String logradouro;
    private String numLogr;
    private String compLogr;
    private String cep;
    private String bairro;
    private String cidade;
    private String uf;
    private String telefone;
    private Date dataNasc;
    private long cpf;
    
    public Cliente() {
    	
    }
    
    public Cliente(String nome, String email, String logradouro, String numLogr, String compLogr, String cep, String bairro, String cidade, String uf, String telefone, Date dataNasc, long cpf) {
        this.nome = nome;
        this.email = email;
        this.logradouro = logradouro;
        this.numLogr = numLogr;
        this.compLogr = compLogr;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return String.format("Nome %s <br/> Email %s <br/> CPF %d" , 
                this.getNome(), this.getEmail(), this.getCpf());
    }
}