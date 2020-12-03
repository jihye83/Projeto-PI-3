
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <%@include file="../../../header.jsp" %>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>listar fornecedores</title>

        <link rel="stylesheet" href="./styles/fornecedor.css"/>        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <script lang="text/javascript">


            function mostrarModalExclusao(cnpj, razao) {
                $("#razaoSocial").html(razao);
                $("#cnpj").val(cnpj);
                $('#modalExclusao').modal('show');
            }

            function excluirFornecedor() {
                var cnpj = $("#cnpj").val();
                $.get("FornecedorServlet?action=delete&fornecedorCnpj=" + cnpj, function (resposta) {
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
        <div class="listaFornecedorArea">

            <h1><hr>ListaFornecedores<hr></h1>

            <table border=0 class="table">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>razao social</th>
                        <th>cnpj</th>
                        <th>cel</th>
                        <th>logradouro</th>
                        <th>num Logradouro</th>
                        <th>comp Logradouro</th>
                        <th>bairro</th>
                        <th>cidade</th>
                        <th>uf</th>
                        <th>cep</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${fornecedores}" var="fornecedor">
                        <tr>
                            <td><c:out value="${fornecedor.idFornecedor}" /></td>
                            <td><c:out value="${fornecedor.razaoSocial}" /></td>
                            <td><c:out value="${fornecedor.cnpj}" /></td>
                            <td><c:out value="${fornecedor.cel}" /></td>
                            <td><c:out value="${fornecedor.logradouro}" /></td>
                            <td><c:out value="${fornecedor.numLogr}" /></td>
                            <td><c:out value="${fornecedor.compLogr}" /></td>
                            <td><c:out value="${fornecedor.bairro}" /></td>
                            <td><c:out value="${fornecedor.cidade}" /></td>
                            <td><c:out value="${fornecedor.uf}" /></td>
                            <td><c:out value="${fornecedor.cep}" /></td>
                            <td>
                                <div class="btn-altera-fornecedor">
                                    <a href="FornecedorServlet?action=edit&fornecedorCnpj=<c:out value="${fornecedor.cnpj}" />">
                                        <svg width="3em" height="2em" viewBox="0 0 16 16" class="bi bi-pencil-square" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                            <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                            <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                                        </svg>
                                    </a>
                                </div>
                            </td>
                            <!--
                            **************************************************************************************************************************
                            **************************************************************************************************************************
                            -->
                            <td></td>

                            <td>

                                    <a  type="button" class="btn deleta-fornecedor1" onclick="mostrarModalExclusao('${fornecedor.cnpj}', '${fornecedor.razaoSocial}')">
                                        <svg width="3em" height="2em" viewBox="0 0 16 16" class="bi bi-trash" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                            <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                            <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                        </svg>

                                    </a>
                                </div>
                            </td>

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
                            Confirmar exclusão do fornecedor  <label id="razaoSocial"></label> ?
                            <input id="cnpj" hidden="true" />

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button type="button" class="btn btn-primary" onclick="excluirFornecedor()">Confirmar</button>
                        </div>
                    </div>
                </div>
            </div>

            <p><a href="<c:url value="/FornecedorServlet?action=insert"/>">Add Fornecedor</a></p>
            <a href="<c:url value="/protegido/index.jsp"/>">Voltar</a>

    </body>
</html>