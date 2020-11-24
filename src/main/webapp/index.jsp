<%-- 
    Document   : index
    Created on : 29/10/2020, 05:45:06
    Author     : PICHAU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>

        <h1>Menu</h1>
        <a href="ClienteServlet?action=listaCliente">Lista Clientes</a><br/>
        <a href="cadastrarCliente.jsp">Cadastrar Clientes</a><br/>
        <a href="ProdutoServlet?action=listaProduto">Listar Produtos</a><br/>
        <a href="cadastrarProduto.jsp">Cadastrar Produtos</a><br>
        <a href="listarVendas.jsp">Listar Vendas</a><br>
        <a href="alterarProduto.jsp">Alterar Produtos</a><br>
        <a href="cadastrarVenda.jsp">Venda</a><br>
        <a href="cadastrarFornecedor.jsp">Cadastrar Fornecedor</a><br>
        <a href="FornecedorServlet?action=listaFornecedor">Listar Fornecedor</a><br>
        <a href="cadastrarFuncionario.jsp">Cadastrar Funcionario</a><br>
        <a href="FuncionarioServlet?action=listaFuncionario">Listar Funcionario</a><br>
        <a href="cadastrarFilial.jsp">Cadastrar Filial</a><br/>
        <a href="VendaServlet?action=listaClienteProduto">vendas</a>
    </body>
</html>
