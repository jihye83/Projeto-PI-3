<%-- 
    Document   : listaCliente
    Created on : 29/10/2020, 05:47:35
    Author     : Victor Vilela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <%@include file="../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>

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
        <h1>Lista de Clientes</h1>
        <table border=0 class="table">
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
                    <td><a class="btn btn-primary " href="ClienteServlet?action=edit&clienteCpf=<c:out value="${cliente.cpf}" />">Alterar</a></td>
                    <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao('${cliente.cpf}', '${cliente.nome}')">Delete</button></td>
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
        
    <p><a href="ClienteServlet?action=insert">Add Cliente</a></p>
    <a href="index.jsp">Voltar</a>
</body>
</html>