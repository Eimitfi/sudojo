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
import sudojo.client.model.budopass.Posizione;
import sudojo.client.model.budopass.SchedaValutazione;
import sudojo.client.model.budopass.Seminario;
import sudojo.client.model.documento.Documento;
import sudojo.client.model.gestioneAffiliato.Affiliato;
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
	private Gson g = new Gson();
	private static HTTPSClientInterface sender;
	public static void main(String[] args) throws IOException {
		ArrayList<Argomento> args1;
		//situa iniziale: 1 allievo con genitore + budopass, 1 maestro, 1 direttore, 1 log  
		sender = new HTTPSClient("http://localhost:8080/Sudojo");
		//log check
		System.out.println(sender.richiedi(new Request(Comando.LOG,null)).getRisultato());
		//budo check
		args1 = new ArrayList<Argomento>();
		Argomento username = new Argomento("user", "michele.Dragos");
		args1.add(username);
		System.out.println(sender.richiedi(new Request(Comando.GET_BUDO, args1)));

	}

	private void pRes(ResponseInterface r) {
		System.out.println("--------------------------------------------------");
		System.out.println(r.getStato().toString());
		System.out.println(r.getRisultato());
		System.out.println("--------------------------------------------------");
	}
	
	private void cancellaAffiliato(Affiliato affiliato) throws IOException {
		Argomento argomento = new Argomento("affiliato", affiliato.getCredenziali().getUsername());
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(argomento);
		RequestInterface richiesta = new Request(Comando.CANCELLA_AFFILIATO, args);
		pRes(sender.richiedi(richiesta));
	}
	private void creaAffiliato(Affiliato affiliato) throws IOException {
		Gson g = new Gson();
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(new Argomento("affiliato", g.toJson(affiliato)));
		pRes(sender.richiedi(new Request(Comando.CREA_AFFILIATO, args)));
	}
	
	private void modificaAffiliato(Affiliato affiliato) throws IOException {
		Gson g = new Gson();
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(new Argomento("affiliato", g.toJson(affiliato)));
		pRes(sender.richiedi(new Request(Comando.MODIFICA_AFFILIATO, args)));
	}
	
	public void rigeneraPassword(String username) throws IOException {
		Argomento argomento = new Argomento("username", username);
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(argomento);
		pRes(sender.richiedi(new Request(Comando.RIGENERA_PSWD, args)));
	}
	
	
	public void aggiornaBudopass(String user, Seminario s) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		Argomento username = new Argomento("user", user);
		args.add(username);
		Gson g = new Gson();
		Argomento seminario = new Argomento("seminario", g.toJson(s));
		args.add(seminario);
		pRes(sender.richiedi(new Request(Comando.AGGIORNA_BUDOPASS_SEMINARIO, args)));
	}

	
	public void aggiornaBudopass(String user, Grado g) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		Argomento username = new Argomento("user", user);
		args.add(username);
		Gson gson = new Gson();
		Argomento grado = new Argomento("grado", gson.toJson(g));
		args.add(grado);
		pRes(sender.richiedi(new Request(Comando.AGGIORNA_BUDOPASS_GRADO, args)));
		
	}

	
	public void aggiornaBudopass(String user, Competizione c, Posizione p) throws IOException {
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
	
	
	public void getBudopass(String user) throws IOException {
		//zi mi serve anche lo user per prendere un budopass
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		Argomento username = new Argomento("user", user);
		args.add(username);
		pRes(sender.richiedi(new Request(Comando.GET_BUDO, args)));
		
	}
	
	private void eseguiEvento(Evento evento, Comando c) throws IOException {
		Gson g = new Gson();
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(new Argomento("evento", g.toJson(evento)));
		pRes(sender.richiedi(new Request(c, args)));
	}

	
	public void cancellaEvento(Evento evento) throws IOException {
		// TODO Auto-generated method stub
		this.eseguiEvento(evento, Comando.CANCELLA_EVENTO);
	}

	
	public void modificaEvento(Evento evento) throws IOException {
		// TODO Auto-generated method stub
		this.eseguiEvento(evento, Comando.MODIFICA_EVENTO);
	}

	
	public void creaEvento(Evento evento) throws IOException {
		// TODO Auto-generated method stub
		this.eseguiEvento(evento, Comando.CREA_EVENTO);	
	}
	
	
	public void getEventi() throws IOException {
		// TODO Auto-generated method stub
		pRes(sender.richiedi(new Request(Comando.GET_EVENTI, null)));
	}
	
	public void creaAvviso(Avviso avviso, Collection<String> users) throws IOException {
		// TODO Auto-generated method stub
		Gson g = new Gson();
		Argomento argomento = new Argomento("avviso", g.toJson(avviso));
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(argomento);
		Argomento utentiDestinatari = new Argomento("destinatari", g.toJson(users));
		args.add(utentiDestinatari);
		pRes(sender.richiedi(new Request(Comando.CREA_AVVISO, args)));
	}
	
	public void creaDocumento(Documento doc) throws IOException {
		// TODO Auto-generated method stub
		Gson g = new Gson();
		Argomento argomento = new Argomento("documento", g.toJson(doc));
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(argomento);
		pRes(sender.richiedi(new Request(Comando.CREA_DOC, args)));
		
	}
	
	public void getAvvisi() throws IOException {
		// TODO Auto-generated method stub
		pRes(sender.richiedi(new Request(Comando.GET_AVVISI, null)));
	}
	
	public void getDocumenti() throws IOException {
		// TODO Auto-generated method stub
		pRes(sender.richiedi(new Request(Comando.GET_DOC, null)));	
	}
	
	public void getLog() throws IOException {
		// TODO Auto-generated method stub
		pRes(sender.richiedi(new Request(Comando.LOG, null)));
		
	}
	
	public void login(String user, String pswd) throws IOException {
		// TODO Auto-generated method stub
		Argomento username = new Argomento("username", user);
		Argomento password = new Argomento("password", pswd);
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(username);
		args.add(password);
		pRes(sender.richiedi(new Request(Comando.LOGIN, args)));
		
	}

	
	public void cambiaPassword(String user, String pswd) throws IOException {
		// TODO Auto-generated method stub
		Argomento username = new Argomento("username", user);
		Argomento password = new Argomento("password", pswd);
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(username);
		args.add(password);
		pRes(sender.richiedi(new Request(Comando.CAMBIA_PSWD, args)));
	}
	
	public void getAffiliati() throws IOException {
		// TODO Auto-generated method stub
		pRes(sender.richiedi(new Request(Comando.GET_AFFILIATI, null)));
		
	}
	
	public void getAllievi() throws IOException {
		// TODO Auto-generated method stub
		pRes(sender.richiedi(new Request(Comando.GET_ALLIEVI, null)));
		
	}
	
	public void getIscritti() throws IOException {
		// TODO Auto-generated method stub
		pRes(sender.richiedi(new Request(Comando.GET_ISCRITTI, null)));
	}
	
	
	public void getAllPagamenti() throws IOException {
		Request request = new Request(Comando.ALL_PAGAMENTI, null);
		pRes(sender.richiedi(request));
	}

	
	public void getPagamentiByIscritto(String iscritto) throws IOException {
		ArrayList<Argomento> argomenti = new ArrayList<Argomento>();
		Argomento arg = new Argomento("iscritto", iscritto);
		argomenti.add(arg);
		Request request = new Request(Comando.PAGAMENTI_BY_ISCRITTO, argomenti);
		pRes(sender.richiedi(request));
	}
	
	
	public void getPresenze() throws IOException {
		// TODO Auto-generated method stub
		pRes(sender.richiedi(new Request(Comando.PRESENZE, null)));
		
	}
	
	
	public void generaRicevute(List<Pagamento> pagamenti) throws IOException {
		// TODO Auto-generated method stub
		Gson g = new Gson();
		Argomento argomento = new Argomento("pagamenti", g.toJson(pagamenti));
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(argomento);
		pRes(sender.richiedi(new Request(Comando.CREA_RICEVUTE, args)));
	}
	
	
	public void creaSchedaValutazione(SchedaValutazione scheda) throws IOException {
		Gson g = new Gson();
		Argomento argomento = new Argomento("scheda", g.toJson(scheda));
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(argomento);
		pRes(sender.richiedi(new Request(Comando.CREA_SCHEDA, args)));
	}
	
}
