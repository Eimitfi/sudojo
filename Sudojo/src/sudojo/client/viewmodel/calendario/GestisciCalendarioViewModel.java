package sudojo.client.viewmodel.calendario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;

import sudojo.client.model.gestioneCalendario.Evento;
import sudojo.client.model.net.Argomento;
import sudojo.client.model.net.Comando;
import sudojo.client.model.net.Request;
import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class GestisciCalendarioViewModel extends AbstractViewModel implements GestisciCalendarioViewModelInterface{
	private Collection<Observer<Subject>> observers;
	
	public GestisciCalendarioViewModel() {
		this.observers = new ArrayList<Observer<Subject>>();
	}

	@Override
	public boolean detach(Observer<Subject> obj) {
		return this.observers.remove(obj);
	}

	@Override
	public boolean attach(Observer<Subject> obj) {
		return this.observers.add(obj);
	}

	@Override
	public void notifyObserver() {
		for(Observer<Subject> o : this.observers)
			o.onChange(this);
		
	}
	
	private ArrayList<Argomento> getArgsFromEvent(Evento e){
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		Argomento data = new Argomento("data", e.getData().toString());
		args.add(data);
		Argomento descrizione = new Argomento("descrizione", e.getDescrizione());
		args.add(descrizione);
		Argomento luogo = new Argomento("luogo", e.getLuogo());
		args.add(luogo);
		Argomento titolo = new Argomento("data", e.getTitolo());
		args.add(titolo);
		Argomento ora = new Argomento("ora", e.getOra().toString());
		args.add(ora);
		
		return args;
	}
	
	private void esegui(Evento evento, Comando c) throws IOException {
		//ArrayList<Argomento> args = this.getArgsFromEvent(evento);
		Gson g = new Gson();
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(new Argomento("evento", g.toJson(evento)));
		this.request(new Request(c, args));
		
	}

	@Override
	public void cancellaEvento(Evento evento) throws IOException {
		// TODO Auto-generated method stub
		this.esegui(evento, Comando.CANCELLA_EVENTO);
		
		
		
	}

	@Override
	public void modificaEvento(Evento evento) throws IOException {
		// TODO Auto-generated method stub
		this.esegui(evento, Comando.MODIFICA_EVENTO);
		
	}

	@Override
	public void creaEvento(Evento evento) throws IOException {
		// TODO Auto-generated method stub
		this.esegui(evento, Comando.CREA_EVENTO);
		
	}
	



}
