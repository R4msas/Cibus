package service;
import java.net.URISyntaxException;
import dao.OfertaDAO;
import model.Oferta;
import spark.Request;
import spark.Response;
import java.util.*;

public class ofertaServiceIncorreta {
private final int FORM_ORDERBY_ID = 1;
private final int FORM_ORDERBY_DESCRICAO = 2;
private final int FORM_ORDERBY_PRECO = 3;
private String ofertaForm;

	public Object getAll(Request request, Response response) throws URISyntaxException {				
		response.header("Content-Type", "application/json");
		response.header("Content-Encoding", "UTF-8");
		
		ofertaDAO.connection();
		public void makeOfertas(int orderBy) {
			String nomeArquivo = "./src/main/resources/menu.html";
			ofertaForm = "";
			try{
				Scanner entrada = new Scanner(new File(nomeArquivo));
				while(entrada.hasNext()){
					ofertaForm += (entrada.nextLine() + "\n");
				}
				entrada.close();
			}  catch (Exception e) { System.out.println(e.getMessage()); }
			
			
			String listaOferta="";
			
			List<Oferta> ofertas;
			if (orderBy == FORM_ORDERBY_ID) {               ofertas = OfertaDAO.getOrderById();
			} else if (orderBy == FORM_ORDERBY_DESCRICAO) {		ofertas = OfertaDAO.getOrderByDescricao();
			} else if (orderBy == FORM_ORDERBY_PRECO) {			ofertas = OfertaDAO.getOrderByPreco();
			} else {											ofertas = OfertaDAO.get();
			}
			
			
			
			for (Oferta u : ofertas) {
				
				listaOferta += 	  
				"<p>"+u.getDescricao()+"</p>";
			}		
			ofertaForm = ofertaForm.replaceFirst("<!--LISTAR-AMIGOS-->", listaOferta);		
	
			ofertaDAO.close();
	}
		
		@Override
		public Object add(Request request, Response response) throws URISyntaxException {
			ofertaDAO.connection();
			int id_oferta = Integer.parseInt(request.queryParams("bebidaNome"));
			int id_supermercado = Integer.parseInt(request.queryParams("bebidaVolume"));
			int id_produto = Integer.parseInt(request.queryParams("bebidaVolume"));
			String descricao = request.queryParams("bebidaDescricao").trim();
			float preco = Float.parseFloat(request.queryParams("bebidaPreco"));
			
			//TROCAR AQUI EM CIMA^


			Oferta oferta = new Oferta();
			
			oferta = new Oferta(descricao,preco,id_produto, id_supermercado,id_oferta);

			ofertaDAO.add(oferta);

			response.status(201); // created
			response.redirect("/html/ofertas.html"); //Link arquivo Oferta HTML
			
			return ofertaDAO.getId_oferta();
		}

		@Override
		public Object get(Request request, Response response) throws URISyntaxException {
			ofertaDAO.connection();
			
			int id = Integer.parseInt(request.params(":idOferta"));
			
			Oferta oferta = (Oferta) ofertaDAO.get(id);

			response.header("Content-Type", "application/json");
			response.header("Content-Encoding", "UTF-8");
			
			ofertaDAO.close();
			
			if (oferta != null) {
				return oferta.toJson();
			} else {
				response.status(404); // NOT FOUND
				response.redirect("/notfound.html");
				return null;
			}
		}

		@Override
		public Object update(Request request, Response response) throws URISyntaxException {
			ofertaDAO.connection();

			int id = Integer.parseInt(request.params(":idOferta"));

			Oferta oferta = (Oferta) ofertaDAO.get(id);

			if (oferta != null) {
				oferta.setId_oferta(Integer.parseInt(request.queryParams("ofertaId_oferta")));
				oferta.setId_supermercado(Integer.parseInt(request.queryParams("ofertaId_supermercado")));
				oferta.setId_produto(Integer.parseInt(request.queryParams("ofertaId_produto")));
				
				oferta.setDescricao(request.queryParams("ofertaDescricao"));
				oferta.setPreco(Float.parseFloat(request.queryParams("ofertaPreco")));

				ofertaDAO.update(oferta);

				return oferta.getId_oferta();
			} else {
				response.status(404); // 404 Not found
				response.redirect("/notfound.html");
				return null;
			}

		}

		@Override
		public Object remove(Request request, Response response) throws URISyntaxException {
			ofertaDAO.connection();

			int id = Integer.parseInt(request.params(":idOferta"));

			Oferta oferta = (Oferta) ofertaDAO.get(id);

			if (oferta != null) {

				ofertaDAO.delete(oferta);

				response.status(200); // success
				return oferta.getId_oferta();
			} else {
				response.status(404); // 404 Not found
				response.redirect("/notfound.html");
				return null;
			}
		}

		@Override
		public Object getAll(Request request, Response response) throws URISyntaxException {				
			response.header("Content-Type", "application/json");
			response.header("Content-Encoding", "UTF-8");
			
			ofertaDAO.connection();
			
			JSONArray allProds = new JSONArray();
			
			for (Oferta o : ofertaDAO.getAll()) {
				Oferta oferta = (Oferta) o;
				allProds.put(oferta.toJson());
			}

			ofertaDAO.close();
					
			return allProds;
			public void makeOfertas(int orderBy) {
				String nomeArquivo = "./src/main/resources/menu.html";
				ofertaForm = "";
				try{
					Scanner entrada = new Scanner(new File(nomeArquivo));
					while(entrada.hasNext()){
						ofertaForm += (entrada.nextLine() + "\n");
					}
					entrada.close();
				}  catch (Exception e) { System.out.println(e.getMessage()); }
				
				
				String listaOferta="";
				
				List<Oferta> ofertas;
				if (orderBy == FORM_ORDERBY_ID) {               ofertas = OfertaDAO.getOrderById();
				} else if (orderBy == FORM_ORDERBY_DESCRICAO) {		ofertas = OfertaDAO.getOrderByDescricao();
				} else if (orderBy == FORM_ORDERBY_PRECO) {			ofertas = OfertaDAO.getOrderByPreco();
				} else {											ofertas = OfertaDAO.get();
				}
				
				
				
				for (Oferta u : ofertas) {
					
					listaOferta += 	  
					"<p>"+u.getDescricao()+"</p>";
				}		
				ofertaForm = ofertaForm.replaceFirst("<!--LISTAR-AMIGOS-->", listaOferta);		
		

		}


