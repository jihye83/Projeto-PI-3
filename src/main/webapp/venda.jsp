<%-- 
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
        <title>JSP Page</title>

    </head>
    <body class="container">
        <h1 class="p-3">Realizar Venda</h1>
        <form action="FornecedorServlet" method="POST">
            <div class="row">
                <div class="col">
                    <label class="" for="inlineRadio1">data
                        <input class="form-control" type="text" name="inlineRadioOptions" id="dateToday" value="" disabled>
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <label class="" for="inlineRadio1">COD
                        <input class="form-control" type="text" name="inlineRadioOptions" id="inlineRadio1" value="" disabled>
                    </label>
                </div>
                <div class="col">
                    <label class="" for="inlineRadio3">ValorBruto
                        <input class="form-control" type="text" name="inlineRadioOptions" id="inlineRadio3" value="" disabled>
                    </label>
                </div>
                <div class="col">
                    <label class="" for="inlineRadio1">desconto
                        <input class="form-control" type="number" name="inlineRadioOptions" id="inlineRadio1" value="" disabled>
                    </label>
                </div>
                <div class="col">
                    <label class="" for="inlineRadio1">total
                        <input class="form-control" type="number" name="inlineRadioOptions" id="inlineRadio1" value="" disabled>
                    </label>
                </div>

            </div>

            <div class="row">
                <div class="col">
                    <label>Pagamento
                        <select class="form-control">
                            <option>dinheiro</option>
                            <option>crédito</option>
                            <option>débito</option>
                        </select>
                    </label>
                </div>
                <div class="col">

                </div>
                <div class="col">

                </div>
                <div class="col">

                </div>
            </div>

            <div class="row">
                <div class="col mt-2">
                    <h2>Cliente:</h2>
                    <select>
                        <option value="">Selecione</option>
                        <c:forEach items="${clientes}" var="cliente">
                            <option value="${cliente.idCliente}">${cliente.nome}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col mt-2">
                    <h2>Produto</h2>
                    <select>
                        <option value="">Selecione</option>
                        <c:forEach items="${produtos}" var="produto">
                            <option value="${produto.idProduto}">${produto.nomeProd}</option>
                        </c:forEach>
                    </select>


                </div>

                <div class="col mt-2">
                    <label for="inlineRadio1">Qtd
                        <input class="form-control" type="number"  name="inlineRadioOptions"/>
                    </label>
                </div>

                <div class="col mt-4">
                    <button class="btn btn-secondary">Add produto</button>
                </div>
            </div>




            <div class="productArea mt-3">
                <h2>Produtos</h2>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Qtd</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Dipirona</td>
                            <td>4</td>
                            <td><button class="btn btn-secondary">Remover</button></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </form>


        <script>
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
        </script>
    </body>
</html>
