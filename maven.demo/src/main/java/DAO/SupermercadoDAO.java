package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.model.Supermercado;

public class SupermercadoDAO {
    
    private Connection conn;
    
    public SupermercadoDAO(Connection conn) {
        this.conn = conn;
    }
    
    // Método para inserir um novo supermercado no banco de dados
    public void insert(Supermercado supermercado) throws SQLException {
        String sql = "INSERT INTO supermercado (nome, site) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, supermercado.getNome());
            stmt.setString(2, supermercado.getSite());
            stmt.executeUpdate();
        }
    }
    
    // Método para atualizar um supermercado existente no banco de dados
    public void update(Supermercado supermercado) throws SQLException {
        String sql = "UPDATE supermercado SET nome = ?, site = ? WHERE id_supermercado = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, supermercado.getNome());
            stmt.setString(2, supermercado.getSite());
            stmt.setInt(3, supermercado.getId());
            stmt.executeUpdate();
        }
    }
    
    // Método para excluir um supermercado do banco de dados
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM supermercado WHERE id_supermercado = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    
    // Método para buscar um supermercado pelo seu ID no banco de dados
    public Supermercado findById(int id) throws SQLException {
        String sql = "SELECT * FROM supermercado WHERE id_supermercado = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Supermercado(rs.getInt("id_supermercado"), rs.getString("nome"), rs.getString("site"));
                } else {
                    return null;
                }
            }
        }
    }
    
    // Método para buscar todos os supermercados no banco de dados
    public List<Supermercado> findAll() throws SQLException {
        String sql = "SELECT * FROM supermercado";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            List<Supermercado> supermercados = new ArrayList<>();
            while (rs.next()) {
                supermercados.add(new Supermercado(rs.getInt("id_supermercado"), rs.getString("nome"), rs.getString("site")));
            }
            return supermercados;
        }
    }
}
