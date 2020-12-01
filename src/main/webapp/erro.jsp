<%-- 
    Document   : erro
    Created on : 29/10/2020, 05:48:11
    Author     : PICHAU
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro!</title>
    </head>
    <body>
        <h1>Erro!</h1>
        <br/>
        ${msgErro}
        <br/>
        <a href="<c:url value="/protegido/index.jsp"/>"> Voltar</a>
    </body>
</html>
