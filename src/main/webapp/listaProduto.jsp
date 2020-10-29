<%-- 
    Document   : listaProdutos
    Created on : Oct 29, 2020, 2:09:53 PM
    Author     : JHK
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produtos</title>
        <script lang="text/javascript">

            function mostrarModalExclusao(id_Produto, nome_Prod) {
                $("#nome_Prod").html(nome_Prod);
                $("#id_Produto").val(id_Produto);
                $('#modalExclusao').modal('show');
            }

            function excluirProduto() {
                var id_Produto = $("#id_Produto").val();
                $.get("ExcluirProduto?id_Produto=" + id_Produto, function (resposta) {
                    $('#modalExclusao').modal('hide')
                    if (resposta === "true") {
                        console.log("Funfou!");
                    } else {
                        console.log("Ops!");
                    }
                    window.location.reload();
                });
            }
        </script>
    </head>
    <body class="container">
        <h1>Lista de Produtos</h1>
        <table class="table">
            <thead>
            <th>Codigo</th>
            <th>Nome</th>
            <th>Preco</th>
            <th>Descricao</th>
            <th>Quantidade</th>
        </thead>
        <tbody> 
            <c:forEach var="produto" items="${listaProduto}">
                <tr>
                    <td>${produto.id_Produto}</td>
                    <td>${produto.nome_Prod}</td>
                    <td>${produto.preco_Prod}</td>
                    <td>${produto.descricao_Prod}</td>
                    <td>${produto.qtd_Prod}</td>
                    <td><a href="AlterarProduto?cpf=${produto.id_Produto}">Alterar</a></td>
                    <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao(${produto.id_Produto}, '${produto.nome_Prod}')">Excluir</button></td>
                </tr>
            </c:forEach>

        </tbody>

    </table>
    <div class="modal fade" id="modalExclusao" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Confirmar Exclusão</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Confirmar exclusão do Produto  <label id="id_Produto"></label> ?
                    <input id="id_Produto" hidden="true" />

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <button type="button" class="btn btn-primary" onclick="excluirProduto()">Confirmar</button>
                </div>
            </div>
        </div>
    </div>
    <br/>
    <a href="index.jsp">Voltar</a>
</body>
</html>
