package sudojo.broker1.dbfakemock;

import java.sql.Time;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sudojo.broker1.dbfakemock.model.avviso.Avviso;
import sudojo.broker1.dbfakemock.model.budopass.Budopass;
import sudojo.broker1.dbfakemock.model.budopass.Competizione;
import sudojo.broker1.dbfakemock.model.budopass.Grado;
import sudojo.broker1.dbfakemock.model.budopass.Partecipa;
import sudojo.broker1.dbfakemock.model.budopass.Posizione;
import sudojo.broker1.dbfakemock.model.budopass.SchedaValutazione;
import sudojo.broker1.dbfakemock.model.budopass.Seminario;
import sudojo.broker1.dbfakemock.model.budopass.StoricoGrado;
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
import sudojo.broker1.dbfakemock.model.log.Entry;
import sudojo.broker1.dbfakemock.model.log.Log;
import sudojo.broker1.dbfakemock.model.login.StatoLogin;
import sudojo.broker1.dbfakemock.model.pagamento.Pagamento;
import sudojo.broker1.dbfakemock.model.pagamento.Ricevuta;

public class FakeDB implements InterfaceFakeDB {
	private ArrayList<Affiliato> affiliati;
	private ArrayList<Budopass> allBudos;
	private ArrayList<Avviso> allAvvisi;
	private ArrayList<Documento> allDoc;
	private Log log;
	private ArrayList<Evento> calendario;
	private ArrayList<Pagamento> allPagamenti;

	public FakeDB() {
		allDoc = new ArrayList<Documento>();

		allPagamenti = new ArrayList<Pagamento>();

		allPagamenti.add(new Pagamento(new Date(10,10,2021), Period.ofDays(100), 0, "dummy", "dummy", "michele.dragos", "dummy", "dummy"));

		allAvvisi = new ArrayList<Avviso>();

		calendario = new ArrayList<Evento>();

		ArrayList<Entry> entries = new ArrayList<Entry>();
		entries.add(new Entry(new Time(10, 10, 10), new Date(10, 10, 2021), "ciao"));
		log = new Log(entries);
		PersonaEsterna genitore = new PersonaEsterna("Ugo", "Dragos", "Via Indipendenza 7", "123", "Foggia",
				new Date(10, 10, 1980), "ugodragos@hotmail.com", "CC");

		Affiliato maestro = new Affiliato("Federico", "Santarossa", "Via Maschia 4A", "3456716706", "Mosca",
				new Date(10, 5, 1981), "fedesanta@email.net", "FDRSNT81E10G888M",
				new Credenziali("federico", false, "federico"), Carica.MAESTRO, null, null);
		Affiliato allievo = new Affiliato("Michele", "Dragos", "Via Indipendenza 7", "3456716700", "Milano",
				new Date(10, 10, 2002), "dragos@email.net", "MICDRG02J10G888M",
				new Credenziali("michele.dragos", false, "password"), Carica.ALLIEVO, genitore, null);
		Affiliato direttore = new Affiliato("Paolo", "Pierobon", "Via del Beccacino 4A", "3456716705", "Foggia",
				new Date(12, 4, 1980), "paolopierobon@email.net", "PAOPBN80D12G888M",
				new Credenziali("paolo", false, "paolo"), Carica.DIRETTORE, null, null);
		affiliati = new ArrayList<Affiliato>();
		affiliati.add(direttore);
		affiliati.add(allievo);
		affiliati.add(maestro);
		Partecipa partecipa = new Partecipa(new Competizione("ViareggioKarateFest2019", new Date(10, 10, 2019),
				"fuoriclasse", false, "karate difficile"), Posizione.PRIMO);
		List<Partecipa> p = new ArrayList<Partecipa>();
		p.add(partecipa);

		StoricoGrado sg = new StoricoGrado(Grado.BIANCA, new Date(10, 10, 2019));
		List<StoricoGrado> gradi = new ArrayList<StoricoGrado>();
		gradi.add(sg);

		List<Seminario> seminari = new ArrayList<Seminario>();
		seminari.add(new Seminario(new Date(10, 10, 2019), "Giorgio Mocci", "Pistoia"));

		allBudos = new ArrayList<Budopass>();
		allBudos.add(new Budopass(p, gradi, seminari, "michele.dragos"));

	}
	
	public void addEntryLog(Entry e) {
		this.log.addEntry(e);
	}
	
	public void addEntryLog(String msg) {
		Entry e = new Entry(new Time(0, 0, 0), new Date(), msg);
		this.addEntryLog(e);
	}

	@Override
	public Log getLog() {
		this.addEntryLog("Richiesta visualizzazione log");
		return this.log;
	}

	@Override
	public ElencoAllievi getAllievi() {
		this.addEntryLog("Richiesta Elenco Allievi");
		ElencoAllievi result;
		sudojo.broker1.dbfakemock.model.elenchi.Allievo allievo = new sudojo.broker1.dbfakemock.model.elenchi.Allievo(
				"ciao", "ciao", "ciao");
		ArrayList<sudojo.broker1.dbfakemock.model.elenchi.Allievo> allievi = new ArrayList<sudojo.broker1.dbfakemock.model.elenchi.Allievo>();
		for (Affiliato a : this.affiliati) {
			if (a.getCarica().equals(Carica.ALLIEVO)) {
				allievo = new sudojo.broker1.dbfakemock.model.elenchi.Allievo(a.getCredenziali().getUsername(),
						a.getNome(), a.getCognome());
				allievi.add(allievo);
			}
		}
		result = new ElencoAllievi(allievi);
		return result;
	}

	@Override
	public List<Pagamento> getAllPagamenti() {
		this.addEntryLog("Richiesta getAllPagamenti");
		return this.allPagamenti;
	}

	@Override
	public List<Pagamento> getPagamentiByIscritto(String username) {
		this.addEntryLog("Richiesta getPagamentiByIscritto");
		ArrayList<Pagamento> result = new ArrayList<Pagamento>();
		for (Pagamento p : this.allPagamenti) {
			if (p.getUserIscritto().equals(username))
				result.add(p);
		}
		return result;
	}

	@Override
	public List<Evento> getEventi() {
		this.addEntryLog("Richiesta visualizzazione calendario");
		return this.calendario;
	}

	@Override
	public boolean creaEvento(Evento e) {
		this.addEntryLog("Richiesta aggiunta evento. Titolo: "+e.getTitolo()+" luogo: "+e.getLuogo()+" ora: "+e.getOra().toString()+" data: "+e.getData().toString());
		return this.calendario.add(e);
	}

	@Override
	public boolean modificaEvento(Evento e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminaEvento(Evento e) {
		this.addEntryLog("Richiesta elimina evento. Titolo: "+e.getTitolo()+" luogo: "+e.getLuogo()+" ora: "+e.getOra().toString()+" data: "+e.getData().toString());

		for (Evento evento : this.calendario) {
			if (evento.getData().equals(e.getData()) && evento.getTitolo().equals(e.getTitolo())
					&& evento.getLuogo().equals(e.getLuogo()) && evento.getOra().equals(e.getOra())) {
				calendario.remove(calendario.indexOf(evento));
				this.addEntryLog(" EVENTO ELIMINATO\n");
				return true;
				
			}
		}
		this.addEntryLog(" EVENTO NON ELIMINATO\n");
		return false;
	}

	@Override
	public boolean creaAvviso(Avviso a) {
		this.addEntryLog("CreaAvviso: "+a.getOggetto()+" "+a.getDescrizione());
		return this.allAvvisi.add(a);
	}

	@Override
	public List<Documento> getDoc() {
		this.addEntryLog("Richiesta getDoc");
		return this.allDoc;
	}

	@Override
	public boolean creaAffiliato(Affiliato a) {
		this.addEntryLog("Richiesta creaAffiliato. Nome: "+a.getNome()+" cognome: "+a.getCognome()+ " email: "+a.getEmail()+" CF: "+a.getCF()+" residenza: "+a.getResidenza());
		return this.affiliati.add(a);
	}

	@Override
	public boolean cancellaAffiliato(String user) {
		this.addEntryLog("Richiesta cancellaAffiliato: "+user );

		for (Affiliato a : this.affiliati) {
			if (a.getCredenziali().getUsername().equals(user)) {
				this.affiliati.remove(this.affiliati.indexOf(a));
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean modificaAffiliato(Affiliato a) {
		this.addEntryLog("Richiesta creaAffiliato. Nome: "+a.getNome()+" cognome: "+a.getCognome()+ " email: "+a.getEmail()+" CF: "+a.getCF()+" residenza: "+a.getResidenza());

		boolean esito = this.cancellaAffiliato(a.getCredenziali().getUsername());
		if (esito) {
			return this.creaAffiliato(a);

		}
		return false;
	}

	@Override
	public Credenziali rigeneraPassword(String user) {
		this.addEntryLog("Richiesta RigeneraPassword: "+user );

		for (Affiliato affiliato : this.affiliati) {
			if (affiliato.getCredenziali().getUsername().equals(user)) {
				affiliato.getCredenziali().setPassword("passwordTemporanea");
				affiliato.getCredenziali().setTmp(true);
				return affiliato.getCredenziali();

			}

		}
		return null;
	}

	@Override
	public ElencoAffiliati getAffiliati() {
		this.addEntryLog("Richiesta getAffiliati");

		ElencoAffiliati result;
		sudojo.broker1.dbfakemock.model.elenchi.Affiliato affiliato;
		ArrayList<sudojo.broker1.dbfakemock.model.elenchi.Affiliato> af = new ArrayList<sudojo.broker1.dbfakemock.model.elenchi.Affiliato>();
		for (Affiliato a : this.affiliati) {

			affiliato = new sudojo.broker1.dbfakemock.model.elenchi.Affiliato(a.getCredenziali().getUsername(),
					a.getNome(), a.getCognome());
			af.add(affiliato);

		}
		result = new ElencoAffiliati(af);
		return result;
	}

	@Override
	public StatoLogin login(String nomeUtente, String password) {
		this.addEntryLog("Login. Utente: "+nomeUtente);

		for (Affiliato affiliato : this.affiliati) {
			if (affiliato.getCredenziali().getPassword().equals(password)
					&& affiliato.getCredenziali().getUsername().equals(nomeUtente)) {
				if (affiliato.getCredenziali().isTmp())
					return StatoLogin.TMP;
				this.addEntryLog(" OK\n");

				return StatoLogin.ACCETTATO;
			}
		}
		this.addEntryLog(" RIFIUTATO\n");

		return StatoLogin.RIFIUTATO;
	}

	@Override
	public boolean cambiaPassword(String nomeUtente, String nuovaPassword) {
		this.addEntryLog("Richiesta cambiaPassword: "+nomeUtente);

		for (Affiliato affiliato : this.affiliati) {
			if (affiliato.getCredenziali().getUsername().equals(nomeUtente)) {
				affiliato.getCredenziali().setPassword(nuovaPassword);
				affiliato.getCredenziali().setTmp(false);
				return true;

			}

		}
		return false;
	}

	@Override
	public ElencoIscritti getIscritti() {
		this.addEntryLog("Richiesta getIscritti");

		ElencoIscritti result;
		sudojo.broker1.dbfakemock.model.elenchi.Iscritto iscritto;
		ArrayList<sudojo.broker1.dbfakemock.model.elenchi.Iscritto> i = new ArrayList<sudojo.broker1.dbfakemock.model.elenchi.Iscritto>();
		for (Affiliato a : this.affiliati) {
			if (a.getCarica().equals(Carica.ALLIEVO) || a.getCarica().equals(Carica.MAESTRO)) {
				iscritto = new sudojo.broker1.dbfakemock.model.elenchi.Iscritto(a.getCredenziali().getUsername(),
						a.getNome(), a.getCognome());
				i.add(iscritto);
			}

		}
		result = new ElencoIscritti(i);
		return result;
	}

	@Override
	public boolean creaScheda(SchedaValutazione sv) {
		this.addEntryLog("Richiesta creaScheda");

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Avviso> getAvvisi() {
		this.addEntryLog("Richiesta getAvvisi");

		return this.allAvvisi;
	}

	@Override
	public boolean creaDoc(Documento documento) {
		this.addEntryLog("Richiesta creaDoc. Cogmome mittente:"+documento.getCognomeMittente()+" nome mittente: "+documento.getNomeMittente()+" oggetto: "+documento.getOggetto()+" user mittente: "+documento.getUserMittente());

		return this.allDoc.add(documento);
	}

	@Override
	public Budopass getBudo(String username) {
		this.addEntryLog("Richiesta getBudo: "+username);

		for (Budopass budo : this.allBudos) {
			if (budo.getIscritto().equals(username))
				return budo;
		}
		return null;
	}

	@Override
	public List<Presenza> getPresenze() {
		this.addEntryLog("Richiesta getPresenze");

		return null;
	}

	@Override
	public boolean aggiornaBudopass(String iscritto, Seminario s) {
		this.addEntryLog("Aggiunta al budopass di "+iscritto+" del seminario tenuto da "+s.getTenutario()+" a "+s.getLuogo());

		for (Budopass budo : this.allBudos) {
			if (budo.getIscritto().equals(iscritto)) {
				return budo.addSeminario(s);
			}
		}
		return false;
	}

	@Override
	public boolean aggiornaBudopass(String iscritto, Grado g) {
		this.addEntryLog("Aggiunta al budopass di "+iscritto+" del grado "+g.toString());

		for (Budopass budo : this.allBudos) {
			if (budo.getIscritto().equals(iscritto)) {
				return budo.addGrado(g);
			}
		}
		return false;
	}

	@Override
	public boolean aggiornaBudopass(String iscritto, Competizione c, Posizione p) {
		this.addEntryLog("Aggiunta al budopass di "+iscritto+" della competizione "+c.getCategoria()+" "+c.getDisciplina()+" posizione "+p.toString());

		for (Budopass budo : this.allBudos) {
			if (budo.getIscritto().equals(iscritto)) {
				return budo.addPartecipa(c, p);
			}
		}
		return false;
	}

	@Override
	public List<Ricevuta> creaRicevute(List<Pagamento> pagamenti) {
		// TODO Auto-generated method stub
		return null;
	}

}
