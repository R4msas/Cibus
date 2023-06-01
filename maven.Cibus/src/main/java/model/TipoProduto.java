package model;

public class TipoProduto {
	private int idProduto;
	private String nome;

	
	public TipoProduto() {
		this.idProduto = -1;
		this.nome= "";
	}

	public TipoProduto(int idProduto, String nome) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
	}
	
	public TipoProduto(String nome) {
		super();
		this.nome = nome;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setId_produto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
		}
	}