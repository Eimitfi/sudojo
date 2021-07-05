package sudojo.broker1.sessione;

import java.util.Date;

import sudojo.broker1.dbfakemock.model.gestioneAffiliato.Persona;

public interface ISessione {
	public Ruolo getRuolo();
	public Date getDataScadenza();
	public Date getDataInizio();
	public Persona getPersona();
}
