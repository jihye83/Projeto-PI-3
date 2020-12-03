<%-- 
    Document   : listaProdutos
    Created on : Oct 29, 2020, 2:09:53 PM
    Author     : JHK
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produtos</title>
        <link rel="stylesheet" href="./styles/produto.css"/>
        <script lang="text/javascript">

            function mostrarModalExclusao(id_Produto, nome_Prod) {
                $("#nomeProd").html(nome_Prod);
                $("#idProd").val(id_Produto);
                $('#modalExclusao').modal('show');
            }

            function excluirProduto() {
                var id = $("#idProd").val();
                $.get("ProdutoServlet?action=delete&idProduto=" + id, function (resposta) {
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
    <body class="container ">

        <div class="listaProdutoArea">     
            <a href="<c:url value="/ProdutoServlet?action=insert"/>" class="btn-add-produto"> Cadastrar Produto</a>
            <h1 class="text-center text-danger">Produtos</h1>
            <table class="table tableStyle">
                <thead style="border-bottom: 1px solid black">
                <th>Codigo</th>
                <th>Nome</th>
                <th>Preco</th>
                <th>Descricao</th>
                <th>Quantidade</th>
                </thead>
                <tbody> 
                    <c:forEach  items="${produtos}" var="produto">
                        <tr>
                            <td><c:out value="${produto.idProduto}" /></td>
                            <td><c:out value="${produto.nomeProd}" /></td>
                            <td><c:out value="${produto.precoProd}" /></td>
                            <td><c:out value="${produto.descricaoProd}" /></td>
                            <td><c:out value="${produto.qtdProd}" /></td>
                            <td><a class="btn btn-primary" href="ProdutoServlet?action=edit&idProduto=<c:out value="${produto.idProduto}" />">
                                    <svg width="1.5em" height="1.5em" viewBox="0 0 16 16" class="bi bi-pencil-square" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                    <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                                    </svg>
                                </a></td>
                            <td><button type="button" class="btn btn-primary btn-excluir" onclick="mostrarModalExclusao('${produto.idProduto}', '${produto.nomeProd}')">
                                    <svg width="1.5em" height="1.5em" viewBox="0 0 16 16" class="bi bi-trash-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5a.5.5 0 0 0-1 0v7a.5.5 0 0 0 1 0v-7z"/>
                                    </svg>
                                </button></td>
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
                            Confirmar exclusão do Produto  <label id="nomeProd"></label> ?
                            <input id="idProd" hidden="true" />

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button type="button" class="btn btn-primary" onclick="excluirProduto()">Confirmar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>   
        <br/>


    </body>
</html>
