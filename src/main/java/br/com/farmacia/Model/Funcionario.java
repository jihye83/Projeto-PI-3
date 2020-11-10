package br.com.farmacia.Model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author thyagorodrigues
 */
@Getter
@Setter
public class Funcionario {

    private int idFunc;
    private String nome;
    private String data_Nasc;
    private String cpf;
    private String cel;
    private String email;
    private double salario_Func;
    private String data_Admissao;
    private String logradouro;
    private String numLogr;
    private String compLogr;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String usuario;
    private String senha;
    private String perfil_Func;

    public Funcionario(int idFunc,
            String nome,
            String data_Nasc, //REVER SE É STRING MESMO, PORQUE NO BANCO ESTÁ COMO DATE
            String cpf,
            String cel,
            String email,
            double salario_Func, //Atentar-se para o tipo da variável, que vem como numeric do banco
            String data_Admissao, //REVER SE É STRING MESMO, PORQUE NO BANCO ESTÁ COMO DATE            
            String logradouro,
            String numLogr,
            String compLogr,
            String bairro,
            String cidade,
            String uf,
            String cep,
            String usuario,
            String senha,
            String perfil_Func) {

        this.idFunc = idFunc;
        this.nome = nome;
        this.data_Nasc = data_Nasc;
        this.cpf = cpf;
        this.cel = cel;
        this.email = email;
        this.salario_Func = salario_Func;
        this.data_Admissao = data_Admissao;
        this.logradouro = logradouro;
        this.numLogr = numLogr;
        this.compLogr = compLogr;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.usuario = usuario;
        this.senha = senha;
        this.perfil_Func = perfil_Func;

    }

    public Funcionario(String nome,
            String data_Nasc,
            String cpf,
            String cel,
            String email,
            double salario_Func,
            String data_Admissao,
            String logradouro,
            String numLogr,
            String compLogr,
            String bairro,
            String cidade,
            String uf,
            String cep,
            String usuario,
            String senha,
            String perfil_Func) {
    }

    /*public Funcionario(int idFunc, String nome, String data_Nasc, String cpf, String cel,
            String email, double salario_Func, String data_Admissao, String logradouro,
            String numLogr, String compLogr, String bairro, String cidade, String uf,
            String cep, String usuario, String senha, String perfil_Func) {
    }*/
    public Funcionario() {
    }

    @Override
    public String toString() {
        return String.format("idFunc %s <br/> "
                + "nome %s <br/> "
                + "data_Nasc %s <br/> "
                + "cpf %s <br/> "
                + "cel %s <br/> "
                + "email %s <br/> "
                + "salario_Func %s <br/> "
                + "data_Admissao %s <br/> "
                + "logradouro %s <br/> "
                + "num_Logr %s <br/> "
                + "comp_Logr %s <br/> "
                + "bairro %s <br/> "
                + "cidade %s <br/> "
                + "uf %s <br/> "
                + "cep %s <br/> "
                + "usuario %s <br/> "
                + "senha %s <br/> "
                + "perfil_Func %s <br/> ",
                this.getNome(),
                this.getData_Nasc(),
                this.getCpf(),
                this.getCel(),
                this.getEmail(),
                this.getSalario_Func(),
                this.getData_Admissao(),
                this.getLogradouro(),
                this.getNumLogr(),
                this.getCompLogr(),
                this.getBairro(),
                this.getCidade(),
                this.getUf(),
                this.getCep(),
                this.getUsuario(),
                this.getSenha(),
                this.getPerfil_Func());
    }
}