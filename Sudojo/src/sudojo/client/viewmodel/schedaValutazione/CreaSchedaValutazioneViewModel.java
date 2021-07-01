package sudojo.client.viewmodel.schedaValutazione;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;

import sudojo.client.model.budopass.SchedaValutazione;
import sudojo.client.model.net.Argomento;
import sudojo.client.model.net.Comando;
import sudojo.client.model.net.Request;
import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class CreaSchedaValutazioneViewModel extends AbstractViewModel implements CreaSchedaValutazioneViewModelInterface{
	private Collection<Observer<Subject>> observers;
	
	public CreaSchedaValutazioneViewModel() {
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
	
	@Override
	public void creaSchedaValutazione(SchedaValutazione scheda) throws IOException {
		Gson g = new Gson();
		Argomento argomento = new Argomento("scheda", g.toJson(scheda));
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(argomento);
		this.request(new Request(Comando.CREA_SCHEDA, args));
	}
	

}
