<%-- 
    Document   : cadastrarCliente
    Created on : 29/10/2020, 05:48:34
    Author     : PICHAU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <%@include file="../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Cliente</title>
        <link rel="stylesheet" href="./styles/cliente.css"/>
    </head>
    <body class="container">
        <div class="cadastrarClienteArea">


            <h1 class="text-center text-danger">Cadastro de Clientes</h1>
            <form action="ClienteServlet" method="POST">
                <div class="row">
                    <div class="col">
                        <p>ID</p>
                        <input value="<c:out value="${cliente.idCliente}" />" readonly="readonly" name="idCliente" class="form-control" type="number"/><br/>

                    </div>
                    <div class="col">
                        <p>Nome</p>
                        <input value="<c:out value="${cliente.nome}" />" name="nome" class="form-control" type="text" required="true"/><br/>

                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <p>CPF</p>
                        <input value="<c:out value="${cliente.cpf}" />" name="cpf" class="form-control" type="text" required="true"/><br/>

                    </div>
                    <div class="col">
                        <p>Email</p>
                        <input value="<c:out value="${cliente.email}" />" name="email" class="form-control" type="text" required="true"/><br/>

                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <p>DDD + Telefone</p>
                        <input value="<c:out value="${cliente.cel}" />" name="cel" class="form-control" type="text" required="true"/><br/>

                    </div>
                    <div class="col">
                        <p>Logradouro</p>
                        <input value="<c:out value="${cliente.logradouro}" />" name="logradouro" class="form-control" type="text" required="true"/><br/>

                    </div>
                </div>
                        
                        <div class="row">
    <div class="col">
      <p>Bairro</p>
                <input value="<c:out value="${cliente.bairro}" />" name="bairro" class="form-control" type="text" required="true"/><br/>
               
    </div>
    <div class="col">
       <p>Cidade</p>
                <input value="<c:out value="${cliente.cidade}" />" name="cidade" class="form-control" type="text" required="true"/><br/>
                
    </div>
  </div>
                        
                        <div class="row">
    <div class="col">
     <p>UF</p>
                <select class="form-control-lg col-4" name="uf">
                    <option value="<c:out value="${cliente.uf}" />">${cliente.uf}</option>
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
                </select>
    </div>
    <div class="col">
        <p>CEP</p>
                <input value="<c:out value="${cliente.cep}" />" name="cep" class="form-control" type="text" required="true"/><br/>
               
    </div>
  </div>
                  
              
               <button type="submit" class="btn btn-primary btn-add-cliente" style="width:250px; margin: 0 auto;">Cadastrar</button>
            </form>
    </body>

</div>
</html>