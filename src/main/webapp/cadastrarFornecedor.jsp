<%-- 
    Document   : cadastrarFornecedor
    Created on : 05/11/2020, 20:35:51
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
        <title>Cadastrar Fornecedor</title>
    </head>
    <body>
        <body class="container">
        <h1>Cadastro</h1>
        <form action="FornecedorServlet" method="POST">
            <p>ID</p>
            <input value="<c:out value="${fornecedor.idFornecedor}" />" readonly="readonly" name="idFornecedor" class="form-control" type="number"/><br/>
            <p>Razão Social</p>
            <input value="<c:out value="${fornecedor.razaoSocial}" />" name="razaoSocial" class="form-control" type="text" required="true"/><br/>
            <p>CNPJ</p>
            <input value="<c:out value="${fornecedor.cnpj}" />" name="cnpj" class="form-control" type="text" required="true"/><br/>
            <p>Celular</p>
            <input value="<c:out value="${fornecedor.cel}" />" name="cel" class="form-control" type="text" required="true"/><br/>
            <p>Logradouro</p>
            <input value="<c:out value="${fornecedor.logradouro}" />" name="logradouro" class="form-control" type="text" required="true"/><br/>
            <p>Número Logradouro</p>
            <input value="<c:out value="${fornecedor.numLogr}" />" name="numLogr" class="form-control" type="text" required="true"/><br/>
            <p>Comp Logradouro</p>
            <input value="<c:out value="${fornecedor.compLogr}" />" name="compLogr" class="form-control" type="text" required="true"/><br/>
            <p>Bairro</p>
            <input value="<c:out value="${fornecedor.bairro}" />" name="bairro" class="form-control" type="text" required="true"/><br/>
             <p>Cidade</p>
            <input value="<c:out value="${fornecedor.cidade}" />" name="cidade" class="form-control" type="text" required="true"/><br/>
            <p>UF</p>
            <select class="form-control-lg col-4" name="uf">
                <option value="<c:out value="${fornecedor.uf}" />">${fornecedor.uf}</option>
                <option value="AC">AC</option>
                <option value="AL">AL</option>
                <option value="AP">AP</option>
                <option value="AM">AM</option>
                <option value="BA">BA</option>
                <option value="CE">CE</option>
                <option value="DF">DF</option>
                <option value="ES">ES</option>
                <option value="GO">GO</option>
                <option value="MA">MA</option>
                <option value="MT">MT</option>
                <option value="MS">MS</option>
                <option value="MG">MG</option>
                <option value="PA">PA</option>
                <option value="PB">PB</option>
                <option value="PR">PR</option>
                <option value="PE">PE</option>
                <option value="PI">PI</option>
                <option value="RJ">RJ</option>
                <option value="RN">RN</option>
                <option value="RS">RS</option>
                <option value="RO">RO</option>
                <option value="RR">RR</option>
                <option value="SC">SC</option>
                <option value="SP">SP</option>
                <option value="SE">SE</option>
                <option value="TO">TO</option>
            </select><br/>
            <p>CEP</p>
            <input value="<c:out value="${fornecedor.cep}" />" name="cep" class="form-control" type="text" required="true"/><br/>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </body>
    </body>
</html>