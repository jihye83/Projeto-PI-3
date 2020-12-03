package br.com.farmacia.Model;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lombok.Getter;
import lombok.Setter;

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
    private String login;
    private String senha;
    private String cargo;
    private int idFilial;

    public Funcionario(int idFunc,
            String nome,
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
            String login,
            String senha,
            String cargo) {

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
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;
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
            String login,
            String senha,
            String cargo) {
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
                + "login %s <br/> "
                + "senha %s <br/> "
                + "cargo %s <br/> ",
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
                this.getLogin(),
                this.getSenha(),
                this.getCargo(),
                this.getIdFilial());
    }
    
    public static String codificarSenha(String senha) {
        return BCrypt.withDefaults().hashToString(12, senha.toCharArray());
    }
    
    public boolean validarSenha(String senha) {
        BCrypt.Result response = BCrypt.verifyer().verify(senha.toCharArray(), this.getSenha());
        return response.verified;
    }
    
    public boolean isAdmin() {
        return this.cargo.equalsIgnoreCase("admin");
    }
    
    public boolean isGlobal() {
        return this.cargo.equalsIgnoreCase("global");
    }
    
    public boolean isFilial() {
        return this.cargo.equalsIgnoreCase("filial");
    }
    
    public boolean isVendedor() {
        return this.cargo.equalsIgnoreCase("vendedor");
    }
}