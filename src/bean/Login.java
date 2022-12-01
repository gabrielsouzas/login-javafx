package bean;

public class Login {
	private String usuario;
	private String senha;
	
	public Login() {
		super();
	}
	public Login(String usuario, String senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
