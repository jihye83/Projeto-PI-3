<%-- 
    Document   : cadastrarProduto
    Created on : Oct 29, 2020, 2:03:00 PM
    Author     : JHK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produto</title>
    </head>
    <body>
        <h1>Cadastro</h1>
		<form action="CadastrarProduto" method="POST">
			<p>Nome do Produto</p>
			<input name="nome_Prod" type="text" class="form-control" required="true">
			<p>Preço</p>
			<input name="preco_Prod" type="text" class="form-control" required="true">
			<p>Descrição</p>
			<input name="descricao_prod" type="text" class="form-control" required="true">
			<p>Quantidade</p>
			<input name="qtd_Prod" type="text" class="form-control" required="true">

			<button type="submit" type="text" class="btn btn-primary">Enviar</button>
		</form>
    </body>
</html>
