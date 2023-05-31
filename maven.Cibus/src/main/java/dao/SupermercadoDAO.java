package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Supermercado;
import model.TipoProduto;

public class SupermercadoDAO  extends DAO  {
    
    private Connection conn;
    
    public SupermercadoDAO(Connection connection) {
        this.connection = connection;
    }
    
    
   public SupermercadoDAO() {

	   conn = null;
	}


//Método para inserir um novo supermercado no banco de dados
    public void insertSupermercado(Supermercado supermercado) throws SQLException {
        String sql = "INSERT INTO supermercado (nome, site) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, supermercado.getNome());
            stmt.setString(2, supermercado.getSite());
            stmt.executeUpdate();
            stmt.close();
        }
    }
   
    
    
    // Método para atualizar um supermercado existente no banco de dados
    public void updateSupermercado(Supermercado supermercado) throws SQLException {
        String sql = "UPDATE supermercado SET nome = ?, site = ? WHERE id_supermercado = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, supermercado.getNome());
            stmt.setString(2, supermercado.getSite());
            stmt.setInt(3, supermercado.getId_supermercado());
            stmt.executeUpdate();
            stmt.close();
        }
    }
    
    // Método para excluir um supermercado do banco de dados
    public void deleteSupermercado(int id) throws SQLException {
        String sql = "DELETE FROM supermercado WHERE id_supermercado = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        }
    }
    
    /* Método para buscar um supermercado pelo seu ID no banco de dados
    public Supermercado findById(int id) throws SQLException {
        String sql = "SELECT * FROM supermercado WHERE id_supermercado = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
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
   */
    
    /* Método para buscar todos os supermercados no banco de dados 
    public List<Supermercado> findAll() throws SQLException {
        String sql = "SELECT * FROM supermercado";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            List<Supermercado> supermercados = new ArrayList<>();
            while (rs.next()) {
                supermercados.add(new Supermercado(rs.getInt("id_supermercado"), rs.getString("nome"), rs.getString("site")));
            }
            return supermercados;
            
}
*/
}
