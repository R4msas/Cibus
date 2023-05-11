/**
 * Autor Allan
 * Objetivo: receber um arquivo com os dados já organizados para ser criado objetos da classe oferta, estes serão classificados de acordo com o seu tipo de produto e enviados para o banco de dados
 */
import java.io.File;
import java.util.Scanner;
public class CriaObjeto {
public static void main(String[] args) throws Exception{
    ListaEncadeada lista=new ListaEncadeada();        
    lista.criaListaDeOfertas("arquivo.txt");
    ListaEncadeada necessitaDeClassificacao= new ListaEncadeada();
    lista.percorreAListaEClassifica(necessitaDeClassificacao);
    lista.imprimeTodos();
    necessitaDeClassificacao.imprimeTodos();
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

    public int classificaTipo()//efetua a comparação da descrição com termos comuns de produtos, caso seja possível retorna o inteiro para setTipo, do contrário retorna -1
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
                tipoProduto=0;
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
    public void percorreAListaEClassifica(ListaEncadeada necessitaDeClassificacao)//percorre a lista de e classifica e chama a função que classifica cada oferta
    {            
        necessitaDeClassificacao.ultimo=necessitaDeClassificacao.primeiro=new Celula();
        Celula tmp=primeiro;
        while(tmp.getProx()!=null||tmp==ultimo)//percorre por toda a lista encadeada
        {
            tmp=primeiro.getProx();
            int tipoProduto=tmp.getAtual().classificaTipo();
            
             if(tipoProduto==-1)//se o tipo de produto não for inserido, altera para -1 e guarda na lista em que é necessário inserir manualmente
            {
                Celula temp=new Celula();
                temp.setAtual(tmp.getAtual());
                necessitaDeClassificacao.inserirFinal(temp);//insere no final da lista
            }
            else{
                Celula temp2=new Celula();
                temp2.setAtual(tmp.getAtual());
                temp2.getAtual().setTipoProduto(tipoProduto);
                //enviar para o banco de dados  
                } 
                removerInicio();
        }
    }
    public void criaListaDeOfertas(String nomeDoArquivo) throws Exception
    {
        Scanner sc = new Scanner(new File(nomeDoArquivo));
        String stringRecebida =sc.nextLine();//inicia a primeira leitura da primeira linha
        Celula tmp=new Celula();
        primeiro=ultimo=new Celula();//primeiro e último apontam para a mesma célula.
        while (sc.hasNextLine())//enquanto houver uma nova linha lerá o arquivo, gerando um novo objeto da classe Oferta
        {
            Oferta nova =new Oferta();
            nova.ler(stringRecebida);
            tmp.setAtual(nova);
            inserirFinal(tmp);       
            stringRecebida = sc.nextLine();
            tmp=new Celula();
        }
        sc.close();
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

