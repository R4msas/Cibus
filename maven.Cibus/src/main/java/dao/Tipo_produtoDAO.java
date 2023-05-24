package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tipo_produto;

public class Tipo_produtoDAO {
    
    private Connection connection;
    
    public Tipo_produtoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Tipo_produto tipo_produto) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO tipo_produto (nome) VALUES (?)");
        stmt.setString(1, tipo_produto.getNome());
        stmt.execute();
        stmt.close();
    }
    
    public void update(Tipo_produto tipo_produto) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("UPDATE tipo_produto SET nome = ? WHERE id_produto = ?");
        stmt.setString(1, tipo_produto.getNome());
        stmt.setInt(2, tipo_produto.getId_produto());
        stmt.execute();
        stmt.close();
    }
    
    public void delete(Tipo_produto tipo_produto) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM tipo_produto WHERE id_produto = ?");
        stmt.setInt(1, tipo_produto.getId_produto());
        stmt.execute();
        stmt.close();
    }
    
    public Tipo_produto findById(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tipo_produto WHERE id_produto = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        Tipo_produto tipo_produto = null;
        if (rs.next()) {
            tipo_produto = new Tipo_produto();
            tipo_produto.setId_produto(rs.getInt("id_produto"));
            tipo_produto.setNome(rs.getString("nome"));
        }
        
        rs.close();
        stmt.close();
        
        return tipo_produto;
    }
    
    public List<Tipo_produto> findAll() throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tipo_produto");
        ResultSet rs = stmt.executeQuery();
        
        List<Tipo_produto> tipos_produto = new ArrayList<>();
        while (rs.next()) {
            Tipo_produto tipo_produto = new Tipo_produto();
            tipo_produto.setId_produto(rs.getInt("id_produto"));
            tipo_produto.setNome(rs.getString("nome"));
            tipos_produto.add(tipo_produto);
        }
        
        rs.close();
        stmt.close();
        
        return tipos_produto;
    }
    
}