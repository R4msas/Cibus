package service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.json.JSONArray;

import dao.TipoProdutoDAO;
import model.Oferta;
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

    public Object getTipoProduto(Request request, Response response) throws URISyntaxException, SQLException {

    	tipoProdutoDAO.connect();
    	JSONArray arrayDeTipos = new JSONArray();
    	
    	for (TipoProduto o : tipoProdutoDAO.getAll()) {
    		TipoProduto tipoProduto = (TipoProduto)o;
    		arrayDeTipos.put(tipoProduto.toJson());
    	}

        tipoProdutoDAO.close();

    	return arrayDeTipos;
        
    }
    
    public Object insertPostTipo_produto(Request request, Response response) throws URISyntaxException, SQLException {

        tipoProdutoDAO.connect();

        String nome = request.queryParams("nome");

        tipoProdutoDAO.insertTipoProduto(nome);
        tipoProdutoDAO.close();
        
        return(null);
    }
    
    public Boolean deleteTipo_produto(Request request, Response response) throws URISyntaxException, SQLException {

        tipoProdutoDAO.connect();

        int id = Integer.parseInt(request.queryParams("idProduto"));


        
        tipoProdutoDAO.deleteTipoProduto(id);




        tipoProdutoDAO.close();
        
        return(null);
    }
    
    public Boolean updateTipo_produto(Request request, Response response) throws URISyntaxException, SQLException {

        tipoProdutoDAO.connect();

        int id = Integer.parseInt(request.queryParams("idProduto"));
        String nome = request.queryParams("nome");
        
        TipoProduto tipoProduto = new TipoProduto(id, nome);
        
        
        tipoProdutoDAO.updateTipoProduto(tipoProduto);

        response.status(200); // correct
        response.redirect("../menu.html");



        tipoProdutoDAO.close();
        
        return(null);
    }
    
    
}