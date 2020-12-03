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
        <link rel="stylesheet" href="./styles/fornecedor.css"/>
    </head>
    <body class="container">
        <div class="cadastrarFornecedorArea">

            <div class="form-group">
                <h1><hr>Cadastro de Fornecedor<hr></h1>
                <form action="FornecedorServlet" method="POST">

                    <p></p>
                    <input value="<c:out value="${fornecedor.idFornecedor}" />" readonly="readonly" name="idFornecedor" class="form-control-sm" placeholder="ID" type="number"/><br/>

                    <p></p>
                    <input value="<c:out value="${fornecedor.razaoSocial}" />" name="razaoSocial" class="form-control" placeholder="Razão Social" type="text" required="true"/><br/>

                    <form>
                        <div class="form-row">
                            <div class="col">
                                <input value="<c:out value="${fornecedor.cnpj}" />" name="cnpj" class="form-control" placeholder="CNPJ" type="text" required="true"/><br/>
                            </div>
                            <div class="col">
                                <input value="<c:out value="${fornecedor.cel}" />" name="cel" class="form-control" placeholder="Telefone" type="text" /><br/>
                            </div>
                        </div>
                    </form>

                    <input value="<c:out value="${fornecedor.logradouro}" />" name="logradouro" class="form-control" placeholder="Logradouro" type="text" required="true"/><br/>

                    <form>
                        <div class="form-row">
                            <div class="col">
                                <input value="<c:out value="${fornecedor.numLogr}" />" name="numLogr" class="form-control" placeholder="Número" type="text" required="true"/><br/>
                            </div>
                            <div class="col">
                                <input value="<c:out value="${fornecedor.compLogr}" />" name="compLogr" class="form-control" placeholder="Complemento" type="text" required="true"/><br/>
                            </div>
                        </div>
                    </form>

                    <form>
                        <div class="form-row">
                            <div class="col">
                                <input value="<c:out value="${fornecedor.bairro}" />" name="bairro" class="form-control" placeholder="Bairro" type="text" required="true"/><br/>
                            </div>
                            <div class="col">
                                <input value="<c:out value="${fornecedor.cidade}" />" name="cidade" class="form-control" placeholder="Cidade" type="text" required="true"/><br/>
                            </div>
                        </div>
                    </form>


                    <form>
                        <div class="form-row">
                            <div class="col">
                                <select id="inputState" class="form-control">
                                    <option selected>UF</option>
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
                                </select>
                            </div>
                            <div class="col">
                                <input value="<c:out value="${fornecedor.cep}" />" name="cep" class="form-control" placeholder="CEP" type="text" required="true"/><br/>
                            </div>
                        </div>
                    </form>
                    <div class="botao-enviar">
                        <button type="submit" class="btn-enviar">Enviar</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>