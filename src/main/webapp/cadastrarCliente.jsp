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
            <input name="nome" class="form-control" required="true"/><br/>
            <p>Email</p>
            <input name="email" class="form-control" required="true"/><br/>
            <p>Logradouro</p>
            <input name="logradouro" class="form-control" required="true"/><br/>
            <p>Número</p>
            <input name="numLogr" class="form-control" required="true"/><br/>
            <p>Complemento</p>
            <input name="compLogr" class="form-control" required="true"/><br/>
            <p>CEP</p>
            <input name="cep" class="form-control" required="true"/><br/>
            <p>Bairro</p>
            <input name="bairro" class="form-control" required="true"/><br/>
            <p>Cidade</p>
            <input name="cidade" class="form-control" required="true"/><br/>
            <p>UF</p>
            <input name="uf" class="form-control" required="true"/><br/>
            <p>DDD + Telefone</p>
            <input name="telefone" class="form-control" required="true"/><br/>
            <p>Data de Nascimento</p>
            <input name="dataNasc" class="form-control" required="true"/><br/>
            <p>CPF</p>
            <input name="cpf" class="form-control" required="true"/><br/>

            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </body>
</html>