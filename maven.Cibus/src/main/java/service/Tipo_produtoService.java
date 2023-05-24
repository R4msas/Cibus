package service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.json.JSONArray;

import dao.TipoProdutoDAO;
import model.TipoProduto;
import spark.Request;
import spark.Response;
import java.util.Random;
import javax.servlet.*;

public class TipoProdutoService {
    private TipoProduto tipoProdutoDAO;

    public TipoProdutoService() {
        this.tipoProdutoDAO = new TipoProdutoDAO();
    }

    public Object add(Request request, Response response) throws URISyntaxException {

        tipoProdutoDAO.connect();

        int id_produto = Integer.parseInt(request.queryParams("id_produto"));

        String nome = request.queryParams("nome");

        TipoProduto tipoProduto = new TipoProduto(id_produto, nome);

        tipoProdutoDAO.add(tipoProduto);

        response.status(201); // created
        response.redirect("../index.html");

        int idMax = tipoProdutoDAO.getIdMax();

        tipoProdutoDAO.close();

        return idMax;
    }
}