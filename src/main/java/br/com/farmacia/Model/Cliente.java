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
/**
 *
 * @author Felipe Dias Amorim Pessoa
 * @author Ji Hye Koo
 * @author Marcus
 * @author Thyago Rodrigues
 * @author Victor Vilela
 */
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {

    private int idCliente;
    private String nome;
    private String cpf;
    private String email;
    private String cel;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    public Cliente(int idCliente, 
            String nome, 
            String cpf, 
            String email, 
            String cel, 
            String logradouro, 
            String bairro, 
            String cidade, 
            String uf, 
            String cep) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.cel = cel;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public Cliente() {
    }

    public Cliente(String nome, 
            String cpf, 
            String email, 
            String cel, 
            String logradouro, 
            String bairro, 
            String cidade, 
            String uf, 
            String cep) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.cel = cel;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return String.format("Nome %s <br/> "
                + "cpf %s <br/> "
                + "Email %s <br/> "
                + "cel %s <br/> "
                + "logradouro %s <br/> "
                + "bairro %s <br/> "
                + "cidade %s <br/> "
                + "uf %s <br/> "
                + "cep %s", 
                this.getNome(),
                this.getCpf(),
                this.getEmail(),
                this.getCel(),
                this.getLogradouro(),
                this.getBairro(),
                this.getCidade(),
                this.getUf(),
                this.getCep());
    
    }

}
