package model;

public class Supermercado {
	private int id_supermercado;
	private String nome;
	private String site;
	
	public Supermercado() {
		super();
		id_supermercado = 0;
		nome="";
		site = "";
		}
	
	public Supermercado(int id_supermercado, String nome, String site) {
		super();
		this.id_supermercado = id_supermercado;
		this.nome = nome;
		this.site = site;
		}

	public int getId_supermercado() {
		return id_supermercado;
		}

	public void setId_supermercado(int id_supermercado) {
		this.id_supermercado = id_supermercado;
		}

	public String getNome() {
		return nome;
		}

	public void setNome(String nome) {
		this.nome = nome;
		}

	public String getSite() {
		return site;
		}

	public void setSite(String site) {
		this.site = site;
		}
	}