package service;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.SupermercadoDAO;
import dao.OfertaDAO;
import model.Oferta;
import model.Supermercado;
import model.TipoProduto;
import spark.Request;
import spark.Response;

public class SupermercadoService {
	private SupermercadoDAO supermercadoDAO;


	public SupermercadoService() {
		supermercadoDAO = new SupermercadoDAO();

	}

	public Object insertPostSupermercado(Request request, Response response) throws URISyntaxException, SQLException {

		supermercadoDAO.connect();

        String nome = request.queryParams("nome");
        String site = request.queryParams("site");
        Supermercado supermercado = new Supermercado(nome, site);

        
        supermercadoDAO.insertSupermercado(supermercado);

        response.status(201); // created
        response.redirect("../menu.html");



        supermercadoDAO.close();
        
        return(null);
    }
	
    public Boolean deleteSupermercado(Request request, Response response) throws URISyntaxException, SQLException {

        supermercadoDAO.connect();

        int id = Integer.parseInt(request.queryParams("id_supermercado"));


        
        supermercadoDAO.deleteSupermercado(id);

        response.status(200); // correct
        response.redirect("../menu.html");



        supermercadoDAO.close();
        
        return(null);
    }
	
    public Boolean updateSupermercado(Request request, Response response) throws URISyntaxException, SQLException {

        supermercadoDAO.connect();

        int id = Integer.parseInt(request.queryParams("id_supermercado"));
        String nome = request.queryParams("nome");
        String site = request.queryParams("site");
        
        Supermercado supermercado = new Supermercado(id, nome, site);
        
        
        supermercadoDAO.updateSupermercado(supermercado);

        response.status(200); // correct
        response.redirect("../menu.html");


        supermercadoDAO.close();
        
        return(null);
    }
    
    public Object getAllSupermercado(Request request, Response response) throws URISyntaxException, SQLException {				
    	response.header("Content-Type", "application/json");
    	response.header("Content-Encoding", "UTF-8");
    	
    	supermercadoDAO.connect();
    	
    	JSONArray arrayDeSupermercados = new JSONArray();
    	
    	for (Supermercado s : supermercadoDAO.getAllSupermercado()) {
    		Supermercado supermercado = (Supermercado)s;
    		arrayDeSupermercados.put(supermercado.toJson());
    	}

    	supermercadoDAO.close();
    				
    	return arrayDeSupermercados;
    }
    
    
    
 
	
	
	
	
    
	
	/*
	@Override
	public Object get(Request request, Response response) throws URISyntaxException {
		supermercadoDAO.connect();
		
		int id_supermercado = Integer.parseInt(request.queryParams("idSupermercado"));

		Supermercado supermercado = (Supermercado) supermercadoDAO.get(id);

		response.header("Content-Type", "application/json");
		response.header("Content-Encoding", "UTF-8");
				
		JSONObject resp;
		
		if (supermercado != null) {
			resp = supermercado.toJson();
		} else {
			response.status(404); // NOT FOUND
			response.redirect("/notfound.html");
			resp = null;
		}
		
		supermercadoDAO.close();
		
		return resp;

	}

	@Override
	public Object update(Request request, Response response) throws Exception, Throwable {
		supermercadoDAO.connect();
		
		int id = Integer.parseInt(request.params(":idSupermercado"));

		Supermercado supermercado = (Supermercado) supermercadoDAO.get(id);

		if (supermercado != null) {
			supermercado.setId_supermercado(Integer.parseInt(request.queryParams("ofertaId_supermercado")));
			supermercado.setNome(request.queryParams("supermercadoNome"));
			supermercado.setSite(request.queryParams("supermercadoSite"));

			supermercadoDAO.update(supermercado);
		} else {
			response.status(404); // 404 Not found
			response.redirect("/notfound.html");
			supermercado = null;
		}
		
		supermercadoDAO.close();
		
		return supermercado.getId_supermercado();
	}

	@Override
	public Object remove(Request request, Response response) throws URISyntaxException {
		supermercadoDAO.connect();
	
		int id = Integer.parseInt(request.params(":idSupermercado"));
		System.out.println("id = " + id);

		Supermercado supermercado = (Supermercado) supermercadoDAO.get(id);

		if (supermercado != null) {
			supermercadoDAO.delete(supermercado);

			response.status(200); // success
		} else {
			response.status(404); // 404 Not found
			response.redirect("/notfound.html");
			supermercado = null;
		}
		
		supermercadoDAO.close();
		
		return supermercado.getId();
	}

	@Override
	public Object getAll(Request request, Response response) throws URISyntaxException {
		response.header("Content-Type", "application/json");
		response.header("Content-Encoding", "UTF-8");
		
		supermercadoDAO.connect();
		
		JSONArray allProds = new JSONArray();
		
		for (Supermercado s : supermercadoDAO.getAll()) {
			Supermercado supermercado= (Supermercado) s;
			allProds.put(supermercado.toJson());
		}

		supermercadoDAO.close();
		
		return allProds;

	}
	
*/
	
}