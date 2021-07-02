package sudojo.broker1.dbfakemock;

import java.util.List;

import sudojo.broker1.dbfakemock.model.avviso.Avviso;
import sudojo.broker1.dbfakemock.model.documento.Documento;
import sudojo.broker1.dbfakemock.model.elenchi.ElencoAffiliati;
import sudojo.broker1.dbfakemock.model.elenchi.ElencoAllievi;
import sudojo.broker1.dbfakemock.model.gestioneAffiliato.Affiliato;
import sudojo.broker1.dbfakemock.model.gestioneAffiliato.Credenziali;
import sudojo.broker1.dbfakemock.model.gestioneCalendario.Evento;
import sudojo.broker1.dbfakemock.model.log.Log;
import sudojo.broker1.dbfakemock.model.pagamento.Pagamento;

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
	
	

}
