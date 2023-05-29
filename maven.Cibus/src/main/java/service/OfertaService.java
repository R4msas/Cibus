package service;

import java.net.URISyntaxException;
import java.sql.SQLException;

import org.json.JSONArray;

import dao.OfertaDAO;
import model.Oferta;
import spark.Request;
import spark.Response;

public class OfertaService{
	private OfertaDAO ofertaDAO;

	public OfertaService() {
		ofertaDAO = new OfertaDAO();
	}

public Object getAll(Request request, Response response) throws URISyntaxException, SQLException {				
	response.header("Content-Type", "application/json");
	response.header("Content-Encoding", "UTF-8");
	
	ofertaDAO.connect();
	
	JSONArray arrayDeOfertas = new JSONArray();
	
	for (Oferta o : ofertaDAO.getAll()) {
		Oferta oferta = (Oferta)o;
		arrayDeOfertas.put(oferta.toJson());
	}

	ofertaDAO.close();
				
	return arrayDeOfertas;
}
public Object getPorTipo(Request request, Response response) throws URISyntaxException, SQLException {				
	
	
	ofertaDAO.connect();
	int id =Integer.parseInt(request.params(":id"));
	System.out.println(id);
	String pesquisa=request.params(":pesquisa");
	System.out.println(request.queryParams());
	JSONArray arrayDeOfertas = new JSONArray();
	
	for (Oferta o : ofertaDAO.getPorTipo(id, pesquisa)) {
		Oferta oferta = (Oferta)o;
		arrayDeOfertas.put(oferta.toJson());
	}
	
	ofertaDAO.close();
				
	return arrayDeOfertas;
}
public Object getPesquisaOfertas(Request request, Response response) throws URISyntaxException, SQLException {				
	
	
	ofertaDAO.connect();
	String pesquisa=request.params(":pesquisa");
	JSONArray arrayDeOfertas = new JSONArray();
	
	for (Oferta o : ofertaDAO.getPesquisaOferta(pesquisa)) {
		Oferta oferta = (Oferta)o;
		arrayDeOfertas.put(oferta.toJson());
	}
	
	ofertaDAO.close();
				
	return arrayDeOfertas;
}
}