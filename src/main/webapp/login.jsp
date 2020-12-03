<%-- 
    Document   : login
    Created on : 26/11/2020, 21:00:57
    Author     : PICHAU
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="./styles/login.css"/>
    </head>
    <body class="container">
        <div class="loginArea">
            <div class="formArea">
               
                <c:if test="${not empty param.erro}">
                    <div class="alert alert-danger" role="alert">
                        Usuario/Senha inválidos!
                    </div>
                </c:if> 
                <form action="LoginServlet" method="POST">
                     <h3 >Faça seu Acesso:</h3>
                    <div class="form-group">
                        <label class="h3">Usuário</label>
                        <input name="login" required class="form-control" autofocus="autofocus"/>
                    </div>            
                    <div class="form-group">
                        <label>Senha</label>
                        <input type="password" name="senha" required class="form-control"/>
                    </div>
                    <div class="btn-area">
                        <button type="submit" class="btn btn-primary ">Login</button>
                    </div>
                    
                </form>
            </div>
        </div>

    </body>
</html>
