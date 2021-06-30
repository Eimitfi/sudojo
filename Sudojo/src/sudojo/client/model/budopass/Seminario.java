package sudojo.client.model.budopass;

import java.util.Date;

public class Seminario {
	private Date data;
	private String tenutario;
	private String luogo;
	
	public Seminario(Date data, String tenutario, String luogo) {
		super();
		this.data = data;
		this.tenutario = tenutario;
		this.luogo = luogo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getTenutario() {
		return tenutario;
	}
	public void setTenutario(String tenutario) {
		this.tenutario = tenutario;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	
	
}
