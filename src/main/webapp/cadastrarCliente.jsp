<%-- 
    Document   : cadastrarCliente
    Created on : 29/10/2020, 05:48:34
    Author     : PICHAU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Cliente</title>
    </head>
    <body class="container">
        <h1>Cadastro</h1>
        <form action="CadastrarCliente" method="POST">
            <p>Nome</p>
            <input name="nome" class="form-control" type="text" required="true"/><br/>
            <p>CPF</p>
            <input name="cpf" class="form-control" type="text" required="true"/><br/>
            <p>Email</p>
            <input name="email" class="form-control" type="text" required="true"/><br/>
            <p>DDD + Telefone</p>
            <input name="cel" class="form-control" type="text" required="true"/><br/>
            <p>Logradouro</p>
            <input name="logradouro" class="form-control" type="text" required="true"/><br/>
            <p>Bairro</p>
            <input name="bairro" class="form-control" type="text" required="true"/><br/>
            <p>Cidade</p>
            <input name="cidade" class="form-control" type="text" required="true"/><br/>
            <p>UF</p>
            <select class="form-control-lg col-4" name="estado">
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
            <input name="cep" class="form-control" type="text" required="true"/><br/>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </body>
</html>