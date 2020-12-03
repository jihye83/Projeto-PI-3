<%-- 
    Document   : cadastrarFuncionario
    Created on : 10/11/2020, 13:54:41
    Author     : trodrsil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <%@include file="../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Funcionário</title>
        <link rel="stylesheet" href="./styles/funcionario.css"/>
    </head>
    <body class="container">
        <div class="cadastrarFuncionarioArea">

            <div class="form-group">
                <h1><hr>Funcionários<hr></h1>
                <form action="<c:url value="/FuncionarioServlet"/>" method="POST">

                    <p></p>
                    <input value="<c:out value="${funcionario.idFunc}" />" readonly="readonly" name="idFunc" class="form-control-sm" placeholder="ID" type="number"/><br/>

                    <p></p>
                    <input value="<c:out value="${funcionario.nome}" />" name="nome" class="form-control" placeholder="Nome" type="text" required="true"/><br/>

                    <p>Data de Nascimento</p>               
                    <div class="form-row">
                        <div class="col">
                            <input value="<c:out value="${funcionario.data_Nasc}" />" name="data_Nasc" class="form-control" placeholder="Nascimento" type="date"/><br/>
                        </div>
                        <div class="col">
                            <input value="<c:out value="${funcionario.cpf}" />" name="cpf" class="form-control" placeholder="CPF" type="text" required="true"/><br/>
                        </div>
                    </div>

                    <p></p>
                    <div class="form-row">
                        <div class="col">
                            <input value="<c:out value="${funcionario.email}" />" name="email" class="form-control" placeholder="E-mail" type="text" required="true"/><br/>
                        </div>
                        <div class="col">
                            <input value="<c:out value="${funcionario.cel}" />" name="cel" class="form-control" placeholder="Celular" type="text" required="true"/><br/>
                        </div>
                    </div>

                    <p>Data de Admissão</p>                 
                    <div class="form-row">
                        <div class="col">
                            <input value="<c:out value="${funcionario.data_Admissao}" />" name="data_Admissao" class="form-control" type="date"/><br/>
                        </div>
                        <div class="col">
                            <input value="<c:out value="${funcionario.salario_Func}" />" name="salario_Func" class="form-control" placeholder="Salário" type="number"/><br/>
                        </div>
                    </div>    

                    <p>Endereço</p>                
                    <div class="form-row">
                        <div class="col">
                            <input value="<c:out value="${funcionario.logradouro}" />" name="logradouro" class="form-control" placeholder="Logradouro" type="text" required="true"/><br/>
                        </div>
                        <div class="col">
                            <input value="<c:out value="${funcionario.numLogr}" />" name="numLogr" class="form-control" placeholder="Número" type="text" required="true"/><br/>
                        </div>
                    </div>    

                    <div class="form-row">
                        <div class="col">
                            <input value="<c:out value="${funcionario.compLogr}" />" name="compLogr" class="form-control" placeholder="Complemento" type="text" required="true"/><br/>
                        </div>
                        <div class="col">
                            <input value="<c:out value="${funcionario.bairro}" />" name="bairro" class="form-control" placeholder="Bairro" type="text" required="true"/><br/>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col">
                            <input value="<c:out value="${funcionario.cidade}" />" name="cidade" class="form-control" placeholder="Cidade" type="text" required="true"/><br/>
                        </div>
                        <div class="col">
                            <select id="inputState" class="form-control">
                                <option selected>UF</option>
                                <option value="<c:out value="${funcionario.uf}" />">${funcionario.uf}</option>
                                <option value="AC">AC</option>
                                <option value="AL">AL</option>
                                <option value="AP">AP</option>
                                <option value="AM">AM</option>
                                <option value="BA">BA</option>
                                <option value="CE">CE</option>
                                <option value="DF">DF</option>
                                <option value="ES">ES</option>
                                <option value="GO">GO</option>
                                <option value="MA">MA</option>
                                <option value="MT">MT</option>
                                <option value="MS">MS</option>
                                <option value="MG">MG</option>
                                <option value="PA">PA</option>
                                <option value="PB">PB</option>
                                <option value="PR">PR</option>
                                <option value="PE">PE</option>
                                <option value="PI">PI</option>
                                <option value="RJ">RJ</option>
                                <option value="RN">RN</option>
                                <option value="RS">RS</option>
                                <option value="RO">RO</option>
                                <option value="RR">RR</option>
                                <option value="SC">SC</option>
                                <option value="SP">SP</option>
                                <option value="SE">SE</option>
                                <option value="TO">TO</option>
                            </select><br/> 
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col">
                            <input value="<c:out value="${funcionario.cep}" />" name="cep" class="form-control" placeholder="CEP" type="text" required="true"/><br/>
                        </div>
                        <div class="col">
                        </div>
                    </div>

                    <div class="camposLogin">
                        <p></p>
                        <input value="<c:out value="${funcionario.login}" />" name="login" class="form-control" placeholder="Login" type="text" required="true"/><br/>

                        <input value="<c:out value="${funcionario.senha}" />" name="senha" class="form-control" placeholder="Senha" type="password" required="true"/><br/>
                    </div>

                        <select class="form-control col-4" name="cargo">
                            <option>Perfil</option>
                            <option value="<c:out value="${funcionario.cargo}" />" >${funcionario.cargo}</option>
                            <option value="vendedor">Vendedor</option>
                            <option value="filial">Gerente Filial</option>
                            <option value="global">Gerente Global</option>
                        </select><br/>
                        <div class="botao-cadastrar">
                            <button type="submit" class="btn btn-cadastrar" style="width:250px; margin: 0 auto">Cadastrar</button>
                        </div>
                    </form>
            </div>
        </div>
    </body>
</html>