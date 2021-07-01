package sudojo.broker2.model.avviso;

import java.util.List;

public class Avviso {
	private String oggetto;
	private String descrizione;
	private List<byte[]> allegato;
	
	
	//btw sono le 17.27 di gioved� 1, io x oggi stacco
	//non dovrebbe mancare molto: le view e i mock nel broker1 e poi � finito
	//ma patella quando ci dice la data dell'orale?
	
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
