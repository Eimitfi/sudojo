package sudojo.client.model.elenchi;

public class Affiliato {
	private String user;
	private String nome;
	private String cognome;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Affiliato(String user, String nome, String cognome) {
		super();
		this.user = user;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	
}
