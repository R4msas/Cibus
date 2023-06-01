package service;
import model.ListaEncadeada;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.json.JSONArray;

import dao.OfertaDAO;
import model.Oferta;
import model.TipoProduto;
import spark.Request;
import spark.Response;

public class OfertaService{
	private OfertaDAO ofertaDAO;

	public OfertaService() {
		ofertaDAO = new OfertaDAO();
	}
public Boolean lerArquivo(Request request, Response response) throws Exception
{	
	ListaEncadeada list = new ListaEncadeada();
	response.header("Content-Type", "application/json");
	response.header("Content-Encoding", "UTF-8");
	ofertaDAO.connect();
	int codSupermercado=Integer.parseInt(request.queryParams("codSupermercado"));
	String nomeDoArquivo=request.queryParams("nomeDoArquivo");
	Boolean resp=list.lerArquivo(codSupermercado, nomeDoArquivo);//arquivo deverá estar na pasta suporte/arquivosParaInsercao
	System.out.println("inclusão do arquivo "+nomeDoArquivo+" efetuada com sucesso");
	return resp;

	
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
//método que deleta uma oferta, chamado pela página de suporte
//ATENÇÃO alterar posteriormente o redirecionamento para a página de suporte.
public Boolean delete(Request request, Response response) throws URISyntaxException, SQLException {

	ofertaDAO.connect();

    int id = Integer.parseInt(request.queryParams("id"));



    
    ofertaDAO.delete(id);

    response.status(200); // correct
    response.redirect("../menu.html");



    ofertaDAO.close();
    
    return(null);
}

public Boolean update(Request request, Response response) throws URISyntaxException, SQLException {

    ofertaDAO.connect();

    int id = Integer.parseInt(request.queryParams("idProduto"));
    String nome = request.queryParams("nome");
    
    TipoProduto tipoProduto = new TipoProduto(id, nome);
    
    
    tipoProdutoDAO.updateTipoProduto(tipoProduto);

    response.status(200); // correct
    response.redirect("../menu.html");



    tipoProdutoDAO.close();
    
    return(null);
}
}