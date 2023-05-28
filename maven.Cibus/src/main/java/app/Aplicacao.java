package app;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import service.OfertaService;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
public class Aplicacao {
	
	//private static OfertaService oferta = new OfertaService();
	
    public static void main(String[] args) {
        port(6789);
        //staticFiles.externalLocation("C:\\Users\\Allan\\Documents\\python\\maven.Cibus\\src\\main\\resources\\public");
        staticFiles.location("/public");
        OfertaService ofertaService=new OfertaService();
        
        get("", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new VelocityTemplateEngine().render(
                new ModelAndView(model, "menu.html")
            );
            
        });
        
        //get("", (request, response) -> oferta.getAll(request, response));
        
        //post("/produto/insert", (request, response) -> oferta.insert(request, response));
        get("/tipo/:id/pesquisa/:pesquisa", (request, response) -> ofertaService.getPorTipo(request, response));
        get("/all", (request, response) -> ofertaService.getAll(request, response));

        //get("/produto/update/:id", (request, response) -> oferta.getToUpdate(request, response));
        
       // post("/produto/update/:id", (request, response) -> oferta.update(request, response));
           
       // get("/produto/delete/:id", (request, response) -> oferta.delete(request, response));

             
    }
}