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
}