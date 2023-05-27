package app;
import static spark.Spark.*;
import service.OfertaService;
public class Aplicacao {
	
	private static OfertaService oferta = new OfertaService();
	
    public static void main(String[] args) {
        port(5500);
        
       // staticFiles.location("/public");
        
        //post("/produto/insert", (request, response) -> oferta.insert(request, response));

       // get("/produto/:id", (request, response) -> oferta.get(request, response));
        
        get("/", (request, response) -> oferta.getAll(request, response));

        //get("/produto/update/:id", (request, response) -> oferta.getToUpdate(request, response));
        
       // post("/produto/update/:id", (request, response) -> oferta.update(request, response));
           
       // get("/produto/delete/:id", (request, response) -> oferta.delete(request, response));

             
    }
}