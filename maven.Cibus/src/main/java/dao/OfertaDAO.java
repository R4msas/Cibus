package dao;

import model.Oferta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class OfertaDAO extends DAO {	
	public OfertaDAO() {
		super();
		conectar();
	}
	
	
	public void finalize() {
		close();
	}
	
	
	public boolean insert(Oferta ofertas) {
		boolean status = false;
		try {
			String sql = "INSERT INTO ofertas (descricao, preco, codSupermercado, tipoProduto) "
		               + "VALUES ('" + ofertas.getDescricao() + "', "
		               + ofertas.getPreco() + ", " + ofertas.getCodSupermercado() + ", " + ofertas.getTipoProduto() + ", ?, ?);";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public List<Oferta> get() {
		return get("");
	}

	
	public List<Oferta> getOrderByID() {
		return get("id");		
	}
	
	
	public List<Oferta> getOrderByDescricao() {
		return get("descricao");		
	}
	
	
	public List<Oferta> getOrderByPreco() {
		return get("preco");		
	}
	
	
	private List<Oferta> get(String orderBy) {
		List<Oferta> produtos = new ArrayList<Oferta>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM ofertas" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Oferta p = new Oferta(rs.getInt("id"), rs.getString("descricao"), (float)rs.getDouble("preco"), 
	        			                rs.getInt("quantidade"),
	        			                rs.getTimestamp("datafabricacao").toLocalDateTime(),
	        			                rs.getDate("datavalidade").toLocalDate());
	            produtos.add(p);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produtos;
	}
	
	
	public boolean update(Oferta ofertas) {
		boolean status = false;
		try {  
			String sql = "UPDATE produto SET descricao = '" + ofertas.getDescricao() + "', "
					   + "preco = " + ofertas.getPreco() + ", " 
					   + "quantidade = " + ofertas.getQuantidade() + ","
					   + "datafabricacao = ?, " 
					   + "datavalidade = ? WHERE id = " + ofertas.getID();
			PreparedStatement st = conexao.prepareStatement(sql);
		    st.setTimestamp(1, Timestamp.valueOf(ofertas.getDataFabricacao()));
			st.setDate(2, Date.valueOf(ofertas.getDataValidade()));
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public boolean delete(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM ofertas WHERE id = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
}