package app;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;
import service.OfertaService;
import service.SupermercadoService;
import service.TipoProdutoService;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
public class Suporte {
	
	//private static OfertaService oferta = new OfertaService();
	
    public static void main(String[] args) {
        port(6790);
        //staticFiles.externalLocation("C:\\Users\\Allan\\Documents\\python\\maven.Cibus\\src\\main\\resources\\public");
        staticFiles.location("/suporte");
        OfertaService ofertaService=new OfertaService();
        TipoProdutoService tipo_produtoservice = new TipoProdutoService();
        SupermercadoService supermercadoService = new SupermercadoService();
        
        get("", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new VelocityTemplateEngine().render(
                new ModelAndView(model, "escolher.html")
            );
            
        });
        //Crud's
        
        //Oferta
        get("/pesquisa/:pesquisa", (request, response) -> ofertaService.getPesquisaOfertas(request, response));
        post("/lerArquivo/", (request, response) -> ofertaService.lerArquivo(request, response));
        get("/tipo/:id/pesquisa/:pesquisa", (request, response) -> ofertaService.getPorTipo(request, response));
        get("/all", (request, response) -> ofertaService.getAll(request, response));
        delete("/delete/", (request, response) -> ofertaService.delete(request, response));
        put("/update/", (request, response) -> ofertaService.update(request, response));
        
        //Tipo produto
        get("/allTipo/", (request, response) -> tipo_produtoservice.getTipoProduto(request, response));
        post("/insertTipo/", (request, response) -> tipo_produtoservice.insertPostTipo_produto(request, response));
        delete("/deleteTipo/", (request, response) -> tipo_produtoservice.deleteTipo_produto(request, response));
        put("/updateTipo/", (request, response) -> tipo_produtoservice.updateTipo_produto(request, response));
        
        //Supermercado
        post("/insertSupermercado/", (request, response) ->  supermercadoService.insertPostSupermercado(request, response));
        delete("/deleteSupermercado/", (request, response) -> supermercadoService.deleteSupermercado(request, response));
        put("/updateSupermercado/", (request, response) -> supermercadoService.updateSupermercado(request, response));
        get("/getAllSupermercado/", (request, response) ->  supermercadoService.getAllSupermercado(request, response));
    }
}