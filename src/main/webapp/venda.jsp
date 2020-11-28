x<%-- 
    Document   : venda
    Created on : 12/11/2020, 21:17:34
    Author     : felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Realizar Venda</title>

    </head>
    <body class="container">
        <h1 class="p-3">Realizar Venda</h1>
        <div class="row">
            <div class="col-4">
                <form action="VendaServlet?action=iniciarVenda" method="post">
            <button type="submit" class="btn btn-primary">Nova Venda</button>
             <a  class="ml-4" href="index.jsp">Voltar</a>
        </form>
            </div>
            <div class="col-8">
                 <form action="VendaServlet?action=cancelarVenda&idVenda=${venda.cod_Venda}" method="post">
                        <button type="submit" class="btn btn-primary" href=""/>Cancelar venda</button>
        </form>
            </div>
        </div>
        
       
        <!-- Finalizar venda  -->
        <form action="VendaServlet?action=finalizarVenda" method="post">
            <div class="row mb-5">
                <div class="col-6">
                    <label class="" for="inlineRadio1">data
                        <input class="form-control" type="text" name="" id="dateToday" value="" readOnly="readOnly">
                    </label>
                </div>
                <div class="row">


                    <div class="col-12">
                        <h2>Cliente:</h2>
                        <select name="idCliente" id="idCliente">
                            <c:forEach items="${clientes}" var="cliente">
                                <option value="${cliente.idCliente}">${cliente.idCliente} - ${cliente.nome}</option>
                            </c:forEach>
                        </select>
                        
                    </div>




                </div>
            </div>
            <div class="row">
                <div class="col">
                    <label class="" for="inlineRadio1">COD
                        <input value="<c:out value="${venda.cod_Venda}" />" readonly name="codVenda" class="form-control" type="text" id="inlineRadio1" readOnly="readOnly">
                    </label>
                </div>
                <div class="col">
                    <p>ValorBruto
                        <input value="<c:out value="${venda.valor_Bruto}" />" class="form-control" type="text" name="valorBruto" id="" readOnly="readOnly">
                    </p>
                </div>
                <div class="col">
                    <label class="">desconto
                        <input value="<c:out value="${venda.desconto}" />" class="form-control" type="text" name="desconto" readOnly="readOnly">
                    </label>
                </div>
                <div class="col">
                    <label class="" for="inlineRadio1">total
                        <input value="<c:out value="${venda.total}" />" class="form-control" type="text" name="total" id="inlineRadio1" readOnly="readOnly">
                    </label>
                </div>

            </div>

            <div class="row">
                <div class="col">
                    <label>Pagamento
                        <select class="form-control" name="pagamento" id="pagamento">
                            <option value="dinheiro">dinheiro</option>
                            <option value="credito">crédito</option>
                            <option value="debito">débito</option>
                        </select>
                    </label>
                    
                   
                </div>
                <div class="col">
                     <button type="submit" class="ml-2 mt-4 btn btn-secondary">Finalizar Venda</button>
                </div>
                <div class="col">
                 
                        
                    
                </div>
                <div class="col">

                </div>
            </div>



            
        </form>


        <!-- add produto --> 
        <form action='VendaServlet?action=addProduto' method='post'>

            <div class="row">

                <div class="col mt-2">
                    <h2>Produto</h2>
                    <select  name="idProduto">
                        <!--                        <option value="">Selecione</option>-->
                        <c:forEach items="${produtos}" var="produto" >
                            <option value="${produto.idProduto}" >${produto.idProduto} - ${produto.nomeProd} </option>
                        </c:forEach>
                    </select>


                </div>

                <div class="col mt-4">
                    <label for="inlineRadio1">Qtd
                        <input class="form-control" type="number"  name="qtdProduto" min="1" value="1"/>
                    </label>
                </div>

                <div class="col mt-4">
                    <button class="btn btn-secondary btnAdd" type="submit">Add produto</button>
                </div>
            </div>



            <div class="container">
                <div class="tableArea mt-3" style=".tableArea{width:100%;}">
                    <h2>Produtos</h2>
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Nome</th>
                                <th scope="col">Preço</th>
                                <th scope="col">Qtd</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach  items="${itemsVenda}" var="item">
                                <tr>
                                    <td>${item.getProduto().getIdProduto()}</td>
                                    <td><c:out value="${item.getProduto().getNomeProd()}" /></td>
                                    <td><c:out value="${item.getProduto().getPrecoProd()}" /></td>
                                    <td><c:out value="${item.getQtd()}" /></td>
                                    <td><a type="button" class="btn btn-primary" href="VendaServlet?action=deleteItem&idItem=${item.getIdItem()}"/>Excluir</a></td>
                                </tr>
                            </c:forEach> 
                        </tbody>                   
                    </table>
                </div>
            </div>

        </form>




        <script>
            //Data
            var data = new Date();
            data = formatDate(data);
            $("#dateToday").val(data);
            function formatDate(props) {
                const date = new Date(props)
                var day = date.getDate();
                if (day < 10) {
                    day = "0" + day
                }
                var month = date.getMonth();
                month++
                if (month < 10) {
                    month = "0" + month
                }
                var year = date.getFullYear();
                return day + "/" + month + "/" + year;
            }

            //Add na tabela
//            function addRow(){
//            $('.btnAdd').preventDefault();
//            $(".table tbody").append(
//                    "<tr>" +
//                    "<td><input type='text'/></td>" +
//                    "<td><input type='text'/></td>" +
//                    "<td><input type='text'/></td>" +
//                    "<td><img src='images/disk.png' class='btnSalvar'>
//            <img src='images/delete.png' class='btnExcluir'/> < /td>"+
//                    "</tr>");
//            $(".btnSalvar").bind("click", Salvar);
//            $(".btnExcluir").bind("click", Excluir);
//            };

        </script>
    </body>
</html>
