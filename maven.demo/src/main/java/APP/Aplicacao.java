package app;

import static spark.Spark.*;
import app.Principal;
import model.Oferta;
import service.OfertaService; //BebidaService
import service.SupermercadoService; // SupermercadoService
import service.Tipo_produtoService; //  Tipo_produtoService
import spark.Request;
import spark.Response;

public class Aplicacao {
	
	private static OfertaService OfertaService = new OfertaService();
	private static Tipo_produtoService Tipo_produtoService = new Tipo_produtoService();
	private static SupermercadoService pedidoService = new PedidoService();
	private static Render render = new Render();
	
	public static void main(String[] args) {
		port(getHerokuAssignedPort());
		
		
		staticFiles.location("/public");
		
		before((req, res) -> {
		      String path = req.pathInfo();
		      if (path.endsWith("/"))
		        res.redirect(path.substring(0, path.length() - 1));
	    });
		
		get("/", (req,res) -> Aplicacao.index(req, res)); 
		
		//HTTP Methods: Bebida
		post("/create/oferta", (request,response) ->  OfertaService.add(request, response) );
		get("/all/oferta", (request, response) -> OfertaService.getAll(request, response)); 
		get("/get/oferta/:idOferta", (request, response) -> OfertaService.get(request, response)); 
		put("/update/oferta/:id_oferta", (request, response) -> OfertaService.update(request, response));
		delete("/delete/oferta/:idOferta", (request, response) -> OfertaService.remove(request,response));
		
		//HTTP Methods: Usuario
		post("/create/usuario",       (request,response) ->   Tipo_produtoService.add(request, response) );
		get("/get/usuario/:email", (request,response) ->   Tipo_produtoService.get(request, response) );
				
		//HTTP Methods: Pedido
		post("/create/pedido", (request,response) ->  SupermercadoService.add(request, response) );
		get("/get/pedido", (request, response) -> SupermercadoService.get(request, response)); 
		put("/update/pedido/:id", (request, response) -> {
			Object resp;
			try {
				resp = SupermercadoService.update(request, response);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resp = null;
			}
			return resp;
		});
		get("/delete/pedido/:idPedido", (request, response) -> SupermercadoService.remove(request,response));
		get("/all/pedido", (request, response) -> SupermercadoService.getAll(request, response));
		get("/all/pedido/:idComprador", (request, response) -> SupermercadoService.getAllComprador(request, response));
	}
	
	private static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
	
	public static String index(Request req, Response res) {
		res.type("text/html");
		try{
			return render.renderContent("index.html");
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
	
}