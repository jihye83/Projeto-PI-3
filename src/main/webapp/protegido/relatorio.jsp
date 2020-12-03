<%-- 
    Document   : relatorio.jsp
    Created on : 30/11/2020, 19:36:42
    Author     : lipes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatórios</title>
        <link rel="stylesheet" href="./styles/relatorio.css"/>
    </head>
    <body class="container">    
        <div class="relatorioArea">
            <h1 class="text-center">Relatórios</h1>
            <br>
            <div class="text-center d-flex justify-content-center mt-4">
                <a href="<c:url value="/RelatorioServlet?action=listaRelatorioGeral"/>">
                    <h2 class="mr-2">Relatório Geral</h2>
                </a>
                <a href="relatorioFilial.jsp">
                    <h2 class="ml-2">Relatório Filial</h2>
                </a>
            </div>
        </div>
    </body>
</html>
