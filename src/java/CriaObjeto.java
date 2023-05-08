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
        String stringRecebida =sc.nextLine();//inicia a primeira leitura da primeira linha
        Celula tmp=new Celula();
        lista.primeiro=lista.ultimo=new Celula();//primeiro e último apontam para a mesma célula.
        while (sc.hasNextLine())//enquanto houver uma nova linha lerá o arquivo, gerando um novo objeto da classe Oferta
        {
            Oferta nova =new Oferta();
            nova.ler(stringRecebida);
            tmp.setAtual(nova);
            lista.inserirFinal(tmp);       
            stringRecebida = sc.nextLine();
            tmp=new Celula();
        }
        sc.close();
        ListaEncadeada pronta=new ListaEncadeada();//cria uma nova instância da classe lista encadeada para inserir as Ofertas que foram classificadas pelo método
        pronta.primeiro=pronta.ultimo=new Celula(); 
        ListaEncadeada manual=new ListaEncadeada();//cria uma nova instância da classe lista encadeada para inserir as Ofertas que não foram classificadas pelo método e precisam de ser feitas manualmente
        manual.primeiro=manual.ultimo=new Celula();
        tmp=lista.primeiro;
        while(tmp!=null)//percorre por toda a lista encadeada
        {
            tmp=tmp.getProx();
            int tipoProduto=tmp.getAtual().classificaTipo();
            if(tipoProduto==-1)
            {
                Celula temp=new Celula();
                temp.setAtual(tmp.getAtual());
                manual.inserirFinal(temp);
            }
            else{
                Celula temp2=new Celula();
                temp2.setAtual(tmp.getAtual());
                temp2.getAtual().setTipoProduto(tipoProduto);
                pronta.inserirFinal(temp2);
            }
            lista.removerFim();

        }
        
        MyIO.println("Objetos da lista ordenada");
        lista.imprimeTodos();
        MyIO.println("Objetos da lista pronta");
        pronta.imprimeTodos();
        MyIO.println("Objetos da lista manual");
        manual.imprimeTodos();

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
        if(descricao.contains("arroz"))
        {
            possuiPosicao=true;
            posicao=3;
        }
        else if(descricao.contains("suco"))
        {
            possuiPosicao=true;
            posicao=7;
        }
        else if(descricao.contains("cerveja"))
        {
            possuiPosicao=true;
            posicao=15;
        }
        else if(descricao.contains("farinha de trigo"))
        {
            possuiPosicao=true;
            posicao=16;
        }
        while(possuiPosicao==false&&posicao<carne.length)
        {
            if(descricao.contains(carne[posicao]))
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
            if(descricao.contains(bebidaAlcolica[posicao]))
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
            if(descricao.contains(macarrao[posicao]))
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
            if(descricao.contains(oleo[posicao]))
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
            if(descricao.contains(refrigerante[posicao]))
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
            if(descricao.contains(bolacha[posicao]))
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
            if(descricao.contains(pao[posicao]))
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
            if(descricao.contains(laticinio[posicao]))
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
            if(descricao.contains(xampu[posicao]))
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
            if(descricao.contains(sabao[posicao]))
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
            if(descricao.contains(cafe[posicao]))
            {
                possuiPosicao=true;
                tipoProduto=17;
            }
            else{
            posicao++;
            }
        posicao=0;}
 

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

