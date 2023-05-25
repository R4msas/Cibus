package dao;

import java.sql.*;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Oferta;



public class OfertaDAO extends DAO {

    private Connection conn;
	public Object OfertaDAO;

    public OfertaDAO(Connection connection) {
        this.connection = connection;
    }

    public OfertaDAO() {
    	super();
    	connection();
		
	}

	public void insert(Oferta oferta) throws SQLException {
        String sql = "INSERT INTO oferta (id_supermercado, id_produto, preco, descricao) VALUES (?, ?, ?, ?)";
        //connection();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, oferta.getCodSupermercado());
            statement.setInt(2, oferta.getTipoProduto());
            statement.setFloat(3, oferta.getPreco());
            statement.setString(4, oferta.getDescricao());

            statement.executeUpdate();
        }
    }

    public void update(Oferta oferta) throws SQLException {
        String sql = "UPDATE public.oferta SET id_supermercado = ?, id_produto = ?, preco = ?, descricao = ? WHERE id_oferta = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, oferta.getCodSupermercado());
            statement.setInt(2, oferta.getTipoProduto());
            statement.setFloat(3, oferta.getPreco());
            statement.setString(4, oferta.getDescricao());
            statement.setInt(5, oferta.getId_oferta());

            statement.executeUpdate();
        }
    }

    public void delete(Oferta oferta) throws SQLException {
        String sql = "DELETE FROM public.oferta WHERE id_oferta = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, oferta.getId_oferta());

            statement.executeUpdate();
        }
    }

    public Oferta findById(int id) throws SQLException {
        String sql = "SELECT id_oferta, id_supermercado, id_produto, preco, descricao FROM public.oferta WHERE id_oferta = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    Oferta oferta = new Oferta();
                    oferta.setId_oferta(result.getInt("id_oferta"));
                    oferta.setCodSupermercado(result.getInt("id_supermercado"));
                    oferta.setTipoProduto(result.getInt("id_produto"));
                    oferta.setPreco(result.getFloat("preco"));
                    oferta.setDescricao(result.getString("descricao"));

                    return oferta;
                } else {
                    return null;
                }
            }
        }
    }
    
    /*
    
	
	public boolean connection() {
		String driverName = "org.postgresql.Driver";                    
		String serverName = "localhost";
		String mydatabase = "Cibus";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "ti2cc";
		String password = "ti@cc";
		boolean status = false;

		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, username, password);
			status = (connection == null);
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}

		return status;
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			connection.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	fim teste
	*/

    public List<Oferta> findAll() throws SQLException {
        String sql = "SELECT id_oferta, id_supermercado, id_produto, preco, descricao FROM public.oferta";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet result = statement.executeQuery()) {
                List<Oferta> ofertas = new ArrayList<>();

                while (result.next()) {
                    Oferta oferta = new Oferta();
                    oferta.setId_oferta(result.getInt("id_oferta"));
                    oferta.setCodSupermercado(result.getInt("id_supermercado"));
                    oferta.setTipoProduto(result.getInt("id_produto"));
                    oferta.setPreco(result.getFloat("preco"));
                    oferta.setDescricao(result.getString("descricao"));

                    ofertas.add(oferta);
                }
                return ofertas;
                }
            }
        }
    }
