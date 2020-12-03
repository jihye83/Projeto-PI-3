<%-- 
    Document   : cadastrarProduto
    Created on : Oct 29, 2020, 2:03:00 PM
    Author     : JHK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produto</title>
        <link rel="stylesheet" href="./styles/produto.css" />
    </head>

    <body class="container">
        <div class="cadastrarProdutoArea">
            <h1>Cadastro</h1>
            <form action="ProdutoServlet" method="POST">

                <p>Código</p>
                <input value="<c:out value=" ${produto.idProduto}" />" readonly="readonly" name="idProduto" class="form-control" type="number"/><br />

                <p>Nome do Produto</p>
                <input value="<c:out value=" ${produto.nomeProd}" />" name="nomeProd" type="text" class="form-control" required="true">

                <p>Preço</p>
                <input value="<c:out value=" ${produto.precoProd}" />" name="precoProd" type="number" class="form-control" required="true">

                <p>Descrição</p>
                <input value="<c:out value=" ${produto.descricaoProd}" />" name="descricaoProd" type="text" class="form-control" required="true">

                <p>Quantidade</p>
                <input value="<c:out value=" ${produto.qtdProd}" />" name="qtdProd" type="number" class="form-control" required="true">

                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
    </body>
</html>