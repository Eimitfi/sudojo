package sudojo.broker1;

public class Argomento {
	private String nome;
	private String valore;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValore() {
		return valore;
	}
	public void setValore(String valore) {
		this.valore = valore;
	}
	public Argomento(String nome, String valore) {
		super();
		this.nome = nome;
		this.valore = valore;
	}
	
	
}
