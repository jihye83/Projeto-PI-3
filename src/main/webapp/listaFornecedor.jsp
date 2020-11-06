<%-- 
    Document   : listaFornecedor
    Created on : 05/11/2020, 21:14:53
    Author     : felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Lista de Fornecedores</title>
        
        <script lang="text/javascript">
            
            function mostrarModalExclusao(cpf, nome){
                $("#razaoSocial").html(nome);
                $("#cnpjFornecedor").val(cpf);
                $('#modalExclusao').modal('show');
            }
            
            function excluirFornecedor() {
                var cpf = $("#cnpjFornecedor").val();
                $.get( "ExcluirFornecedor?cpf="+cpf, function( resposta ) {
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
        <table class="table">
            <thead>
                <th>Razão Social</th>
                <th>Cidade</th>
                <th>CNPJ</th>
            </thead>
            <tbody> 
                <c:forEach var="fornecedor" items="${listaFornecedores}">
                    <tr>
                        <td>${fornecedor.razaoSocial}</td>
                        <td>${fornecedor.cidade}</td>
                        <td>${fornecedor.cnpj}</td>
                        <td><a href="AlterarFornecedor?cpf=${fornecedor.cpf}">Alterar</a></td>
                        <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao(${fornecedor.cnpj} '${fornecedor.razaoSocial}')">Excluir</button></td>
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
                    Confirmar exclusão do fornecedor  <label id="razaoSocialFornecedor"></label> ?
                    <input id="cnpjFornecedor" hidden="true" />
                 
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                  <button type="button" class="btn btn-primary" onclick="excluirFornecedor()">Confirmar</button>
                </div>
              </div>
            </div>
          </div>
        <br/>
        <a href="index.jsp">Voltar</a>
    </body>
</html>
