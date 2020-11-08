/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.Model;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author JHK
 */
@Getter
@Setter
public class Fornecedor {

    private int idFornecedor;
    private String razaoSocial;
    private String cnpj;
    private String tel;
    private String logradouro;
    private String numLogr;
    private String compLogr;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    public Fornecedor(String razaoSocial, 
            String cnpj, 
            String tel, 
            String logradouro, 
            String numLogr, 
            String compLogr, 
            String bairro, 
            String cidade, 
            String uf, 
            String cep) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.tel = tel;
        this.logradouro = logradouro;
        this.numLogr = numLogr;
        this.compLogr = compLogr;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }
    
     public Fornecedor(int idFornecedor,String razaoSocial, 
            String cnpj, 
            String Tel, 
            String logradouro, 
            String numLogr, 
            String compLogr, 
            String bairro, 
            String cidade, 
            String uf, 
            String cep) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.tel = Tel;
        this.logradouro = logradouro;
        this.numLogr = numLogr;
        this.compLogr = compLogr;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.idFornecedor = idFornecedor;
    }
    
    public Fornecedor(){
        
    }

    @Override
    public String toString() {
        return String.format("razaoSocial %s <br/> "
                + "cnpj %s <br/> "
                + "cel %s <br/> "
                + "logradouro %s <br/> "
                + "numLogr %s <br/> "
                + "compLogr %s <br/> "
                + "bairro %s <br/> "
                + "cidade %s <br/> "
                + "uf %s <br/> "
                + "cep %d", 
                this.getRazaoSocial(),
                this.getCnpj(), 
                this.getCel(), 
                this.getLogradouro(), 
                this.getNumLogr(), 
                this.getCompLogr(), 
                this.getBairro(), 
                this.getCidade(), 
                this.getUf(), 
                this.getCep());
    }
}