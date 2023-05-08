import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
public class tratamentoWebScraping {
public static void main(String[] args) throws IOException {
Oferta []listaProduto=new Oferta[500];
int numeroItem=0;
FileReader input = new FileReader("epa.txt");
BufferedReader bufRead = new BufferedReader(input);
String myLine = null;
String linhaPreco="product-price\">";
String linhaProduto="product-name\">";
String[] precoObj;
String[] nomeObj;
while ( (myLine = bufRead.readLine()) != null)
{   Boolean alteraProduto=false;
    if(myLine.contains(linhaPreco))
    {
        precoObj=myLine.split(linhaPreco,5);
        alteraProduto=true;
    }
    if(myLine.contains(linhaProduto))
    {
        precoObj=myLine.split(linhaProduto);
    }

    if(alteraProduto)
    {
        numeroItem++;
    }
}
bufRead.close();
System.out.println();
System.out.println(precoObj);
System.out.println(precoObj);

}
}
class Oferta{
        private String descricao;
        private float preco;
        private int codSupermercado;
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

    }

