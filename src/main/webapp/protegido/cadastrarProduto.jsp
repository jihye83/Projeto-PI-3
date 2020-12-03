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


            <div class="form-group">
                <h1><hr>Cadastro de Produto<hr></h1>
                <form action="ProdutoServlet" method="POST">

                    <p></p>
                    <input value="<c:out value="${produto.idProduto}" />" readonly="readonly" name="idProduto" class="form-control-sm" placeholder="ID" type="number"/><br/>

                    <p></p>
                    <input value="<c:out value="${produto.nomeProd}" />" name="nomeProd" class="form-control" placeholder="Nome Produto" type="text" required="true"/><br/>

                    <p></p>
                    <input value="<c:out value="${produto.descricaoProd}" />" name="descricaoProd" class="form-control"  placeholder="Descrição" type="text" required="true"/><br/>

                    <form>
                        <div class="form-row">
                            <div class="col">
                                <input value="<c:out value="${produto.precoProd}" />" name="precoProd" class="form-control" placeholder="Preço" type="number"/><br/>
                            </div>
                            <div class="col">
                                <input class="form-control" value="${produto.qtdProd}" name="qtdProd" type="number" class="form-control" placeholder="Qtd" required="true">
                            </div>
                        </div>
                    </form>

                    <p></p>
                    <button type="submit" class="btn btn-primary btn-add-produto" style="width:250px; margin: 0 auto">Cadastrar</button>
                </form>
            </div>
    </body>
</html>