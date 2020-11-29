<%-- 
    Document   : header
    Created on : 29/10/2020, 05:46:20
    Author     : PICHAU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./icomoon/style.css"/>
        <link rel="stylesheet" href="./styles/header.css"/>
    </head>
    <body>
        <div class="headerArea">
            <div class="header">
                <div>
                     <a>
                    <svg width="1.8em" height="1.8em" viewBox="0 0 16 16" class="bi bi-house" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M2 13.5V7h1v6.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V7h1v6.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5zm11-11V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
                    <path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
                    </svg>
                </a>
                </div>
                
                <div>
                    <a>
                        <svg width="1.8em" height="1.8em" viewBox="0 0 16 16" class="bi bi-box-seam" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M8.186 1.113a.5.5 0 0 0-.372 0L1.846 3.5l2.404.961L10.404 2l-2.218-.887zm3.564 1.426L5.596 5 8 5.961 14.154 3.5l-2.404-.961zm3.25 1.7l-6.5 2.6v7.922l6.5-2.6V4.24zM7.5 14.762V6.838L1 4.239v7.923l6.5 2.6zM7.443.184a1.5 1.5 0 0 1 1.114 0l7.129 2.852A.5.5 0 0 1 16 3.5v8.662a1 1 0 0 1-.629.928l-7.185 2.874a.5.5 0 0 1-.372 0L.63 13.09a1 1 0 0 1-.63-.928V3.5a.5.5 0 0 1 .314-.464L7.443.184z"/>
</svg>
                    </a>
                </div>
               
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
                <a href="FilialServlet?action=listaFilial">Listar Filiais</a><br/>
                <a href="VendaServlet?action=listaClienteProduto">vendas</a>   
            </div>

        </div>

        <!--    <nav class="navbar navbar-expand-sm navbar-dark bg-primary">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar8">
                <span class="navbar-toggler-icon"></span>
            </button>
            <span class="navbar-text">&nbsp;</span>
            <div class="navbar-collapse collapse" id="navbar8">
                <ul class="navbar-nav abs-center-x">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Center</a>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="//codeply.com">Codeply</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                </ul>
            </div>
        </nav>-->

        <script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" ></script>
    </body>
</html>
