package model;
import java.io.File;
import java.util.Scanner;

import org.apache.hadoop.shaded.com.nimbusds.jose.shaded.json.JSONObject;
public class Oferta{
    
    private String descricao;
    private float preco;
    private int codSupermercado;
    private int tipoProduto;
    private int id_oferta;
    
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
    public Oferta(String descricao, float preco, int codSupermercado, int tipoProduto) {
        this.descricao = descricao;
        this.preco = preco;
        this.codSupermercado = codSupermercado;
        this.tipoProduto = tipoProduto;
    }
    
    public Oferta(int id_oferta, String descricao, float preco, int codSupermercado, int tipoProduto) {
    	this.id_oferta = id_oferta;
    	this.descricao = descricao;
        this.preco = preco;
        this.codSupermercado = codSupermercado;
        this.tipoProduto = tipoProduto;
    }
    
	public Oferta() {
        this.descricao = null;
        this.preco = 0;
        this.codSupermercado = 0;
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
        String bebidaAlcolica[]={"whisky"," vinho","vodka","cachaça","cachaca","rum"};
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
        int tipoProduto=20;
        String stringRecebida =descricao.toLowerCase();
        if(stringRecebida.contains("arroz"))
        {
            possuiPosicao=true;
            tipoProduto=3;
        }
        else if(stringRecebida.contains("suco"))
        {
            possuiPosicao=true;
            tipoProduto=7;
        }
        else if(stringRecebida.contains("cerveja"))
        {
            possuiPosicao=true;
            tipoProduto=15;
        }
              else if(stringRecebida.contains("farinha de trigo"))
        {
            possuiPosicao=true;
            tipoProduto=16;
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

