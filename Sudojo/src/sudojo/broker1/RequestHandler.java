package sudojo.broker1;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import sudojo.broker1.dbfakemock.FakeDB;
import sudojo.broker1.dbfakemock.InterfaceFakeDB;
import sudojo.broker1.dbfakemock.model.budopass.Competizione;
import sudojo.broker1.dbfakemock.model.budopass.Grado;
import sudojo.broker1.dbfakemock.model.budopass.Posizione;
import sudojo.broker1.dbfakemock.model.budopass.SchedaValutazione;
import sudojo.broker1.dbfakemock.model.budopass.Seminario;
import sudojo.broker1.dbfakemock.model.documento.Documento;
import sudojo.broker1.dbfakemock.model.gestioneCalendario.Evento;
import sudojo.broker1.dbfakemock.model.login.StatoLogin;
import sudojo.broker1.dbfakemock.model.pagamento.Pagamento;

@SuppressWarnings("deprecation")
public class RequestHandler extends HttpServlet implements SingleThreadModel,HTTPSBrokerInterface{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Gson g;
	private JSONUtil j;
	private InterfaceFakeDB db;
	
	public void init(ServletConfig config) throws ServletException {
		this.db = new FakeDB();
		this.g = new Gson();
		this.j = new JSONUtil();
	}
	//debug only
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.getWriter().write("prova");
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("application/json");
		handleRequest(req,res);
	}

	private Response errorHelp(Response res,String txt) {
		res.setStato(Stato.EXCEPTION);
		res.setException(txt);
		return res;
	}
	
	private ResponseInterface dispatch(RequestInterface req) {
		Response res = new Response(req.getComando());
		Argomento u;
		Argomento c;
		Argomento p;
		switch(req.getComando()) {
		case AGGIORNA_BUDOPASS_COMPETIZIONE:
			c = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("competizione")).findAny().orElse(null);
			p = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("posizione")).findAny().orElse(null);
			u = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("user")).findAny().orElse(null);
			if(c != null && p != null && u != null) {
				boolean r = this.db.aggiornaBudopass(u.getValore(), g.fromJson(c.getValore(), Competizione.class), g.fromJson(p.getValore(), Posizione.class));
				if(!r) {
					res = errorHelp(res,"Error in updating Budopass");
				}
			}else {
				res = errorHelp(res,"bad arguments");
			}
			break;
		case AGGIORNA_BUDOPASS_GRADO:
			p = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("grado")).findAny().orElse(null);
			u = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("user")).findAny().orElse(null);
			if(p != null && u != null) {
				boolean r = this.db.aggiornaBudopass(u.getValore(), g.fromJson(p.getValore(), Grado.class));
				if(!r) {
					res = errorHelp(res,"Error in updating Budopass");
				}
			}else {
				res = errorHelp(res,"bad arguments");
			}
			break;
		case AGGIORNA_BUDOPASS_SEMINARIO:
			p = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("seminario")).findAny().orElse(null);
			u = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("user")).findAny().orElse(null);
			if(p != null && u != null) {
				boolean r = this.db.aggiornaBudopass(u.getValore(), g.fromJson(p.getValore(), Seminario.class));
				if(!r) {
					res = errorHelp(res,"Error in updating Budopass");
				}
			}else {
				res = errorHelp(res,"bad arguments");
			}
			break;
		case ALL_PAGAMENTI:
			res.setRisultato(g.toJson(this.db.getAllPagamenti()));
			break;
		case CAMBIA_PSWD:
			p = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("password")).findAny().orElse(null);
			u = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("user")).findAny().orElse(null);
			if(p != null && u != null) {
				boolean r = this.db.cambiaPassword(u.getValore(), p.getValore());
				if(!r) {
					res = errorHelp(res,"Error in updating password");
				}
			}else {
				res = errorHelp(res,"bad arguments");
			}
			break;
		case CANCELLA_AFFILIATO:
			u = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("affiliato")).findAny().orElse(null);
			if(u != null) {
				boolean r = this.db.cancellaAffiliato(u.getValore());
				if(!r) {
					res = errorHelp(res,"Error in deleting the affiliato");
				}
			}else {
				res = errorHelp(res,"bad arguments");
			}
			break;
		case CANCELLA_EVENTO:
			p = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("evento")).findAny().orElse(null);
			if(p != null) {
				boolean r = this.db.eliminaEvento(g.fromJson(p.getValore(), Evento.class));
				if(!r) {
					res = errorHelp(res,"Error in deleting the event");
				}
			}else {
				res = errorHelp(res,"bad arguments");
			}
			break;
		case CREA_AFFILIATO:
			u = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("affiliato")).findAny().orElse(null);
			if(u != null) {
				boolean r = this.db.creaAffiliato(g.fromJson(u.getValore(), sudojo.broker1.dbfakemock.model.gestioneAffiliato.Affiliato.class));
				if(!r) {
					res = errorHelp(res,"Error in creating the affiliato");
				}
			}else {
				res = errorHelp(res,"bad arguments");
			}
			break;
		case CREA_AVVISO:
			//TODO
			break;
		case CREA_DOC:
			c = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("documento")).findAny().orElse(null);
			if(c != null) {
				boolean r = this.db.creaDoc(g.fromJson(c.getValore(), Documento.class));
				if(!r) {
					res = errorHelp(res,"Error in creating document");
				}
			}else {
				res = errorHelp(res,"bad arguments");
			}
			break;
		case CREA_EVENTO:
			p = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("evento")).findAny().orElse(null);
			if(p != null) {
				boolean r = this.db.creaEvento(g.fromJson(p.getValore(), Evento.class));
				if(!r) {
					res = errorHelp(res,"Error in creating the event");
				}
			}else {
				res = errorHelp(res,"bad arguments");
			}
			break;
		case CREA_RICEVUTE:
			u = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("pagamenti")).findAny().orElse(null);
			if(u != null) {
				Pagamento[] pag= g.fromJson(u.getValore(),Pagamento[].class);
				res.setRisultato(g.toJson(this.db.creaRicevute(Arrays.asList(pag))));
			}else {
				res = errorHelp(res,"bad arguments");
			}
			break;
		case CREA_SCHEDA:
			p = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("scheda")).findAny().orElse(null);
			if(p != null) {
				boolean r = this.db.creaScheda(g.fromJson(p.getValore(), SchedaValutazione.class));
				if(!r) {
					res = errorHelp(res,"Error in creating the event");
				}
			}else {
				res = errorHelp(res,"bad arguments");
			}
			break;
		case GET_AFFILIATI:
			res.setRisultato(g.toJson(this.db.getAffiliati()));
			break;
		case GET_ALLIEVI:
			res.setRisultato(g.toJson(this.db.getAllievi()));
			break;
		case GET_AVVISI:
			res.setRisultato(g.toJson(this.db.getAvvisi()));
			break;
		case GET_BUDO:
			u = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("user")).findAny().orElse(null);
			if(u != null) {
				res.setRisultato(g.toJson(this.db.getBudo(u.getValore())));
			}else {
				res = errorHelp(res,"bad arguments");
			}
			break;
		case GET_DOC:
			res.setRisultato(g.toJson(this.db.getDoc()));
			break;
		case GET_EVENTI:
			res.setRisultato(g.toJson(this.db.getEventi()));
			break;
		case GET_ISCRITTI:
			res.setRisultato(g.toJson(this.db.getIscritti()));
			break;
		case LOG:
			res.setRisultato(g.toJson(this.db.getLog()));
			break;
		case LOGIN:
			p = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("password")).findAny().orElse(null);
			u = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("user")).findAny().orElse(null);
			if(p != null && u != null) {
				StatoLogin r = this.db.login(u.getValore(), p.getValore());
				res.setRisultato(g.toJson(r));
			}else {
				res = errorHelp(res,"bad arguments");
			}
			break;
		case MODIFICA_AFFILIATO:
			u = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("affiliato")).findAny().orElse(null);
			if(u != null) {
				boolean r = this.db.modificaAffiliato(g.fromJson(u.getValore(), sudojo.broker1.dbfakemock.model.gestioneAffiliato.Affiliato.class));
				if(!r) {
					res = errorHelp(res,"Error in updating the affiliato");
				}
			}else {
				res = errorHelp(res,"bad arguments");
			}
			break;
		case MODIFICA_EVENTO:
			p = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("evento")).findAny().orElse(null);
			if(p != null) {
				boolean r = this.db.modificaEvento(g.fromJson(p.getValore(), Evento.class));
				if(!r) {
					res = errorHelp(res,"Error in updating the event");
				}
			}else {
				res = errorHelp(res,"bad arguments");
			}
			break;
		case PAGAMENTI_BY_ISCRITTO:
			u = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("iscritto")).findAny().orElse(null);
			if(u != null) {
				res.setRisultato(g.toJson(this.db.getPagamentiByIscritto(u.getValore())));
			}else {
				res = errorHelp(res,"bad arguments");
			}
			break;
		case PRESENZE:
			res.setRisultato(g.toJson(this.db.getAllPagamenti()));
			break;
		case RIGENERA_PSWD:
			u = req.getArgomenti().stream().filter(a -> a.getNome().equalsIgnoreCase("username")).findAny().orElse(null);
			if(u != null) {
				res.setRisultato(g.toJson(this.db.rigeneraPassword(u.getValore())));
			}else {
				res = errorHelp(res,"bad arguments");
			}
			break;
		default:
			res = errorHelp(res,"bad command");
			break;
		
		}
		return res;
	}
	
	@Override
	public void handleRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String richiesta = req.getParameter("richiesta");
		RequestInterface r = j.jsonDeserialize(richiesta);
		
		res.getWriter().write(this.j.jsonSerialize(dispatch(r)));
		return;
		
	}
	


}