package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Oferta;
import model.TipoProduto;

public class TipoProdutoDAO  extends DAO  {
    
    private Connection conn;
    
    public TipoProdutoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public TipoProdutoDAO() {
    	super();
    	connect();
		
	}
    
   public void insertTipoProduto(String tipo_produto) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO tipo_produto (nome) VALUES (?)");
        statement.setString(1, tipo_produto);
        System.out.println(statement);
        statement.execute();
        statement.close();
    }
   

    
    public void updateTipoProduto(TipoProduto tipo_produto) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE tipo_produto SET nome = ? WHERE id_produto = ?");
        statement.setString(1, tipo_produto.getNome());
        statement.setInt(2, tipo_produto.getIdProduto());
        statement.execute();
        statement.close();
    }
    
    public void deleteTipoProduto(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM tipo_produto WHERE id_produto = ?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
    }
    
    public TipoProduto findById(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tipo_produto WHERE id_produto = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        TipoProduto tipo_produto = null;
        if (rs.next()) {
            tipo_produto = new TipoProduto();
            tipo_produto.setId_produto(rs.getInt("id_produto"));
            tipo_produto.setNome(rs.getString("nome"));
        }
        
        rs.close();
        stmt.close();
        
        return tipo_produto;
    }
    
    public List<TipoProduto> getAll() throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tipo_produto");
        ResultSet rs = stmt.executeQuery();
        
        List<TipoProduto> tipos_produto = new ArrayList<>();
        while (rs.next()) {
            TipoProduto tipo_produto = new TipoProduto();
            tipo_produto.setId_produto(rs.getInt("id_produto"));
            tipo_produto.setNome(rs.getString("nome"));
            tipos_produto.add(tipo_produto);
        }
        
        rs.close();
        stmt.close();
        return tipos_produto;
        }
    }