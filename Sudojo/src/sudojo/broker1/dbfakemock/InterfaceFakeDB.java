package sudojo.broker1.dbfakemock;

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
import sudojo.broker1.dbfakemock.model.gestioneAffiliato.Credenziali;
import sudojo.broker1.dbfakemock.model.gestioneAffiliato.Presenza;
import sudojo.broker1.dbfakemock.model.gestioneCalendario.Evento;
import sudojo.broker1.dbfakemock.model.log.Log;
import sudojo.broker1.dbfakemock.model.pagamento.Pagamento;
import sudojo.broker1.dbfakemock.model.pagamento.Ricevuta;


public interface InterfaceFakeDB {
	public Log getLog();
	public ElencoAllievi getAllievi();
	public List<Pagamento> getAllPagamenti();
	public List<Pagamento> getPagamentiByIscritto(String username);
	public List<Evento> getEventi();
	public boolean creaEvento(Evento e);
	public boolean modificaEvento(Evento e);
	public boolean eliminaEvento(Evento e);
	public boolean creaAvviso(Avviso a);
	public List<Documento> getDoc();
	public boolean creaAffiliato(Affiliato a);
	public boolean cancellaAffiliato(String user);
	public boolean modificaAffiliato(Affiliato a);
	public Credenziali rigeneraPassword(String user);
	public ElencoAffiliati getAffiliati();
	public boolean login(String nomeUtente, String password);
	public boolean cambiaPassword(String nomeUtente, String nuovaPassword);
	public ElencoIscritti getIscritti();
	public boolean creaScheda(SchedaValutazione sv);
	public List<Avviso> getAvvisi();
	public boolean creaDoc(Documento documento);
	public Budopass getBudo(String username);
	public List<Presenza> getPresenze();
	public boolean aggiornaBudopass(String iscritto, Seminario s);
	public boolean aggiornaBudopass(String iscritto, Grado g);
	public boolean aggiornaBudopass(String iscritto, Competizione c, Posizione p);
	public List<Ricevuta> creaRicevute(List<Pagamento> pagamenti);
	

}
