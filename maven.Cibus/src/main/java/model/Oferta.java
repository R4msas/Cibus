package model;
import java.io.File;
import java.sql.SQLException;
import java.util.Scanner;
import dao.OfertaDAO;
import org.json.JSONObject;
import service.OfertaService;

public class Oferta{
public static void main(String[] args) throws Exception {
	//ListaEncadeada lista=new ListaEncadeada();
	//lista.lerArquivo();
	//OfertaDAO teste=new OfertaDAO();
    //teste.OfertaDAO.getAll();    
    }
	
    
    private String descricao;
    private int id_oferta;
	private float preco;
    private int codSupermercado;
    private int tipoProduto;
    public Oferta(String descricao, float preco, int codSupermercado, int tipoProduto) {
        this.descricao = descricao;
        this.preco = preco;
        this.codSupermercado = codSupermercado;
        this.tipoProduto = tipoProduto;
    }
    public Oferta(String descricao, float preco, int codSupermercado, int tipoProduto, int id_oferta) {
        this.descricao = descricao;
        this.preco = preco;
        this.codSupermercado = codSupermercado;
        this.tipoProduto = tipoProduto;
        this.id_oferta = id_oferta;
    }
    
    
	public Oferta() {
        this.descricao = null;
        this.preco = 0;
        this.codSupermercado = 0;
        this.tipoProduto = 0;
        this.id_oferta = 0;
    }
    
    public int getId_oferta() {
		return id_oferta;
	}
	public void setId_oferta(int id_oferta) {
		this.id_oferta = id_oferta;
	}
    public int getTipoProduto()
    {
        return tipoProduto;
    }
    public void setTipoProduto(int tipoProduto)
    {
        this.tipoProduto = tipoProduto;
    }
    public String getDescricao()
    {
        return descricao;
    }
    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }
    public float getPreco()
    {
        return preco;
    }
    public void setPreco(float preco)
    {
        this.preco = preco;
    }
    public int getCodSupermercado()
    {
        return codSupermercado;
    }
    public void setCodSupermercado(int codSupermercado)
    {
        this.codSupermercado = codSupermercado;
    }
    
    
        
    public void ler(String stringRecebida) throws Exception
    {
            String[] keyValue = stringRecebida.split(":");
            String nomeProduto=keyValue[0];
            Float precoProduto=Float.parseFloat(keyValue[1]);
            setDescricao(nomeProduto);
            setPreco(precoProduto);
            
    }

    public int classificaTipo()
    {
        String carne[]={"carne", "acem", "acém", "paleta", "costela", "picanha", "chã de", "costelinha","hamburguer","linguica","linguiça","file","filé","salsicha","empanado"};
        String bebidaAlcolica[]={"whisky","vinho","vodka","cachaça","cachaca","rum"};
        String macarrao[]={"macarrao","noodle","massa"};
        String refrigerante[]={"refrigerante", "coca-cola","pepsi","fanta"};
        String bolacha[]={"bolacha","biscoito"};
        String pao[]={"paes","pao","bolo"};
        String laticinio[]={"leite","iogurte","láctea", "lactea","requeijão","requeijao","margarina","manteiga","queijo","mussarela","muçarela", "petit suisse"};
        String xampu[]={"xampu", "shampoo"};
        String sabao[]={"sabao","detergente","lava roupas"};
        String cafe[]={"cafe", "café"};
        String oleo[]={"oleo","óleo","azeite"};
        int posicao=0;
        Boolean possuiPosicao=false;
        int tipoProduto=-1;
        String stringRecebida =descricao.toLowerCase();
        if(stringRecebida.contains("arroz"))
        {
            possuiPosicao=true;
            posicao=3;
        }
        else if(stringRecebida.contains("suco"))
        {
            possuiPosicao=true;
            posicao=7;
        }
        else if(stringRecebida.contains("cerveja"))
        {
            possuiPosicao=true;
            posicao=15;
        }
              else if(stringRecebida.contains("farinha de trigo"))
        {
            possuiPosicao=true;
            posicao=16;
        }
        while(possuiPosicao==false&&posicao<carne.length)
        {
            if(stringRecebida.contains(carne[posicao]))
            {
                possuiPosicao=true;
                tipoProduto=1;
            }
            else{
            posicao++;
            }
        }
        posicao=0;
        while(possuiPosicao==false&&posicao<bebidaAlcolica.length)
        {
            if(stringRecebida.contains(bebidaAlcolica[posicao]))
            {
                possuiPosicao=true;
                tipoProduto=2;
            }
            else{
            posicao++;
            }
        }
        posicao=0;
        while(possuiPosicao==false&&posicao<macarrao.length)
        {
            if(stringRecebida.contains(macarrao[posicao]))
            {
                possuiPosicao=true;
                tipoProduto=6;
            }
            else{
            posicao++;
            }
        }
        posicao=0;
        while(possuiPosicao==false&&posicao<oleo.length)
        {
            if(stringRecebida.contains(oleo[posicao]))
            {
                possuiPosicao=true;
                tipoProduto=5;
            }
            else{
            posicao++;
            }
        }
        posicao=0;
        while(possuiPosicao==false&&posicao<refrigerante.length)
        {
            if(stringRecebida.contains(refrigerante[posicao]))
            {
                possuiPosicao=true;
                tipoProduto=8;
            }
            else{
            posicao++;
            }
        }
        posicao=0;
        while(possuiPosicao==false&&posicao<bolacha.length)
        {
            if(stringRecebida.contains(bolacha[posicao]))
            {
                possuiPosicao=true;
                tipoProduto=9;
            }
            else{
            posicao++;
            }
        }
        posicao=0;
        while(possuiPosicao==false&&posicao<pao.length)
        {
            if(stringRecebida.contains(pao[posicao]))
            {
                possuiPosicao=true;
                tipoProduto=10;
            }
            else{
            posicao++;
            }
        }
        posicao=0;
        while(possuiPosicao==false&&posicao<laticinio.length)
        {
            if(stringRecebida.contains(laticinio[posicao]))
            {
                possuiPosicao=true;
                tipoProduto=11;
            }
            else{
            posicao++;
            }
        }
        posicao=0;
        while(possuiPosicao==false&&posicao<xampu.length)
        {
            if(stringRecebida.contains(xampu[posicao]))
            {
                possuiPosicao=true;
                tipoProduto=12;
            }
            else{
            posicao++;
            }
        }
        posicao=0;
           while(possuiPosicao==false&&posicao<sabao.length)
        {
            if(stringRecebida.contains(sabao[posicao]))
            {
                possuiPosicao=true;
                tipoProduto=13;
            }
            else{
            posicao++;
            }
        }
        posicao=0;
        while(possuiPosicao==false&&posicao<cafe.length)
        {
            if(stringRecebida.contains(cafe[posicao]))
            {
                possuiPosicao=true;
                tipoProduto=17;
            }
            else{
             posicao++;
            }
        }
 

return tipoProduto;
    }
    
    public JSONObject toJson() {
		JSONObject obj = new JSONObject();
		obj.put("id_oferta", this.getId_oferta());
		obj.put("descricao", this.getDescricao());
		obj.put("preco", this.getPreco());
		obj.put("codSupermercado", this.getCodSupermercado());
		obj.put("tipoProduto", this.getTipoProduto());
		return obj;
	}
}
class Celula{
    private Oferta atual;
    private Celula prox;

    public Oferta getAtual()
    {
        return atual;
    }
    public void setAtual(Oferta atual)
    {
        this.atual = atual;
    }
    public Celula getProx()
    {
        return prox;
    }
    public void setProx(Celula prox)
    {
        this.prox = prox;
    }
    
}

class ListaEncadeada{
    Celula ultimo;
    Celula primeiro;
  
    public void inserirInicio(Celula tmp)  {
    tmp.setProx(primeiro.getProx());
    primeiro.setProx(tmp);
    tmp=null;     

    }
    public void inserirFinal(Celula tmp)
    {
        ultimo.setProx(tmp);
        ultimo=tmp;
        tmp=null;

    }
    public void lerArquivo() throws Exception
    {	MyIO.println("Informe o número do supermercado");
    	int supermercado=MyIO.readInt();
    	MyIO.println("Informe o nome do arquivo de leitura:");
		String nomeDoArquivo=MyIO.readLine();
    	lerArquivo("src\\main\\resources\\"+nomeDoArquivo, supermercado);
    }
    private void lerArquivo(String nomeDoArquivo, int supermercado) throws Exception
    {
    	
    	
        criaListaDeOfertas(nomeDoArquivo, supermercado);
    	
		ListaEncadeada necessitaDeClassificacao= new ListaEncadeada();
		ListaEncadeada classificada=new ListaEncadeada();
        percorreAListaEClassifica(necessitaDeClassificacao,classificada);
        classificada.enviaBD();
    }
    public void enviaBD() //percorre a lista encadeada e envia os objetos Oferta para o BD
    {
        Celula tmp=primeiro;
    	OfertaDAO bd = new OfertaDAO();
		//bd.connection();
        while(tmp.getProx()!=null)
        {
        
            tmp=tmp.getProx();//percorre a lista
            try {
			bd.insert(tmp.getAtual());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				bd.close();
				e.printStackTrace();
			}
           
        }
        bd.close();
    }
    public Oferta removerInicio()  {
        if(primeiro.getProx()==ultimo)
        {
            ultimo=primeiro;
        }
        Oferta resposta=primeiro.getProx().getAtual();
        primeiro.setProx(primeiro.getProx().getProx());
        return resposta;
    }
    public Oferta removerFim() {
        Celula temporaria=primeiro.getProx();
        while(temporaria.getProx()!=ultimo)
        {
            temporaria=temporaria.getProx();
        }
        Oferta resposta=ultimo.getAtual();
        temporaria.setProx(null);
        ultimo=temporaria;
        return resposta;
    }
    public void percorreAListaEClassifica(ListaEncadeada necessitaDeClassificacao,ListaEncadeada classificada)
    {            
        necessitaDeClassificacao.ultimo=necessitaDeClassificacao.primeiro=new Celula();
        classificada.ultimo=classificada.primeiro=new Celula();
        Celula tmp=primeiro;
        while(tmp.getProx()!=null||tmp==ultimo)
        {
            tmp=primeiro.getProx();
            int tipoProduto=tmp.getAtual().classificaTipo();
            
             if(tipoProduto==-1)
            {
                Celula temp=new Celula();
                temp.setAtual(tmp.getAtual());
                necessitaDeClassificacao.inserirFinal(temp);
            }
            else{
                Celula temp2=new Celula();
                temp2.setAtual(tmp.getAtual());
                temp2.getAtual().setTipoProduto(tipoProduto);
                classificada.inserirFinal(temp2);
                } 
                removerInicio();
        }
    }
    public void criaListaDeOfertas(String nomeDoArquivo, int supermercado) throws Exception
    {
        Scanner sc = new Scanner(new File(nomeDoArquivo));
        String stringRecebida =sc.nextLine();
        Celula tmp=new Celula();
        primeiro=ultimo=new Celula();
        while (sc.hasNextLine())
        {
            Oferta nova =new Oferta();
            nova.ler(stringRecebida);
            nova.setCodSupermercado(supermercado);
            tmp.setAtual(nova);
            inserirFinal(tmp);       
            stringRecebida = sc.nextLine();
            tmp=new Celula();
        }
        sc.close();
    }
    public void imprimeTodos()
    {
        Celula tmp=primeiro;
        while(tmp.getProx()!=null)
        {
            tmp=tmp.getProx();
            MyIO.setCharset("UTF-8");
            MyIO.println("Descricao:"+tmp.getAtual().getDescricao());
            MyIO.println("Codigo do supermercado:"+tmp.getAtual().getCodSupermercado());
            MyIO.println("Tipo de produto:"+tmp.getAtual().getTipoProduto());
            MyIO.println("Preco:"+tmp.getAtual().getPreco());
            }
        }
    }
