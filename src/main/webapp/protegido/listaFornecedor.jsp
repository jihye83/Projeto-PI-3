
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
      <%@include file="../header.jsp" %>
    <head>
         
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>listar fornecedores</title>
        
        
        <script lang="text/javascript">
            
            function mostrarModalExclusao(cnpj, razao){
                $("#razaoSocial").html(razao);
                $("#cnpj").val(cnpj);
                $('#modalExclusao').modal('show');
            }
            
            function excluirFornecedor() {
                var cnpj = $("#cnpj").val();
                $.get( "FornecedorServlet?action=delete&fornecedorCnpj="+cnpj, function( resposta ) {
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
        <h1>Lista de Fornecedores</h1>
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
                    <td><a class="btn btn-primary " href="FornecedorServlet?action=edit&fornecedorCnpj=<c:out value="${fornecedor.cnpj}" />">Update</a></td>
                    <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao('${fornecedor.cnpj}', '${fornecedor.razaoSocial}')">Delete</button></td>
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