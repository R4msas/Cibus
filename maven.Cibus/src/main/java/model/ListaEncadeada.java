package model;

import java.io.File;
import java.sql.SQLException;
import java.util.Scanner;

import dao.OfertaDAO;

public class ListaEncadeada{
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
        public Boolean lerArquivo( int supermercado,String nomeDoArquivo) throws Exception
    {
    	
    	String caminhoCompleto="src\\main\\resources\\suporte\\arquivosParaInsercao\\"+nomeDoArquivo;
    	criaListaDeOfertas(caminhoCompleto, supermercado);
        percorreAListaEClassifica();
        return enviaBD();
        
    }
    public Boolean enviaBD() //percorre a lista encadeada e envia os objetos Oferta para o BD
    {
    	Boolean resposta=true;
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
				resposta=false;
			}
           
        }
        bd.close();
        return resposta;
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
    public void percorreAListaEClassifica()
    {            
        Celula tmp=primeiro;
        while(tmp.getProx()!=null||tmp==ultimo)
        {
            tmp=primeiro.getProx();
            int tipoProduto=tmp.getAtual().classificaTipo();
            tmp.getAtual().setTipoProduto(tipoProduto);
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
