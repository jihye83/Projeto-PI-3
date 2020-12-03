<%-- 
    Document   : listaFilial
    Created on : Nov 24, 2020, 7:38:31 PM
    Author     : JHK
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar filiais</title>
        <link rel="stylesheet" href="./styles/filial.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script lang="text/javascript">

            function mostrarModalExclusao(idFilial, nomeLoja) {
                $("#nomeLoja").html(nomeLoja);
                $("#idFilial").val(idFilial);
                $('#modalExclusao').modal('show');
            }
            function excluirFilial() {
                var idFilial = $("#idFilial").val();
                $.get("FilialServlet?action=delete&idFilial=" + idFilial, function (resposta) {
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
        <div class="listaFilialArea">
            <a href="<c:url value="/FilialServlet?action=insert"/>" class="btn-add-filial"> Cadastrar Filial</a>
            <h1 class="text-center text-danger">Filiais</h1>
            <table class="table tableStyle">
                <thead style="border-bottom: 1px solid black">

                <th>Codigo</th>
                <th>Nome Loja</th>
                <th>Telefone</th>
                <th>Logradouro</th>
                <th>Número</th>
                <th>Comp.</th>
                <th>Bairro</th>
                <th>Cidade</th>
                <th>Uf</th>
                <th>Cep</th>

                </thead>
                <tbody>
                    <c:forEach items="${filiais}" var="filial">
                        <tr>
                            <td><c:out value="${filial.idFilial}" /></td>
                            <td><c:out value="${filial.nomeLoja}" /></td>
                            <td><c:out value="${filial.cel}" /></td>
                            <td><c:out value="${filial.logradouro}" /></td>
                            <td><c:out value="${filial.numLogr}" /></td>
                            <td><c:out value="${filial.compLogr}" /></td>
                            <td><c:out value="${filial.bairro}" /></td>
                            <td><c:out value="${filial.cidade}" /></td>
                            <td><c:out value="${filial.uf}" /></td>
                            <td><c:out value="${filial.cep}" /></td>
                            <td><a class="btn btn-primary " href="FilialServlet?action=edit&filialNomeLoja=<c:out value="${filial.nomeLoja}" />">

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
                            Confirmar exclusão do filial  <label id="id_Filial"></label> ?
                            <input id="idFilial" hidden="true" />

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button type="button" class="btn btn-primary" onclick="excluirFilial()">Confirmar</button>
                                <!--<a href="FilialServlet?action=delete&idFilial=<c:out value="${filial.idFilial}" />">Confirmar</a>-->
                        </div>
                    </div>
                </div>
            </div>
            <!--
                    <p><a href="<c:url value="/FilialServlet?action=insert"/>">Add Filial</a></p>
                    <a href="<c:url value="/protegido/index.jsp"/>">Voltar</a>
            -->
        </div>
    </body>
</html>
