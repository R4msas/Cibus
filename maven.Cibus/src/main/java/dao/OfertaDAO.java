package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Oferta;

public class OfertaDAO {

    private Connection connection;

    public OfertaDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Oferta oferta) throws SQLException {
        String sql = "INSERT INTO public.oferta (id_supermercado, id_produto, preco, descricao) VALUES (?, ?, ?, ?)";

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