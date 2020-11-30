<%-- 
    Document   : listaFilial
    Created on : Nov 24, 2020, 7:38:31 PM
    Author     : JHK
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <%@include file="../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar filiais</title>

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
        <h1>Lista de Filiais</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nome Loja</th>
                    <th>Telefone</th>
                    <th>Logradouro</th>
                    <th>Número Logradouro</th>
                    <th>Comp Logradouro</th>
                    <th>Bairro</th>
                    <th>Cidade</th>
                    <th>Uf</th>
                    <th>Cep</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${filiais}" var="filial">
                    <tr>
                        <td><c:out value="${filial.idFilial}" /></td>
                        <td><c:out value="${filial.nomeLoja}" /></td>
                        <td><c:out value="${filial.tel}" /></td>
                        <td><c:out value="${filial.logradouro}" /></td>
                        <td><c:out value="${filial.numLogr}" /></td>
                        <td><c:out value="${filial.compLogr}" /></td>
                        <td><c:out value="${filial.bairro}" /></td>
                        <td><c:out value="${filial.cidade}" /></td>
                        <td><c:out value="${filial.uf}" /></td>
                        <td><c:out value="${filial.cep}" /></td>
                        <td><a class="btn btn-primary " href="FilialServlet?action=edit&filialNomeLoja=<c:out value="${filial.nomeLoja}" />">Update</a></td>
                        <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao('${filial.idFilial}')">Delete</button></td>
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
                    </div>
                </div>
            </div>
        </div>

        <p><a href="FilialServlet?action=insert">Add Filial</a></p>
        <a href="index.jsp">voltar</a>
    </body>
</html>
