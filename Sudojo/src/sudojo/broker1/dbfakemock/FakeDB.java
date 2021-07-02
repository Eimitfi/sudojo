package sudojo.broker1.dbfakemock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sudojo.broker1.dbfakemock.model.avviso.Avviso;
import sudojo.broker1.dbfakemock.model.budopass.Budopass;
import sudojo.broker1.dbfakemock.model.budopass.Competizione;
import sudojo.broker1.dbfakemock.model.budopass.Grado;
import sudojo.broker1.dbfakemock.model.budopass.Posizione;
import sudojo.broker1.dbfakemock.model.budopass.SchedaValutazione;
import sudojo.broker1.dbfakemock.model.budopass.Seminario;
import sudojo.broker1.dbfakemock.model.documento.Documento;
import sudojo.broker1.dbfakemock.model.elenchi.ElencoAffiliati;
import sudojo.broker1.dbfakemock.model.elenchi.ElencoAllievi;
import sudojo.broker1.dbfakemock.model.elenchi.ElencoIscritti;
import sudojo.broker1.dbfakemock.model.gestioneAffiliato.Affiliato;
import sudojo.broker1.dbfakemock.model.gestioneAffiliato.Carica;
import sudojo.broker1.dbfakemock.model.gestioneAffiliato.Credenziali;
import sudojo.broker1.dbfakemock.model.gestioneAffiliato.PersonaEsterna;
import sudojo.broker1.dbfakemock.model.gestioneAffiliato.Presenza;
import sudojo.broker1.dbfakemock.model.gestioneCalendario.Evento;
import sudojo.broker1.dbfakemock.model.log.Log;
import sudojo.broker1.dbfakemock.model.pagamento.Pagamento;
import sudojo.broker1.dbfakemock.model.pagamento.Ricevuta;

public class FakeDB implements InterfaceFakeDB{
	private ArrayList<Affiliato> affiliati;
	
	
	public FakeDB() {
		PersonaEsterna genitore = new PersonaEsterna("Ugo", "Dragos", "Via Indipendenza 7", "123", "Foggia", new Date(10, 10, 1980), "ugodragos@hotmail.com", "CC")

		Affiliato maestro = new Affiliato("Federico", "Santarossa", "Via Maschia 4A", "3456716706", "Mosca", new Date(10, 5, 1981), "fedesanta@email.net", "FDRSNT81E10G888M", new Credenziali("federico", false, "federico"), Carica.MAESTRO, null,null);
		Affiliato allievo = new Affiliato("Michele", "Dragos", "Via Indipendenza 7", "3456716700", "Milano", new Date(10, 10, 2002), "dragos@email.net", "MICDRG02J10G888M", new Credenziali("michele.dragos", false, "password"), Carica.ALLIEVO, genitore,null);
		Affiliato direttore = new Affiliato("Paolo", "Pierobon", "Via del Beccacino 4A", "3456716705", "Foggia", new Date(12, 4, 1980), "paolopierobon@email.net", "PAOPBN80D12G888M", new Credenziali("paolo", false, "paolo"), Carica.DIRETTORE, null,null);
		
		
	}

	@Override
	public Log getLog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElencoAllievi getAllievi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pagamento> getAllPagamenti() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pagamento> getPagamentiByIscritto(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evento> getEventi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean creaEvento(Evento e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificaEvento(Evento e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminaEvento(Evento e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean creaAvviso(Avviso a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Documento> getDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean creaAffiliato(Affiliato a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancellaAffiliato(String user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificaAffiliato(Affiliato a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Credenziali rigeneraPassword(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElencoAffiliati getAffiliati() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(String nomeUtente, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cambiaPassword(String nomeUtente, String nuovaPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ElencoIscritti getIscritti() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean creaScheda(SchedaValutazione sv) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Avviso> getAvvisi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean creaDoc(Documento documento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Budopass getBudo(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Presenza> getPresenze() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean aggiornaBudopass(String iscritto, Seminario s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean aggiornaBudopass(String iscritto, Grado g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean aggiornaBudopass(String iscritto, Competizione c, Posizione p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Ricevuta> creaRicevute(List<Pagamento> pagamenti) {
		// TODO Auto-generated method stub
		return null;
	}

}
