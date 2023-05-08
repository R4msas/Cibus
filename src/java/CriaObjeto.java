/**
 * Autor Allan
 * Objetivo: receber um arquivo com os dados já organizados para ser criado objetos da classe oferta, estes serão classificados de acordo com o seu tipo de produto e enviados para o banco de dados
 */
import java.io.File;
import java.util.Scanner;
public class CriaObjeto {
public static void main(String[] args) throws Exception{
    ListaEncadeada lista=new ListaEncadeada();
    MyIO.setCharset("UTF-8");
        Scanner sc = new Scanner(new File("resposta.txt"));
        String stringRecebida =sc.nextLine(); 
        Celula tmp=new Celula();
        lista.primeiro=lista.ultimo=new Celula();//primeiro e último apontam para a mesma célula.
        while (sc.hasNextLine())
        {
            Oferta nova =new Oferta();
            nova.ler(stringRecebida);
            tmp.setAtual(nova);
            lista.inserirFinal(tmp);       
            stringRecebida = sc.nextLine();
            tmp=new Celula();
        }
        sc.close();
    lista.imprimeTodos();
}
    
}
class Oferta{
    
    private String descricao;
    private float preco;
    private int codSupermercado;
    private int tipoProduto;
    
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
    public Oferta(String descricao, float preco, int codSupermercado, int tipoProduto) {
        this.descricao = descricao;
        this.preco = preco;
        this.codSupermercado = codSupermercado;
        this.tipoProduto = tipoProduto;
    }
    public Oferta() {
        this.descricao = null;
        this.preco = 0;
        this.codSupermercado = 0;//este construtor seta como default o código pois o código 0 é do supermercado BH
        this.tipoProduto = 0;
    }
    public void ler(String stringRecebida) throws Exception
    {
            String[] keyValue = stringRecebida.split(":");
            String nomeProduto=keyValue[0];
            Float precoProduto=Float.parseFloat(keyValue[1]);
            setDescricao(nomeProduto);
            setPreco(precoProduto);
            
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
   public Oferta removerInicio()  {
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
   public void imprimeTodos()//falta definir a forma de impressão
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

