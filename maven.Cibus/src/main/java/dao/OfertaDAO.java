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
    	connect();
		
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

   /* 
    public void update(Oferta oferta) throws SQLException {
        String sql = "UPDATE oferta SET id_supermercado = ?, id_produto = ?, preco = ?, descricao = ? WHERE id_oferta = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, oferta.getCodSupermercado());
            statement.setInt(2, oferta.getTipoProduto());
            statement.setFloat(3, oferta.getPreco());
            statement.setString(4, oferta.getDescricao());
            statement.setInt(5, oferta.getId_oferta());

            statement.executeUpdate();
        }
    }*/

    /*public void delete(Oferta oferta) throws SQLException {
        String sql = "DELETE FROM oferta WHERE id_oferta = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, oferta.getId_oferta());

            statement.executeUpdate();
        }
    }*/

  /*  public Oferta findById(int id) throws SQLException {
        String sql = "SELECT id_oferta, id_supermercado, id_produto, preco, descricao FROM oferta WHERE id_oferta = ?";

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
    }*/
    //esta função busca todas as ofertas do banco e retorna uma lista de ofertas
    public List<Oferta> getAll() throws SQLException {
        String sql = "SELECT id_oferta, id_supermercado, id_produto, preco, descricao FROM oferta";

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
    //esta função recebe a id_produto e uma string de pesquisa e retorna uma lista de ofertas que sigam esta consulta SQL
    public List<Oferta> getPorTipo(int id, String pesquisa) throws SQLException {
        String sql = "SELECT id_oferta, id_supermercado, id_produto, preco, descricao FROM oferta WHERE id_produto =? AND DESCRICAO ILIKE ? ";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2,"%"+pesquisa+"%");
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
    //busca na tabela de ofertas uma string, caso tenha, retorna uma lista de ofertas
        public List<Oferta> getPesquisaOferta(String pesquisa) throws SQLException {
            String sql = "SELECT id_oferta, id_supermercado, id_produto, preco, descricao FROM oferta WHERE DESCRICAO ILIKE ? ";
            
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1,"%"+pesquisa+"%");
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
    }}
