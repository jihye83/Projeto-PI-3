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

    private int id_Fornecedor;
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

    public Fornecedor(String razaoSocial, String cnpj, String tel, String logradouro, String numLogr, String comLogr, String bairro, String cidade, String uf, String cep) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.tel = tel;
        this.logradouro = logradouro;
        this.numLogr = numLogr;
        this.compLogr = comLogr;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return String.format("razaoSocial %s <br/> cnpj %s <br/> tel %s <br/> logradouro %s <br/> numLogr %s <br/> compLogr %s <br/> bairro %s <br/> cidade %s <br/> uf %s <br/> cep %s", this.getRazaoSocial(),
                this.getCnpj(), this.getTel(), this.getLogradouro(), this.getNumLogr(), this.getCompLogr(), this.getBairro(), this.getCidade(), this.getUf(), this.getCep());
    }

}
