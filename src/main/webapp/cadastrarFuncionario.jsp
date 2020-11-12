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
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Funcionário</title>
    </head>
    <body>
    <body class="container">
        <h1>Cadastro</h1>
        <form action="FuncionarioServlet" method="POST">

            <p>ID</p>
            <input value="<c:out value="${funcionario.idFunc}" />" readonly="readonly" name="idFunc" class="form-control" type="number"/><br/>

            <p>Nome</p>
            <input value="<c:out value="${funcionario.nome}" />" name="nome" class="form-control" type="text" required="true"/><br/>

            <p>Data de Nascimento</p>
            <input value="<c:out value="${funcionario.data_Nasc}" />" name="data_Nasc" class="form-control" type="text"/><br/>

            <p>CPF</p>
            <input value="<c:out value="${funcionario.cpf}" />" name="cpf" class="form-control" type="text" required="true"/><br/>

            <p>Celular</p>
            <input value="<c:out value="${funcionario.cel}" />" name="cel" class="form-control" type="text" required="true"/><br/>

            <p>E-mail</p>
            <input value="<c:out value="${funcionario.email}" />" name="email" class="form-control" type="text" required="true"/><br/>

            <p>Salário do Funcioário</p>
            <input value="<c:out value="${funcionario.salario_Func}" />" name="salario_Func" class="form-control" type="number"/><br/>

            <p>Data de Admissão</p>
            <input value="<c:out value="${funcionario.data_Admissao}" />" name="data_Admissao" class="form-control" type="text"/><br/>

            <p>Endereço: </p>
            <p>Logradouro</p>
            <input value="<c:out value="${funcionario.logradouro}" />" name="logradouro" class="form-control" type="text" required="true"/><br/>

            <p>Número</p>
            <input value="<c:out value="${funcionario.numLogr}" />" name="numLogr" class="form-control" type="text" required="true"/><br/>

            <p>Complemento</p>
            <input value="<c:out value="${funcionario.compLogr}" />" name="compLogr" class="form-control" type="text" required="true"/><br/>

            <p>Bairro</p>
            <input value="<c:out value="${funcionario.bairro}" />" name="bairro" class="form-control" type="text" required="true"/><br/>

            <p>Cidade</p>
            <input value="<c:out value="${funcionario.cidade}" />" name="cidade" class="form-control" type="text" required="true"/><br/>

            <p>UF</p>
            <select class="form-control-lg col-4" name="uf">
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

            <p>CEP</p>
            <input value="<c:out value="${funcionario.cep}" />" name="cep" class="form-control" type="text" required="true"/><br/>

            <p>Usuario</p>
            <input value="<c:out value="${funcionario.usuario}" />" name="usuario" class="form-control" type="text" required="true"/><br/>

            <p>Senha</p>
            <input value="<c:out value="${funcionario.senha}" />" name="senha" class="form-control" type="text" required="true"/><br/>

            <p>Perfil do Funcionário</p>
            <input value="<c:out value="${funcionario.perfil_Func}" />" name="perfil_Func" class="form-control" type="text" required="true"/><br/>

            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </body>
</body>
</html>