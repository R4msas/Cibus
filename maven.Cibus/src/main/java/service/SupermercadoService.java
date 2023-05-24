package service;

import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.SupermercadoDAO;
import dao.OfertaDAO;
import model.Oferta;
import model.Supermercado;
import spark.Request;
import spark.Response;

public class SupermercadoService extends Service{
	private SupermercadoDAO supermercadoDAO;
	private OfertaDAO ofertaDAO;

	public SupermercadoService() {
		supermercadoDAO = new SupermercadoDAO();
		ofertaDAO = new OfertaDAO();
	}

	@Override
	public Object add(Request request, Response response) throws URISyntaxException {
		supermercadoDAO.connect();
		
		int id_supermercado = Integer.parseInt(request.queryParams("idSupermercado"));
		String nome = request.queryParams("supermercadoNome").trim();
		String site = request.queryParams("supermercadoSite").trim();
		
				
		Supermercado supermercado = new Supermercado(id_supermercado, nome, site);

		supermercadoDAO.add(supermercado);

		response.status(201); // created

		return supermercadoDAO.getIdMax();
	}

	@Override
	public Object get(Request request, Response response) throws URISyntaxException {
		supermercadoDAO.connection();
		
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
		supermercadoDAO.connection();
		
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
		supermercadoDAO.connection();
	
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
	
	public Object getAllComprador(Request request, Response response) throws URISyntaxException {
		response.header("Content-Type", "application/json");
		response.header("Content-Encoding", "UTF-8");
		
		int id = Integer.parseInt(request.params(":idComprador"));
		
		supermercadoDAO.connection();
		ofertaDAO.connection();
		
		JSONArray allProds = new JSONArray();
		
		for (Supermercado s : supermercadoDAO.getAllComprador(id)) {
			Supermercado supermercado= (Supermercado) s;
	
			// Pegar informaçõe sobre a oferta
			Oferta oferta = ofertaDAO.get(supermercado.getId_supermercado());
			supermercado.setNome(supermercado.getNome());
			
			allProds.put(supermercado.toJson());
		}

		supermercadoDAO.close();
		ofertaDAO.close();
		
		return allProds;

	}
	
}