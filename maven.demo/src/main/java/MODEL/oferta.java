package model;

public class Oferta {
	private int id_oferta;
	private int id_supermercado;
	private int id_produto;
	private String descricao;
	private Float preco;
	
	public Oferta(int id_oferta, int id_supermercado, int id_produto, String descricao, Float preco) {

		this.id_oferta = id_oferta;
		this.id_supermercado = id_supermercado;
		this.id_produto = id_produto;
		this.descricao = descricao;
		this.preco = preco;
	}

	public Oferta() {

		id_oferta = -1;
		id_supermercado = -1;
		id_produto = -1;
		descricao = "";
		preco = (float) 0;
	}

	public int getId_oferta() {
		return id_oferta;
	}

	public void setId_oferta(int id_oferta) {
		this.id_oferta = id_oferta;
	}

	public int getId_supermercado() {
		return id_supermercado;
	}

	public void setId_supermercado(int id_supermercado) {
		this.id_supermercado = id_supermercado;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}
	
	
}
