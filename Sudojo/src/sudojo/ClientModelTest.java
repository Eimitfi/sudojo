package sudojo;

import java.io.IOException; 
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

import sudojo.client.model.avviso.Avviso;
import sudojo.client.model.budopass.Competizione;
import sudojo.client.model.budopass.Grado;
import sudojo.client.model.budopass.Partecipa;
import sudojo.client.model.budopass.Posizione;
import sudojo.client.model.budopass.SchedaValutazione;
import sudojo.client.model.budopass.Seminario;
import sudojo.client.model.documento.Documento;
import sudojo.client.model.gestioneAffiliato.Affiliato;
import sudojo.client.model.gestioneAffiliato.Carica;
import sudojo.client.model.gestioneAffiliato.Credenziali;
import sudojo.client.model.gestioneCalendario.Evento;
import sudojo.client.model.net.Argomento;
import sudojo.client.model.net.Comando;
import sudojo.client.model.net.HTTPSClient;
import sudojo.client.model.net.HTTPSClientInterface;
import sudojo.client.model.net.Request;
import sudojo.client.model.net.RequestInterface;
import sudojo.client.model.net.ResponseInterface;
import sudojo.client.model.pagamento.Pagamento;

public class ClientModelTest {
	private static HTTPSClientInterface sender;

	
	private static void checkAffiliatoRobe() throws IOException {
		Affiliato tmp = new Affiliato("Miro", "rajero", "Cordenons", "numTel", "Austria generica", new Date(01,01,1980), "roba@mail", "CF generico", new Credenziali("daniele",false,"daniele"), Carica.ALLIEVO, null, null);
		creaAffiliato(tmp);
		getAffiliati();
		
		tmp = new Affiliato("MiroModificato", "rajero", "Cordenons", "numTel", "Austria generica", new Date(01,01,1980), "roba@mail", "CF generico", new Credenziali("danielemodificato",false,"daniele"), Carica.ALLIEVO, null, null);
		modificaAffiliato(tmp);
		getAffiliati();
		
		rigeneraPassword("danielemodificato");
		cancellaAffiliato(tmp);
		getAffiliati();
		getLog();
	}
	
	private static void checkSituaIniziale() throws IOException {
		getLog();
		
		getAffiliati();//tutti e 3
		
		getAllievi();
		
		getBudopass("michele.dragos");
	}
	
	private static void checkBudopassRobe() throws IOException {
		aggiornaBudopass("michele.dragos", new Seminario(new Date(10,10,2010), "personax", "personax"));
		aggiornaBudopass("michele.dragos",Grado.NERA_3_DAN);
		aggiornaBudopass("michele.dragos",new Competizione("ViareggioKarateFest2019", new Date(10, 10, 2018),
				"fuoriclasse", false, "karate difficile"),Posizione.SECONDO);
		getBudopass("michele.dragos");
		getLog();
	}
	
	private static void checkCalendarioRobe() throws IOException{
		Evento e = new Evento("ClickBait", "na roba, poi vedrai", new Date(10,10,2021), new Time(1000));
		creaEvento(e);
		getEventi();
		cancellaEvento(e);
		getLog();
	}
	
	private static void checkLogin() throws IOException {
		login("paolo","paolo");
		getLog();
	}
	
	private static void checkDocumentiRobe() throws IOException {
		Documento d = new Documento("oggetto",new Date(10,10,2010),"paolo","nome: paolo","cognome che non ricordo", null);
		creaDocumento(d);
		getDocumenti();
		getLog();
	}
	
	private static void checkPagamenti() throws IOException{
		getAllPagamenti();
		getPagamentiByIscritto("michele.dragos");
		getLog();
	}
	
	/*private static void checkPresenze() throws IOException{
		getPresenze();
		getLog();
	}*/
	
	private static void checkScheda() throws IOException {
		creaSchedaValutazione(null);
		getLog();
	}
	
	
	//no avvisi, chiedi a Dragos why
	public static void main(String[] args) throws IOException {
		//situa iniziale: 1 allievo con genitore + budopass, 1 maestro, 1 direttore, 1 log  
		sender = new HTTPSClient("http://localhost:8080/Sudojo");
		checkSituaIniziale();
	}

	private static void pRes(ResponseInterface r) {
		System.out.println("--------------------------------------------------");
		System.out.println(r.getStato().toString());
		System.out.println(r.getRisultato());
		System.out.println("--------------------------------------------------");
	}
	
	private static void cancellaAffiliato(Affiliato affiliato) throws IOException {
		Argomento argomento = new Argomento("affiliato", affiliato.getCredenziali().getUsername());
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(argomento);
		RequestInterface richiesta = new Request(Comando.CANCELLA_AFFILIATO, args);
		pRes(sender.richiedi(richiesta));
	}
	private static void creaAffiliato(Affiliato affiliato) throws IOException {
		Gson g = new Gson();
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(new Argomento("affiliato", g.toJson(affiliato)));
		pRes(sender.richiedi(new Request(Comando.CREA_AFFILIATO, args)));
	}
	
	private static void modificaAffiliato(Affiliato affiliato) throws IOException {
		Gson g = new Gson();
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(new Argomento("affiliato", g.toJson(affiliato)));
		pRes(sender.richiedi(new Request(Comando.MODIFICA_AFFILIATO, args)));
	}
	
	private static void rigeneraPassword(String username) throws IOException {
		Argomento argomento = new Argomento("username", username);
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(argomento);
		pRes(sender.richiedi(new Request(Comando.RIGENERA_PSWD, args)));
	}
	
	
	private static void aggiornaBudopass(String user, Seminario s) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		Argomento username = new Argomento("user", user);
		args.add(username);
		Gson g = new Gson();
		Argomento seminario = new Argomento("seminario", g.toJson(s));
		args.add(seminario);
		pRes(sender.richiedi(new Request(Comando.AGGIORNA_BUDOPASS_SEMINARIO, args)));
	}

	
	private static void aggiornaBudopass(String user, Grado g) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		Argomento username = new Argomento("user", user);
		args.add(username);
		Gson gson = new Gson();
		Argomento grado = new Argomento("grado", gson.toJson(g));
		args.add(grado);
		pRes(sender.richiedi(new Request(Comando.AGGIORNA_BUDOPASS_GRADO, args)));
		
	}

	
	private static void aggiornaBudopass(String user, Competizione c, Posizione p) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		Argomento username = new Argomento("user", user);
		args.add(username);
		Gson g = new Gson();
		Argomento competizione = new Argomento("competizione", g.toJson(c));
		args.add(competizione);
		Argomento posizione = new Argomento("posizione", g.toJson(p));
		args.add(posizione);
		pRes(sender.richiedi(new Request(Comando.AGGIORNA_BUDOPASS_COMPETIZIONE, args)));
		
	}
	
	
	private static void getBudopass(String user) throws IOException {
		//zi mi serve anche lo user per prendere un budopass
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		Argomento username = new Argomento("user", user);
		args.add(username);
		pRes(sender.richiedi(new Request(Comando.GET_BUDO, args)));
		
	}
	
	private static void eseguiEvento(Evento evento, Comando c) throws IOException {
		Gson g = new Gson();
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(new Argomento("evento", g.toJson(evento)));
		pRes(sender.richiedi(new Request(c, args)));
	}

	
	private static void cancellaEvento(Evento evento) throws IOException {
		// TODO Auto-generated method stub
		eseguiEvento(evento, Comando.CANCELLA_EVENTO);
	}

	
	private static void modificaEvento(Evento evento) throws IOException {
		// TODO Auto-generated method stub
		eseguiEvento(evento, Comando.MODIFICA_EVENTO);
	}

	
	private static void creaEvento(Evento evento) throws IOException {
		// TODO Auto-generated method stub
		eseguiEvento(evento, Comando.CREA_EVENTO);	
	}
	
	
	private static void getEventi() throws IOException {
		// TODO Auto-generated method stub
		pRes(sender.richiedi(new Request(Comando.GET_EVENTI, null)));
	}
	
	private static void creaAvviso(Avviso avviso, Collection<String> users) throws IOException {
		// TODO Auto-generated method stub
		Gson g = new Gson();
		Argomento argomento = new Argomento("avviso", g.toJson(avviso));
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(argomento);
		Argomento utentiDestinatari = new Argomento("destinatari", g.toJson(users));
		args.add(utentiDestinatari);
		pRes(sender.richiedi(new Request(Comando.CREA_AVVISO, args)));
	}
	
	private static void creaDocumento(Documento doc) throws IOException {
		// TODO Auto-generated method stub
		Gson g = new Gson();
		Argomento argomento = new Argomento("documento", g.toJson(doc));
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(argomento);
		pRes(sender.richiedi(new Request(Comando.CREA_DOC, args)));
		
	}
	
	private static void getAvvisi() throws IOException {
		// TODO Auto-generated method stub
		pRes(sender.richiedi(new Request(Comando.GET_AVVISI, null)));
	}
	
	private static void getDocumenti() throws IOException {
		// TODO Auto-generated method stub
		pRes(sender.richiedi(new Request(Comando.GET_DOC, null)));	
	}
	
	private static void getLog() throws IOException {
		// TODO Auto-generated method stub
		pRes(sender.richiedi(new Request(Comando.LOG, null)));
		
	}
	
	private static void login(String user, String pswd) throws IOException {
		// TODO Auto-generated method stub
		Argomento username = new Argomento("username", user);
		Argomento password = new Argomento("password", pswd);
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(username);
		args.add(password);
		pRes(sender.richiedi(new Request(Comando.LOGIN, args)));
		
	}

	
	private static void cambiaPassword(String user, String pswd) throws IOException {
		// TODO Auto-generated method stub
		Argomento username = new Argomento("username", user);
		Argomento password = new Argomento("password", pswd);
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(username);
		args.add(password);
		pRes(sender.richiedi(new Request(Comando.CAMBIA_PSWD, args)));
	}
	
	private static void getAffiliati() throws IOException {
		// TODO Auto-generated method stub
		pRes(sender.richiedi(new Request(Comando.GET_AFFILIATI, null)));
		
	}
	
	private static void getAllievi() throws IOException {
		// TODO Auto-generated method stub
		pRes(sender.richiedi(new Request(Comando.GET_ALLIEVI, null)));
		
	}
	
	private static void getIscritti() throws IOException {
		// TODO Auto-generated method stub
		pRes(sender.richiedi(new Request(Comando.GET_ISCRITTI, null)));
	}
	
	
	private static void getAllPagamenti() throws IOException {
		Request request = new Request(Comando.ALL_PAGAMENTI, null);
		pRes(sender.richiedi(request));
	}

	
	private static void getPagamentiByIscritto(String iscritto) throws IOException {
		ArrayList<Argomento> argomenti = new ArrayList<Argomento>();
		Argomento arg = new Argomento("iscritto", iscritto);
		argomenti.add(arg);
		Request request = new Request(Comando.PAGAMENTI_BY_ISCRITTO, argomenti);
		pRes(sender.richiedi(request));
	}
	
	
	private static void getPresenze() throws IOException {
		// TODO Auto-generated method stub
		pRes(sender.richiedi(new Request(Comando.PRESENZE, null)));
		
	}
	
	
	private static void generaRicevute(List<Pagamento> pagamenti) throws IOException {
		// TODO Auto-generated method stub
		Gson g = new Gson();
		Argomento argomento = new Argomento("pagamenti", g.toJson(pagamenti));
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(argomento);
		pRes(sender.richiedi(new Request(Comando.CREA_RICEVUTE, args)));
	}
	
	
	private static void creaSchedaValutazione(SchedaValutazione scheda) throws IOException {
		Gson g = new Gson();
		Argomento argomento = new Argomento("scheda", g.toJson(scheda));
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(argomento);
		pRes(sender.richiedi(new Request(Comando.CREA_SCHEDA, args)));
	}
	
}
