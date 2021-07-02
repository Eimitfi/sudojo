package sudojo.broker1.dbfakemock.model.documento;

import java.util.Date;

public class Documento {
	private String oggetto;
	private Date data;
	private String userMittente;
	private String nomeMittente;
	private String cognomeMittente;
	private byte[] allegato;
	
	public Documento(String oggetto, Date data, String userMittente, String nomeMittente, String cognomeMittente,
			byte[] allegato) {
		super();
		this.oggetto = oggetto;
		this.data = data;
		this.userMittente = userMittente;
		this.nomeMittente = nomeMittente;
		this.cognomeMittente = cognomeMittente;
		this.allegato = allegato;
	}
	public String getOggetto() {
		return oggetto;
	}
	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getUserMittente() {
		return userMittente;
	}
	public void setUserMittente(String userMittente) {
		this.userMittente = userMittente;
	}
	public String getNomeMittente() {
		return nomeMittente;
	}
	public void setNomeMittente(String nomeMittente) {
		this.nomeMittente = nomeMittente;
	}
	public String getCognomeMittente() {
		return cognomeMittente;
	}
	public void setCognomeMittente(String cognomeMittente) {
		this.cognomeMittente = cognomeMittente;
	}
	public byte[] getAllegato() {
		return allegato;
	}
	public void setAllegato(byte[] allegato) {
		this.allegato = allegato;
	}
	
	
}
