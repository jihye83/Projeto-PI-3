<%-- 
    Document   : listaCliente
    Created on : 25/10/2020, 12:40:20
    Author     : PICHAU
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
        
        <script lang="text/javascript">
            
            function mostrarModalExclusao(cpf, nome){
                $("#nomeCliente").html(nome);
                $("#cpfCliente").val(cpf);
                $('#modalExclusao').modal('show');
            }
            
            function excluirCliente() {
                var cpf = $("#cpfCliente").val();
                $.get( "ExcluirCliente?cpf="+cpf, function( resposta ) {
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
        <table class="table">
            <thead>
                <th>Nome</th>
                <th>Email</th>
                <th>CPF</th>
            </thead>
            <tbody> 
                <c:forEach var="cliente" items="${listaClientes}">
                    <tr>
                        <td>${cliente.nome}</td>
                        <td>${cliente.email}</td>
                        <td>${cliente.logradouro}</td>
                        <td>${cliente.numLogr}</td>
                        <td>${cliente.compLogr}</td>
                        <td>${cliente.cep}</td>
                        <td>${cliente.bairro}</td>
                        <td>${cliente.cidade}</td>
                        <td>${cliente.uf}</td>
                        <td>${cliente.telefone}</td>
                        <td>${cliente.dataNasc}</td>
                        <td>${cliente.cpf}</td>
                        <td><a href="AlterarCliente?cpf=${cliente.cpf}">Alterar</a></td>
                        <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao(${cliente.cpf}, '${cliente.nome}')">Excluir</button></td>
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
                    Confirmar exclusão do cliente  <label id="nomeCliente"></label> ?
                    <input id="cpfCliente" hidden="true" />
                
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                  <button type="button" class="btn btn-primary" onclick="excluirCliente()">Confirmar</button>
                </div>
              </div>
            </div>
          </div>
        <br/>
        <a href="index.jsp">Voltar</a>
    </body>
</html>
