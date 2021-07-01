package sudojo.broker1.sessione;

import java.util.Date;

public class Sessione implements ISessione{
	private String utente;
	private Date dataInizio;
	private Date dataScadenza;
	
	public Ruolo getRuolo() {
		return null;
		
	}
	
	public Persona getPersona() {
		
	}
	
	public Date getDataInizio() {
		return this.dataInizio;
	}
	
	public Date getDataScadenza() {
		return this.dataScadenza;
	}
}
