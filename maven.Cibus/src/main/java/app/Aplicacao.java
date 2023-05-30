package app;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;
import model.Oferta;
import service.OfertaService;
import service.TipoProdutoService;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
public class Aplicacao {
	
	//private static OfertaService oferta = new OfertaService();
	
    public static void main(String[] args) {
        port(6789);
        //staticFiles.externalLocation("C:\\Users\\Allan\\Documents\\python\\maven.Cibus\\src\\main\\resources\\public");
        staticFiles.location("/public");
        OfertaService ofertaService=new OfertaService();
        TipoProdutoService tipo_produtoservice = new TipoProdutoService();
        
        get("", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new VelocityTemplateEngine().render(
                new ModelAndView(model, "menu.html")
            );
            
        });
        
        get("/pesquisa/:pesquisa", (request, response) -> ofertaService.getPesquisaOfertas(request, response));
        
        //post("/produto/insert", (request, response) -> oferta.insert(request, response));
        get("/tipo/:id/pesquisa/:pesquisa", (request, response) -> ofertaService.getPorTipo(request, response));
        get("/all", (request, response) -> ofertaService.getAll(request, response));

        //get("/produto/update/:id", (request, response) -> oferta.getToUpdate(request, response));
        
       // post("/produto/update/:id", (request, response) -> oferta.update(request, response));
           
       // get("/produto/delete/:id", (request, response) -> oferta.delete(request, response));
        
        //TIPO PRODUTO:
        get("/inserttipo/:nome", (request, response) -> tipo_produtoservice.insertTipo_produto(request, response));

        //SUPERMERCADO
             
    }
}