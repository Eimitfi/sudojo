package sudojo.broker2.model.avviso;

import java.util.List;

public class Avviso {
	private String oggetto;
	private String descrizione;
	private List<byte[]> allegato;
	
	//ma a che serve sta roba in broker2?
	//ma non mockiamo tutto dal broker1 in giù? tipo che il broker1
	//ha tutti i dati mock hard-coded e ciao
	//btw sono le 17.27 di giovedì 1, io x oggi stacco
	//non dovrebbe mancare molto: le view e i mock nel broker1 e poi è finito
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
