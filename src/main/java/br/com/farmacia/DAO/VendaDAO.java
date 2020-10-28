package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.farmacia.Model.Cliente;
import br.com.farmacia.Model.Venda;
import br.com.farmacia.servlet.ServletBD;
import br.com.farmacia.util.ConexaoDB;

/**
*
* @author Felipe Dias Amorim Pessoa
* @author Ji Hye Koo
* @author Marcus
* @author Thyago Rodrigues
* @author Victor Vilela
*///
public class VendaDAO {
	public static List<Venda> getVendas() {
		List<Venda> listaVendas = new ArrayList();
		try {
			Connection con = ConexaoDB.conector();
			String sql = "select * from vendas";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Venda venda= new Venda();
				venda.setCod_Venda(rs.getInt("cod_Compra"));
				venda.setData_Venda(rs.getDate("data_Compra"));
				venda.setValor_Bruto(rs.getFloat("valor_Bruto"));
				venda.setDesconto(rs.getFloat("desconto"));
				venda.setTotal(rs.getFloat("total"));
				venda.setPagamento(rs.getString("pagamento"));
				Cliente cliCompra = new Cliente();
				cliCompra.setIdCliente(rs.getInt("id_Cliente"));
				venda.setId_Cliente(rs.getInt("id_Cliente"));
				listaVendas.add(venda);
			}

		} catch (Exception ex) {
			Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
		}finally {
			ConexaoDB.fecharConexao();
		}
		return listaVendas;
	}

	public static void adicionaVenda(Venda venda) throws SQLException, ClassNotFoundException {
		
		try {
			Connection con = ConexaoDB.conector();
			String sql = "insert into Compra(cod_Compra, data_Compra, valorBruto,desconto,total,id_Cliente,pagamento(?,?,?,?,?,?,?))";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, venda.getCod_Venda());
			pst.setDate(2, new Date(venda.getData_Venda().getTime()));
			pst.setFloat(3, venda.getValor_Bruto());
			pst.setFloat(4, venda.getDesconto());
			pst.setFloat(5, venda.getId_Cliente());
			pst.setInt(6, venda.getId_Cliente());
			pst.setString(7, venda.getPagamento());
			int rs = pst.executeUpdate();
			if(rs>0) {
				System.out.println("inserido na tabela de compras com sucesso!");
			}else {
				System.out.println("erro ao inserir na tabela de compras");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConexaoDB.fecharConexao();
		}
		
	}
	
	public static boolean deletaVenda(int id_Compra) throws SQLException, ClassNotFoundException {
		try {
			Connection con = ConexaoDB.conector();
			String sql = "delete from Compra where id_Compra=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id_Compra);
			int rs = ps.executeUpdate();
			if(rs>0) {
				System.out.println("removido com sucesso");
				return true;
			}else {
				System.out.println("falha ao apagar");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConexaoDB.fecharConexao();
		}
		
		return false;
	}
	
	public static Venda getVenda(int cod_Compra) {
		Venda venda = null;
		try {
			Connection con = ConexaoDB.conector();
			String sql = "select * from Compra where cod_Compra=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cod_Compra);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				venda = new Venda();
				venda.setCod_Venda(rs.getInt("cod_Compra"));
				venda.setTotal(rs.getFloat("total"));
				venda.setDesconto(rs.getFloat("desconto"));
				venda.setValor_Bruto(rs.getInt("valor_Bruto"));
				venda.setData_Venda(rs.getDate("data_Compra"));
				venda.setPagamento(rs.getString("pagamento"));
				rs.getInt("id_Cliente");
			}
		} catch (Exception ex) {
			Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
		}finally {
			ConexaoDB.fecharConexao();
		}	
		return venda;
	}
}
