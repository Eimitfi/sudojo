package sudojo.broker1.sessione;

import java.util.Date;

public interface ISessione {
	public Ruolo getRuolo();
	public Date getDataScadenza();
	public Date getDataInizio();
	public Persona getPersona();

}