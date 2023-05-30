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
    private TipoProdutoDAO tipoProdutoDAO;

    public TipoProdutoService() {
        this.tipoProdutoDAO = new TipoProdutoDAO();
    }

    public Object insertTipo_produto(Request request, Response response) throws URISyntaxException {

        tipoProdutoDAO.connect();

        String nome = request.params(":nome");

        TipoProduto tipoProduto = new TipoProduto(nome);
        System.out.println(tipoProduto.getNome());
        
        tipoProdutoDAO.insertTipoProduto(tipoProduto);

        response.status(201); // created
        response.redirect("../menu.html");



        tipoProdutoDAO.close();
        
        return(null);
    }
}