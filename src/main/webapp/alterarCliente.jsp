<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="header.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Cliente</title>
</head>
<body>
	<h1>Alteração de Cadastro: ${cliente.nome}</h1>
	<form action="AlterarCliente" method="POST">
		<p>Nome</p>
		<input name="nome" value="${cliente.nome}" /><br />
		<p>Email</p>
		<input name="email" value="${cliente.email}" /><br />
		<p>Logradouro</p>
		<input name="logradouro" value="${cliente.logradouro}" /><br />
		<p>Número do Logradouro</p>
		<input name="numLogr" value="${cliente.numLogr}" /><br />
		<p>Complemento</p>
		<input name="compLogr" value="${cliente.compLogr}" /><br />
		<p>CEP</p>
		<input name="cep" value="${cliente.cep}" /><br />
		<p>Bairro</p>
		<input name="bairro" value="${cliente.bairro}" /><br />
		<p>Cidade</p>
		<input name="cidade" value="${cliente.cidade}" /><br />
		<p>UF</p>
		<input name="uf" value="${cliente.uf}" /><br />
		<p>Telefone</p>
		<input name="telefone" value="${cliente.telefone}" /><br />
		<p>Data de Nascimento</p>
		<input name="dataNasc" value="${cliente.dataNasc}" /><br />
		<p>CPF</p>
		<input name="cpf" value="${cliente.cpf}" readonly="true" /><br />

		<button type="submit">Enviar</button>
	</form>
</body>
</html>