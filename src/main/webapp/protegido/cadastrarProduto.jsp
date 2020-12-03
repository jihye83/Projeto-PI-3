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
            <h1 class="text-danger">Cadastro de Produto</h1>
            <form action="ProdutoServlet" method="POST">
                
                 <div class="form-group">
                        <label>Código</label>
                <input class="form-control" value="${produto.idProduto}" readonly="readonly" name="idProduto" class="form-control" type="number"/><br />
 
                 </div>  
                 
                <div class="form-group">
                    <label>Nome</label>
                <input class="form-control" value="<c:out value=" ${produto.nomeProd}" />" name="nomeProd" type="text" class="form-control" required="true">
              
                </div>
                
                <div class="form-group">
                       <label>Descrição</label>
                <input class="form-control" value="<c:out value=" ${produto.descricaoProd}" />" name="descricaoProd" type="text" class="form-control" required="true">

                </div>
               
                <div class="form-group">
                    <label>Preço</label>
                <input class="form-control" value="${produto.precoProd}" name="precoProd" type="number" class="form-control" required="true">
                     
                </div>
                
                <div class="form-group">
                    <label>Quantidade</label>
                <input class="form-control" value="${produto.qtdProd}" name="qtdProd" type="number" class="form-control" required="true">

                </div>
                
               
               
                <button type="submit" class="btn btn-primary btn-add-produto" style="width:250px; margin: 0 auto">Cadastrar</button>
            </form>
        </div>
    </body>
</html>