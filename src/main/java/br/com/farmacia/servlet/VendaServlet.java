/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.farmacia.servlet;

import br.com.farmacia.DAO.ClienteDAO;
import br.com.farmacia.DAO.ItemVendaDAO;
import br.com.farmacia.DAO.ProdutoDAO;
import br.com.farmacia.DAO.VendaDAO;
import br.com.farmacia.Model.ItemVenda;
import br.com.farmacia.Model.Produto;
import br.com.farmacia.Model.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
@WebServlet(name = "VendaServlet", urlPatterns = {"/VendaServlet"})
public class VendaServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
    private static String VENDA = "/venda.jsp";
    private static String SUCESSO = "/sucesso.jsp";
    private static String ERROR = "/erro.jsp";
    private ClienteDAO daoCliente;
    private ProdutoDAO daoProduto;
    private ItemVendaDAO daoItem;
    private VendaDAO daoVenda;
    private Venda venda;
     ArrayList<ItemVenda> cart;

    public VendaServlet() {
        super();
        daoCliente = new ClienteDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = VENDA;
        String action = request.getParameter("action");

        try {
            if(action.equalsIgnoreCase("deleteItem")){
                daoItem = new ItemVendaDAO();

                int idItem = Integer.parseInt(request.getParameter("idItem"));
     
                ItemVenda itemRemove = null;
                itemRemove = daoItem.getItemVenda(idItem);
//                 System.out.println(itemRemove+"aqui"+idItem);
                
                //removendo item do carrinho/tabela
                for(int i=0;i<cart.size();i++){
                    if(cart.get(i).getIdItem()==idItem){
                        cart.remove(cart.get(i));
                    }
                }
                   daoItem.deleteItemVenda(idItem);

                  
                //descrementando valores
                float valorBruto = venda.getValor_Bruto()-itemRemove.getProduto().getPrecoProd() ;
                float total = venda.getTotal()-itemRemove.getProduto().getPrecoProd();
                 venda.setValor_Bruto( valorBruto > 0 ? valorBruto : 0);
               venda.setTotal( total > 0 ? total : 0);        
              
           }
               
        } catch (Exception e) {
            System.out.println(e);
           
        }finally{
                  request.setAttribute("venda",venda);
                request.setAttribute("itemsVenda", cart);
              request.setAttribute("clientes", daoCliente.getClientes());
                request.setAttribute("produtos", daoProduto.getProdutos());
                 RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
        }

       
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "/venda.jsp";
        String action = request.getParameter("action");

        try {
             if(action.equalsIgnoreCase("iniciarVenda")){
                 venda = new Venda();
                 daoVenda = new VendaDAO();
                 daoVenda.adicionaVenda(venda);
                 request.setAttribute("venda", venda);
                 cart = new ArrayList<>();
                  
             }
             else if(action.equalsIgnoreCase("addProduto")){
               daoItem = new ItemVendaDAO();
               daoVenda = new VendaDAO();
               int idProduto = Integer.parseInt(request.getParameter("idProduto"));
  
               int qtd = Integer.parseInt(request.getParameter("qtdProduto"));
               Produto produto = ProdutoDAO.getProduto(idProduto);
               
               // criando item venda
               ItemVenda item = new ItemVenda();
               item.setProduto(produto);
               item.setVenda(venda);
               item.setQtd(qtd);
               item.setValor(produto.getPrecoProd());


               //adicionando ao carrinho
               daoItem.addItemVenda(item);
               cart.add(item);              
                   
               //incrementando valores
               venda.setValor_Bruto(venda.getValor_Bruto()+item.getProduto().getPrecoProd());
               venda.setTotal(venda.getTotal()+item.getProduto().getPrecoProd());
                
               
               request.setAttribute("itemsVenda", cart);
               request.setAttribute("venda",venda);      
           }else if(action.equalsIgnoreCase("finalizarVenda")){
//               int idCliente = Integer.parseInt(request.getParameter("idCliente"));

             String idCliente = request.getParameter("idCliente");
                ;
               String pagamento = request.getParameter("pagamento");
               String desconto = request.getParameter("desconto");
                System.out.println("valor do deconto = "+desconto);;
               float total = Float.parseFloat(request.getParameter("total"));
               float valorBruto = Float.parseFloat(request.getParameter("valorBruto"));
               
               //incluindo informacoes na venda
                venda.setId_Cliente(Integer.parseInt(idCliente));
                venda.setPagamento(pagamento);
                venda.setDesconto(Float.parseFloat(desconto));
                venda.setTotal(total);
                venda.setValor_Bruto(valorBruto);
                
                 try {
                      daoVenda.updateVenda(venda);
                 } catch (Exception e) {
                     System.out.println(e);
                 }
               
                
                venda = new Venda();
                cart = new ArrayList<>();
                
                request.setAttribute("venda", venda);
                request.setAttribute("itemVenda", cart);
           }

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"erro aqui");
        } finally {
             request.setAttribute("clientes", daoCliente.getClientes());
                request.setAttribute("produtos", daoProduto.getProdutos());
            RequestDispatcher view = request.getRequestDispatcher(forward);
//            request.setAttribute("funcionarios", dao.getFuncionarios());
            view.forward(request, response);
        }
    }
    
}
