package sudojo.client.model.gestioneAffiliato;

public class Credenziali {
	private String username;
	private boolean tmp;
	private String password;
	
	
	
	public Credenziali(String username, boolean tmp, String password) {
		super();
		this.username = username;
		this.tmp = tmp;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isTmp() {
		return tmp;
	}
	public void setTmp(boolean tmp) {
		this.tmp = tmp;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
