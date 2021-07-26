<%-- 
    Document   : listaCliente
    Created on : 29/10/2020, 05:47:35
    Author     : Victor Vilela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <%@include file="../../../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
          <link rel="stylesheet" href="./styles/cliente.css"/>
        <script lang="text/javascript">

            function mostrarModalExclusao(cpf, nome) {
                $("#nome").html(nome);
                $("#cpf").val(cpf);
                $('#modalExclusao').modal('show');
            }

            function excluirCliente() {
                var cpf = $("#cpf").val();
                $.get("ClienteServlet?action=delete&clienteCpf=" + cpf, function (resposta) {
                    $('#modalExclusao').modal('hide')
                    if (resposta === "true") {
                        console.log("Feito!");
                    } else {
                        console.log("Ops!");
                    }
                    window.location.reload();
                });
            }
        </script>
    </head>
    <body class="container">
        <div class="listaClienteArea">
            <a href="<c:url value="/ClienteServlet?action=insert"/>" class="btn-add-cliente" >Cadastrar Cliente</a>
       
        <h1 class="text-center text-danger">Clientes</h1>
        <table border=0 class="table tableStyle">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Email</th>
                    <th>DDD + Telefone</th>
                    <th>Logradouro</th>
                    <th>Bairro</th>
                    <th>Cidade</th>
                    <th>UF</th>
                    <th>CEP</th>
                </tr>
            </thead>
            <tbody> 
                <c:forEach var="cliente" items="${clientes}">
                    <tr>
                        <td><c:out value="${cliente.idCliente}" /></td>
                        <td><c:out value="${cliente.nome}" /></td>
                        <td><c:out value="${cliente.cpf}" /></td>
                        <td><c:out value="${cliente.email}" /></td>
                        <td><c:out value="${cliente.cel}" /></td>
                        <td><c:out value="${cliente.logradouro}" /></td>
                        <td><c:out value="${cliente.bairro}" /></td>
                        <td><c:out value="${cliente.cidade}" /></td>
                        <td><c:out value="${cliente.uf}" /></td>
                        <td><c:out value="${cliente.cep}" /></td>
                        <c:if test="${sessionScope.login.admin}">
                            <td><a class="btn btn-primary " href="ClienteServlet?action=edit&clienteCpf=<c:out value="${cliente.cpf}" />">
                                 <svg width="1.5em" height="1.5em" viewBox="0 0 16 16" class="bi bi-pencil-square" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
  <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
</svg>
                                </a></td>
                            <td><button type="button" class="btn btn-primary btn-excluir" onclick="mostrarModalExclusao('${cliente.cpf}', '${cliente.nome}')">
                                 <svg width="1.5em" height="1.5em" viewBox="0 0 16 16" class="bi bi-trash-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5a.5.5 0 0 0-1 0v7a.5.5 0 0 0 1 0v-7z"/>
</svg>
                                </button></td>
                        </c:if>
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
                        Confirmar exclusão do cliente  <label id="nome"></label> ?
                        <input id="cpf" hidden="true" />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-primary" onclick="excluirCliente()">Confirmar</button>
                    </div>
                </div>
            </div>
        </div>

        
         </div>
    </body>
</html>