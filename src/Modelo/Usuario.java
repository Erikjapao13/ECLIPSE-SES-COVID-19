package Modelo;

public class Usuario {

	private int id;
	private String usuario;
	private String nome;
	private String senha;
	private String fone;
	private String cargo;
	
	public Usuario() {
		super();
	}
	

	public Usuario(String cargo) {
		super();
		this.cargo = cargo;
	}

	public Usuario(String usuario, String senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
	}

	public Usuario(String usuario, String nome, String fone) {
		super();
		this.usuario = usuario;
		this.nome = nome;
		this.fone = fone;
	}
	public Usuario(String usuario, String nome, String fone, int id) {
		super();
		this.usuario = usuario;
		this.nome = nome;
		this.fone = fone;
		this.id = id;
	}
	
	public Usuario(String usuario, String nome, String senha, String fone, String cargo) {
		super();
		this.usuario = usuario;
		this.nome = nome;
		this.senha = senha;
		this.fone = fone;
		this.cargo = cargo;
	}

	public Usuario(int id, String usuario, String nome, String senha, String fone, String cargo) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.nome = nome;
		this.senha = senha;
		this.fone = fone;
		this.cargo = cargo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
