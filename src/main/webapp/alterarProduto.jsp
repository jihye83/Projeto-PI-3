<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="header.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Produto</title>
</head>
<body>
	<h1>Alteração de Produto: ${produto.nome}</h1>
	<form action="AlterarProduto" method="POST">
			<p>Nome do Produto</p>
			<input name="nome_Prod" class="form-control" required="true">
			<p>Preço</p>
			<input name="preco_Prod" class="form-control" required="true">
			<p>Descricaoo</p>
			<input name="descricao_prod" class="form-control" required="true">
			<p>Quantidade</p>
			<input name="qtd_Prod" class="form-control" required="true">

			<button type="submit" class="btn btn-primary">Alterar</button>
		</form>
	</body>
</html>