<%-- 
    Document   : listaFuncionario
    Created on : 10/11/2020, 13:54:58
    Author     : trodrsil
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <%@include file="../../header.jsp" %>
    <head>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listar funcionários</title>

    <link rel="stylesheet" href="./styles/funcionario.css" />
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
    <div class="listaFuncionarioArea">
        <div class="listaFuncionarioArea">
            <a href="<c:url value=" /FuncionarioServlet?action=insert" />" class="btn-add-funcionario"> Cadastrar
            Funcionario</a>
            <h1 class="text-center text-danger">Funcionários</h1>

            <table class="table tableStyle">
                <thead style="border-bottom: 1px solid black">

                    <th>Id</th>
                    <th>Nome</th>
                    <th>Data Nascimento</th>
                    <th>Cpf</th>
                    <th>Cel</th>
                    <th>Email</th>
                    <th>Salário</th>
                    <th>Data Admissão</th>
                    <th>Logradouro</th>
                    <th>Número</th>
                    <th>Comp.</th>
                    <th>Bairro</th>
                    <th>Cidade</th>
                    <th>Uf</th>
                    <th>Cep</th>

                </thead>
                <tbody>
                    <c:forEach items="${funcionarios}" var="funcionario">
                        <tr>
                            <td>
                                <c:out value="${funcionario.idFunc}" />
                            </td>
                            <td>
                                <c:out value="${funcionario.nome}" />
                            </td>
                            <td>
                                <c:out value="${funcionario.data_Nasc}" />
                            </td>
                            <td>
                                <c:out value="${funcionario.cpf}" />
                            </td>
                            <td>
                                <c:out value="${funcionario.cel}" />
                            </td>
                            <td>
                                <c:out value="${funcionario.email}" />
                            </td>
                            <td>
                                <c:out value="${funcionario.salario_Func}" />
                            </td>
                            <td>
                                <c:out value="${funcionario.data_Admissao}" />
                            </td>
                            <td>
                                <c:out value="${funcionario.logradouro}" />
                            </td>
                            <td>
                                <c:out value="${funcionario.numLogr}" />
                            </td>
                            <td>
                                <c:out value="${funcionario.compLogr}" />
                            </td>
                            <td>
                                <c:out value="${funcionario.bairro}" />
                            </td>
                            <td>
                                <c:out value="${funcionario.cidade}" />
                            </td>
                            <td>
                                <c:out value="${funcionario.uf}" />
                            </td>
                            <td>
                                <c:out value="${funcionario.cep}" />
                            </td>

                            <td><a class="btn btn-primary "
                                    href="FuncionarioServlet?action=edit&funcionarioCpf=<c:out value="
                                    ${funcionario.cpf}" />">
                                <svg width="1.5em" height="1.5em" viewBox="0 0 16 16" class="bi bi-pencil-square"
                                    fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path
                                        d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
                                    <path fill-rule="evenodd"
                                        d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
                                </svg>
                                </a></td>
                            <td><button type="button" class="btn btn-primary btn-excluir"
                                    onclick="mostrarModalExclusao('${funcionario.nome}', '${funcionario.cpf}')">
                                    <svg width="1.5em" height="1.5em" viewBox="0 0 16 16" class="bi bi-trash-fill"
                                        fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                            d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5a.5.5 0 0 0-1 0v7a.5.5 0 0 0 1 0v-7z" />
                                    </svg>
                                </button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="modal fade" id="modalExclusao" tabindex="-1" aria-labelledby="exampleModalLabel"
                aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Confirmar Exclusão</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Confirmar exclusão do funcionario <label id="nome"></label> ?
                            <input id="cpf" hidden="true" />

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button type="button" class="btn btn-primary"
                                onclick="excluirFuncionario()">Confirmar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--        <p><a href="<c:url value="/FuncionarioServlet?action=insert"/>">Add Funcionario</a></p>
            <a href="<c:url value="/protegido/index.jsp"/>">Voltar</a>
-->
</body>

</html>