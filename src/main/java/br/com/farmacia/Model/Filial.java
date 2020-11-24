/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.Model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Felipe Dias Amorim Pessoa
 * @author Ji Hye Koo
 * @author Marcus
 * @author Thyago Rodrigues
 * @author Victor Vilela
 */

@Getter
@Setter
public class Filial {
    private int idFilial;
    private String nomeLoja;
    private String tel;
    private String logradouro;
    private String numLogr;
    private String compLogr;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    
    public Filial (String nomeLoja,
            String tel,
            String logradouro,
            String numLogr,
            String compLogr,
            String bairro,
            String cidade,
            String uf,
            String cep){
        this.nomeLoja = nomeLoja;
        this.tel = tel;
        this.logradouro = logradouro;
        this.numLogr = numLogr;
        this.compLogr = compLogr;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }
    
    public Filial (int idFilial,
            String nomeLoja,
            String tel,
            String logradouro,
            String numLogr,
            String compLogr,
            String bairro,
            String cidade,
            String uf,
            String cep){
        this.idFilial = idFilial;
        this.nomeLoja = nomeLoja;
        this.tel = tel;
        this.logradouro = logradouro;
        this.numLogr = numLogr;
        this.compLogr = compLogr;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }
    
    public Filial (){
    }
    
    @Override
    public String toString() {
        return String.format("nomeFilial %s <br/>"
                + "tel %s <br/>"
                + "logradouro %s <br/>"
                + "numLogr %s <br/>"
                + "compLogr %s <br/>"
                + "bairro %s<br/>"
                + "cidade %s <br/>"
                + "uf %s <br/>"
                + "cep %s <br/> ",
                this.getNomeLoja(),
                this.getTel(),
                this.getLogradouro(),
                this.getNumLogr(),
                this.getCompLogr(),
                this.getBairro(),
                this.getCidade(),
                this.getUf(),
                this.getCep());
    }
}
