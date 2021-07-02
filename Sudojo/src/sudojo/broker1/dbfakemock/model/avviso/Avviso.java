package sudojo.broker1.dbfakemock.model.avviso;

import java.util.List;

public class Avviso {
	private String oggetto;
	private String descrizione;
	private List<byte[]> allegato;
	
	
	
	public Avviso(String oggetto, String descrizione, List<byte[]> allegato) {
		super();
		this.oggetto = oggetto;
		this.descrizione = descrizione;
		this.allegato = allegato;
	}
	public String getOggetto() {
		return oggetto;
	}
	public void setOggetto(String oggetto) {
		this.oggetto = oggetto;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public List<byte[]> getAllegato() {
		return allegato;
	}
	public void setAllegato(List<byte[]> allegato) {
		this.allegato = allegato;
	}
	
	
}
