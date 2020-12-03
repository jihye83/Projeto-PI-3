<%-- 
    Document   : header
    Created on : 29/10/2020, 05:46:20
    Author     : PICHAU
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" href="./icomoon/style.css"/>-->
        <link rel="stylesheet" href="./styles/header.css"/>
    </head>
    <body>
        <div class="headerArea" id="headerArea" >
            <div class="header">
                <div id="menu">
                    <a href="#">
                        <svg width="1.8em" height="1.8em" viewBox="0 0 16 16" style="color:#8d76dd
                             ;" class="bi bi-grid-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M1 2.5A1.5 1.5 0 0 1 2.5 1h3A1.5 1.5 0 0 1 7 2.5v3A1.5 1.5 0 0 1 5.5 7h-3A1.5 1.5 0 0 1 1 5.5v-3zm8 0A1.5 1.5 0 0 1 10.5 1h3A1.5 1.5 0 0 1 15 2.5v3A1.5 1.5 0 0 1 13.5 7h-3A1.5 1.5 0 0 1 9 5.5v-3zm-8 8A1.5 1.5 0 0 1 2.5 9h3A1.5 1.5 0 0 1 7 10.5v3A1.5 1.5 0 0 1 5.5 15h-3A1.5 1.5 0 0 1 1 13.5v-3zm8 0A1.5 1.5 0 0 1 10.5 9h3a1.5 1.5 0 0 1 1.5 1.5v3a1.5 1.5 0 0 1-1.5 1.5h-3A1.5 1.5 0 0 1 9 13.5v-3z"/>
                        </svg>
                    </a>
                </div> 

                <div class="home">
                    <a href="<c:url value="/protegido/index.jsp"/>">
                        <svg width="1.8em" height="1.8em" viewBox="0 0 16 16" class="bi bi-house" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M2 13.5V7h1v6.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V7h1v6.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5zm11-11V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
                        <path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
                        </svg>

                    </a>
                </div>


                <div class="produto">
                    <a href="<c:url value="/ProdutoServlet?action=listaProduto"/>">
                        <svg width="1.8em" height="1.8em" viewBox="0 0 16 16" class="bi bi-box-seam" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M8.186 1.113a.5.5 0 0 0-.372 0L1.846 3.5l2.404.961L10.404 2l-2.218-.887zm3.564 1.426L5.596 5 8 5.961 14.154 3.5l-2.404-.961zm3.25 1.7l-6.5 2.6v7.922l6.5-2.6V4.24zM7.5 14.762V6.838L1 4.239v7.923l6.5 2.6zM7.443.184a1.5 1.5 0 0 1 1.114 0l7.129 2.852A.5.5 0 0 1 16 3.5v8.662a1 1 0 0 1-.629.928l-7.185 2.874a.5.5 0 0 1-.372 0L.63 13.09a1 1 0 0 1-.63-.928V3.5a.5.5 0 0 1 .314-.464L7.443.184z"/>
                        </svg>
                    </a>
                </div>

                <div class="cliente">
                    <a href="<c:url value="/ClienteServlet?action=listaCliente"/>">
                        <svg width="1.8em" height="1.8em" viewBox="0 0 16 16" class="bi bi-people" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M15 14s1 0 1-1-1-4-5-4-5 3-5 4 1 1 1 1h8zm-7.978-1h7.956a.274.274 0 0 0 .014-.002l.008-.002c-.002-.264-.167-1.03-.76-1.72C13.688 10.629 12.718 10 11 10c-1.717 0-2.687.63-3.24 1.276-.593.69-.759 1.457-.76 1.72a1.05 1.05 0 0 0 .022.004zM11 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0zM6.936 9.28a5.88 5.88 0 0 0-1.23-.247A7.35 7.35 0 0 0 5 9c-4 0-5 3-5 4 0 .667.333 1 1 1h4.216A2.238 2.238 0 0 1 5 13c0-1.01.377-2.042 1.09-2.904.243-.294.526-.569.846-.816zM4.92 10c-1.668.02-2.615.64-3.16 1.276C1.163 11.97 1 12.739 1 13h3c0-1.045.323-2.086.92-3zM1.5 5.5a3 3 0 1 1 6 0 3 3 0 0 1-6 0zm3-2a2 2 0 1 0 0 4 2 2 0 0 0 0-4z"/>
                        </svg>
                    </a>
                </div>
                <div class="funcionario">
                    <a href="<c:url value="/FuncionarioServlet?action=listaFuncionario"/>">
                        <svg width="1.8em" height="1.8em" viewBox="0 0 16 16" class="bi bi-file-earmark-person-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M2 2a2 2 0 0 1 2-2h5.293A1 1 0 0 1 10 .293L13.707 4a1 1 0 0 1 .293.707V14a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2zm7.5 1.5v-2l3 3h-2a1 1 0 0 1-1-1zM11 8a3 3 0 1 1-6 0 3 3 0 0 1 6 0zm2 5.755S12 12 8 12s-5 1.755-5 1.755V14a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1v-.245z"/>
                        </svg>
                    </a>
                </div>
                <div class="fornecedor">
                    <a href="<c:url value="/FornecedorServlet?action=listaFornecedor"/>">
                        <svg width="1.8em" height="1.8em" viewBox="0 0 16 16" class="bi bi-bookmark-check-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M4 0a2 2 0 0 0-2 2v13.5a.5.5 0 0 0 .74.439L8 13.069l5.26 2.87A.5.5 0 0 0 14 15.5V2a2 2 0 0 0-2-2H4zm6.854 5.854a.5.5 0 0 0-.708-.708L7.5 7.793 6.354 6.646a.5.5 0 1 0-.708.708l1.5 1.5a.5.5 0 0 0 .708 0l3-3z"/>
                        </svg>  
                    </a>
                </div>
                <div class="relatorio">
                    <a href="<c:url value="/protegido/relatorio.jsp"/>">
                        <svg width="1.8em" height="1.8em" viewBox="0 0 16 16" class="bi bi-easel-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path d="M8.473.337a.5.5 0 0 0-.946 0L6.954 2h2.092L8.473.337zM12.15 11h-1.058l1.435 4.163a.5.5 0 0 0 .946-.326L12.15 11zM8.5 11h-1v2.5a.5.5 0 0 0 1 0V11zm-3.592 0H3.85l-1.323 3.837a.5.5 0 1 0 .946.326L4.908 11zM1 3a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1v7a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V3z"/>
                        </svg>
                    </a>
                </div>
                <div class="filial">
                    <a href="<c:url value="/FilialServlet?action=listaFilial"/>">
                        <svg width="1.8em" height="1.8em" viewBox="0 0 16 16" class="bi bi-building" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M14.763.075A.5.5 0 0 1 15 .5v15a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5V14h-1v1.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V10a.5.5 0 0 1 .342-.474L6 7.64V4.5a.5.5 0 0 1 .276-.447l8-4a.5.5 0 0 1 .487.022zM6 8.694L1 10.36V15h5V8.694zM7 15h2v-1.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 .5.5V15h2V1.309l-7 3.5V15z"/>
                        <path d="M2 11h1v1H2v-1zm2 0h1v1H4v-1zm-2 2h1v1H2v-1zm2 0h1v1H4v-1zm4-4h1v1H8V9zm2 0h1v1h-1V9zm-2 2h1v1H8v-1zm2 0h1v1h-1v-1zm2-2h1v1h-1V9zm0 2h1v1h-1v-1zM8 7h1v1H8V7zm2 0h1v1h-1V7zm2 0h1v1h-1V7zM8 5h1v1H8V5zm2 0h1v1h-1V5zm2 0h1v1h-1V5zm0-2h1v1h-1V3z"/>
                        </svg>
                    </a>
                </div>
                <div class="venda">
                    <a href="<c:url value="/VendaServlet?action=listaClienteProduto"/>">
                        <svg width="1.8em" height="1.8em" viewBox="0 0 16 16" class="bi bi-cart-check" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm7 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"/>
                        <path fill-rule="evenodd" d="M11.354 5.646a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L8 8.293l2.646-2.647a.5.5 0 0 1 .708 0z"/>
                        </svg>
                    </a>
                </div>
                <div class="sair">
                    <a href="<c:url value="/LogoutServlet"/>">
                        <svg width="1.8em" height="1.8em" viewBox="0 0 16 16" class="bi bi-door-open-fill text-danger mt-2" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M1.5 15a.5.5 0 0 0 0 1h13a.5.5 0 0 0 0-1H13V2.5A1.5 1.5 0 0 0 11.5 1H11V.5a.5.5 0 0 0-.57-.495l-7 1A.5.5 0 0 0 3 1.5V15H1.5zM11 2v13h1V2.5a.5.5 0 0 0-.5-.5H11zm-2.5 8c-.276 0-.5-.448-.5-1s.224-1 .5-1 .5.448.5 1-.224 1-.5 1z"/>
                        </svg>
                    </a>
                </div>

            </div>

        </div>

        <script>

            let header = document.querySelector(".header");
            //estados iniciais
            let home = document.querySelector(".home").innerHTML;
            let produto = document.querySelector(".produto").innerHTML;
            let cliente = document.querySelector(".cliente").innerHTML;
            let funcionario = document.querySelector(".funcionario").innerHTML;
            let fornecedor = document.querySelector(".fornecedor").innerHTML;
            let relatorio = document.querySelector(".relatorio").innerHTML;
            let filial = document.querySelector(".filial").innerHTML;
            let venda = document.querySelector(".venda").innerHTML;
            let sair = document.querySelector(".sair").innerHTML;
             let menu = document.querySelector(".headerArea");
            document.getElementById("menu").addEventListener("click", function (e) {
                e.preventDefault();

                //expandir ou recolher
                if (menu.offsetWidth === 100) {
                    header.style.alignItems = "end";
                    menu.style.width = 150 + "px";

                    document.querySelector(".home").innerHTML = "";
                    document.querySelector(".home").innerHTML = home + "<span>Home</span>";
                    document.querySelector(".produto").innerHTML = "";
                    document.querySelector(".produto").innerHTML = produto + "<span>Produto</span>";
                    document.querySelector(".cliente").innerHTML = "";
                    document.querySelector(".cliente").innerHTML = cliente + "<span>Cliente</span>";
                    document.querySelector(".funcionario").innerHTML = "";
                    document.querySelector(".funcionario").innerHTML = funcionario + "<span>Funcionário</span>";
                    document.querySelector(".fornecedor").innerHTML = "";
                    document.querySelector(".fornecedor").innerHTML = fornecedor + "<span>Fornecedor</span>";
                    document.querySelector(".relatorio").innerHTML = "";
                    document.querySelector(".relatorio").innerHTML = relatorio + "<span>Relatório</span>";
                    document.querySelector(".filial").innerHTML = "";
                    document.querySelector(".filial").innerHTML = filial + "<span>Filial</span>";
                    document.querySelector(".venda").innerHTML = "";
                    document.querySelector(".venda").innerHTML = venda + "<span>Venda</span>";
                    document.querySelector(".sair").innerHTML = "";
                    document.querySelector(".sair").innerHTML = sair + "<span>Sair</span>";
                } else if (menu.offsetWidth == 150) {
                    header.style.alignItems = "center";
                    menu.style.width = 100 + "px";

                    document.querySelector(".home").innerHTML = "";
                    document.querySelector(".home").innerHTML = home;
                    document.querySelector(".produto").innerHTML = "";
                    document.querySelector(".produto").innerHTML = produto;
                    document.querySelector(".cliente").innerHTML = "";
                    document.querySelector(".cliente").innerHTML = cliente;
                    document.querySelector(".funcionario").innerHTML = "";
                    document.querySelector(".funcionario").innerHTML = funcionario;
                    document.querySelector(".fornecedor").innerHTML = "";
                    document.querySelector(".fornecedor").innerHTML = fornecedor;
                    document.querySelector(".relatorio").innerHTML = "";
                    document.querySelector(".relatorio").innerHTML = relatorio;
                    document.querySelector(".filial").innerHTML = "";
                    document.querySelector(".filial").innerHTML = filial;
                    document.querySelector(".venda").innerHTML = "";
                    document.querySelector(".venda").innerHTML = venda;
                    document.querySelector(".sair").innerHTML = "";
                    document.querySelector(".sair").innerHTML = sair;
                }

//                console.log(menu.offsetWidth);
            });

        </script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" ></script>
    </body>
</html>
