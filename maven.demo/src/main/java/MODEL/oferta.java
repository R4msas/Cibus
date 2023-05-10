package MODEL;

public class oferta {
	private int id_oferta;
	private int id_supermercado;
	private int id_produto;
	private String descricao;
	private Float preco;
	
	public oferta(int id_oferta, int id_supermercado, int id_produto, String descricao, Float preco) {

		this.id_oferta = id_oferta;
		this.id_supermercado = id_supermercado;
		this.id_produto = id_produto;
		this.descricao = descricao;
		this.preco = preco;
	}

	public oferta() {

		id_oferta = -1;
		id_supermercado = -1;
		id_produto = -1;
		descricao = "";
		preco = 0;
	}


	
}
