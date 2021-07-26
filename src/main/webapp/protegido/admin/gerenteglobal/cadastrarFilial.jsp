<%-- 
    Document   : cadastrarFilial
    Created on : Nov 24, 2020, 11:13:42 AM
    Author     : JHK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <%@include file="../../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Filial</title>
        <link rel="stylesheet" href="./styles/filial.css"/>
    </head>
    <body class="container">
        <div class="cadastrarFilialArea">

            <div class="form-group">
                <h1><hr>Cadastro de Filial<hr></h1>
                <form action="<c:url value="/FilialServlet"/>" method="POST">

                    <p></p>
                    <input value="<c:out value="${filial.idFilial}" />" readonly="readonly" name="id_Filial" class="form-control-sm" placeholder="ID" type="number"/><br/>

                    <p></p>
                    <div class="form-row">
                        <div class="col">
                            <input value="<c:out value="${filial.nomeLoja}" />" name="nome_Loja" class="form-control" placeholder="Nome" type="text" required="true"/><br/>
                        </div>
                        <div class="col">
                            <input value="<c:out value="${filial.cel}" />" name="cel" class="form-control" placeholder="Telefone" type="text" required="true"/><br/>
                        </div>
                    </div>

                    <input value="<c:out value="${filial.logradouro}" />" name="logradouro" class="form-control" placeholder="Logradouro" type="text" required="true"/><br/>

                    <div class="form-row">
                        <div class="col">
                            <input value="<c:out value="${filial.numLogr}" />" name="numLogr" class="form-control" placeholder="Número" type="text" required="true"/><br/>
                        </div>
                        <div class="col">
                            <input value="<c:out value="${filial.compLogr}" />" name="compLogr" class="form-control" placeholder="Complemento" type="text" required="true"/><br/>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col">
                            <input value="<c:out value="${filial.bairro}" />" name="bairro" class="form-control" placeholder="Bairro" type="text" required="true"/><br/>
                        </div>
                        <div class="col">
                            <input value="<c:out value="${filial.cidade}" />" name="cidade" class="form-control" placeholder="Cidade" type="text" required="true"/><br/>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="col">
                            <select id="inputState" class="form-control" name="uf">
                                <option selected>UF</option>
                                <option value="<c:out value="${filial.uf}" />">${filial.uf}</option>
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
                        </div>
                        <div class="col">                             
                            <input value="<c:out value="${filial.cep}" />" name="cep" class="form-control" placeholder="CEP" type="text" required="true"/><br/>
                        </div>
                    </div>
                    <div class="botao-enviar">
                        <button type="submit" class="btn-enviar" style="width: 250px; margin: 0 auto">Enviar</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
