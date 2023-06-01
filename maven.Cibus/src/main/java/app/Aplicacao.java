package app;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;
import service.OfertaService;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
public class Aplicacao {
	
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
        
        //Oferta
        get("/pesquisa/:pesquisa", (request, response) -> ofertaService.getPesquisaOfertas(request, response));
        get("/tipo/:id/pesquisa/:pesquisa", (request, response) -> ofertaService.getPorTipo(request, response));
        get("/all", (request, response) -> ofertaService.getAll(request, response));
    }
}