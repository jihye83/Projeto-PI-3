<%-- 
    Document   : listaFuncionario
    Created on : 10/11/2020, 13:54:58
    Author     : trodrsil
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <%@include file="../header.jsp" %>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar funcionários</title>


        <script lang="text/javascript">

            function mostrarModalExclusao(nome, cpf) {
                $("#nome").html(nome);
                $("#cpf").val(cpf);
                $('#modalExclusao').modal('show');
            }

            function excluirFuncionario() {
                var cpf = $("#cpf").val();
                $.get("FuncionarioServlet?action=delete&funcionarioCpf=" + cpf, function (resposta) {
                    $('#modalExclusao').modal('hide');
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
        <h1>Lista de Funcionários</h1>
        <table border=0 class="table">
            <thead>
                <tr>
                    <th>id</th>
                    <th>nome</th>
                    <th>data nascimento</th>
                    <th>cpf</th>
                    <th>cel</th>
                    <th>email</th>
                    <th>salario funcionario</th>
                    <th>data admissao</th>
                    <th>logradouro</th>
                    <th>num Logradouro</th>
                    <th>comp Logradouro</th>
                    <th>bairro</th>
                    <th>cidade</th>
                    <th>uf</th>
                    <th>cep</th>
                    <th>usuario</th>
                    <th>senha</th>
                    <th>perfil funcionario</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${funcionarios}" var="funcionario">
                    <tr>
                        <td><c:out value="${funcionario.idFunc}" /></td>
                        <td><c:out value="${funcionario.nome}" /></td>
                        <td><c:out value="${funcionario.data_Nasc}" /></td>
                        <td><c:out value="${funcionario.cpf}" /></td>
                        <td><c:out value="${funcionario.cel}" /></td>
                        <td><c:out value="${funcionario.email}" /></td>
                        <td><c:out value="${funcionario.salario_Func}" /></td>
                        <td><c:out value="${funcionario.data_Admissao}" /></td>
                        <td><c:out value="${funcionario.logradouro}" /></td>
                        <td><c:out value="${funcionario.numLogr}" /></td>
                        <td><c:out value="${funcionario.compLogr}" /></td>
                        <td><c:out value="${funcionario.bairro}" /></td>
                        <td><c:out value="${funcionario.cidade}" /></td>
                        <td><c:out value="${funcionario.uf}" /></td>
                        <td><c:out value="${funcionario.cep}" /></td>
                        <td><c:out value="${funcionario.usuario}" /></td>
                        <td><c:out value="${funcionario.senha}" /></td>
                        <td><c:out value="${funcionario.perfil_Func}" /></td>

                        <td><a class="btn btn-primary " href="FuncionarioServlet?action=edit&funcionarioCpf=<c:out value="${funcionario.cpf}" />">Update</a></td>
                        <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao('${funcionario.nome}', '${funcionario.cpf}')">Delete</button></td>
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
                        Confirmar exclusão do funcionario  <label id="nome"></label> ?
                        <input id="cpf" hidden="true" />

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-primary" onclick="excluirFuncionario()">
                            <a href="FuncionarioServlet?action=delete&funcionarioCpf=<c:out value="${funcionario.cpf}" />">Confirmar</a>
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <p><a href="FuncionarioServlet?action=insert">Add Funcionario</a></p>
        <a href="index.jsp">voltar</a>

    </body>
</html>