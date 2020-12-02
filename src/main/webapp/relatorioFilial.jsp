<%-- 
    Document   : relatorioFilial
    Created on : 30/11/2020, 19:51:43
    Author     : lipes
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
       <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório Filial</title>
         <link rel="stylesheet" href="./styles/relatorio.css"/>
    </head>
    <body class="container">
        <div class="relatorioFilialArea">
      
            <h1 class="text-center">Relatório Filial</h1>
            <div class="p-3">
                
                <form  action="RelatorioServlet?action=listaRelatorioFilial" method="post">
                   <label>
                    ID Filial
                    <input value="<c:out value="${idFilial}" />" type="text" name="idFilial" id="idFilial"/>
                </label>
                    <button type="submit" class="btn-primary btn" href="">Pesquisar</button>
                </form>
            </div>
            <div class="listVendasFilial">
                <table class="table w-80 text-center tableStyle" style="margin:0 auto;">
                    <thead>
                    <th>COD</th>
                    <th>Data</th>
                    <th>Desconto</th>
                    <th>Pagamento</th>
                    <th>Total</th>
                    <th>Valor Bruto</th>
                    <th>ID Cliente</th>
                    </thead>
                    <tbody> 
                        <c:forEach  items="${vendasFilial}" var="venda">
                            <tr>
                                <td><c:out value="${venda.cod_Venda}" /></td>
                                <td><c:out value="${venda.data_Venda}" /></td>
                                <td><c:out value="${venda.desconto}" /></td>
                                <td><c:out value="${venda.pagamento}" /></td>
                                <td><c:out value="${venda.total}" /></td>
                                <td><c:out value="${venda.valor_Bruto}" /></td>
                                <td><c:out value="${venda.id_Cliente}" /></td>
                                <td><a href="RelatorioServlet?action=listaItensFilial&idVenda=${venda.cod_Venda}"><button type="button" class="btn btn-primary">Itens</button></a></td>
                            </tr>
                        </c:forEach>

                    </tbody>



                </table>
               

            </div>
            <div class="listItensVendaFilial">
                 <table class="table tableStyle">
                    <thead>
                    <th>ID</th>
                    <th>ID Produto</th>
                    <th>QTD</th>
                    <th>Valor Un</th>
                    </thead>
                    <tbody> 
                        <c:forEach  items="${itensVenda}" var="item">
                            <tr>
                                <td>${item.idItem}</td>
                                <td><c:out value="${item.produto.idProduto}" /></td>
                                <td><c:out value="${item.qtd}" /></td>
                                <td><c:out value="${item.valor}" /></td>
                            </tr>
                        </c:forEach>

                    </tbody>



                </table>
            </div>
        </div>
    </body>
</html>
