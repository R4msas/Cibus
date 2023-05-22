package model;

public class Tipo_produto {
	private int id_produto;
	private String nome;

	
	public Tipo_produto() {
		this.id_produto = -1;
		this.nome= "";
	}

	public Tipo_produto(int id_produto, String nome) {
		super();
		this.id_produto = id_produto;
		this.nome = nome;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
	
	
	
	
