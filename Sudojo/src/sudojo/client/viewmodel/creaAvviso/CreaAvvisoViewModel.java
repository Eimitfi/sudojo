package sudojo.client.viewmodel.creaAvviso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;

import sudojo.client.model.avviso.Avviso;
import sudojo.client.model.net.Argomento;
import sudojo.client.model.net.Comando;
import sudojo.client.model.net.Request;
import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class CreaAvvisoViewModel extends AbstractViewModel implements CreaAvvisoViewModelInterface{
	private Collection<Observer<Subject>> observers;
	
	public CreaAvvisoViewModel() {
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
	public void creaAvviso(Avviso avviso, Collection<String> users) throws IOException {
		// TODO Auto-generated method stub
		Gson g = new Gson();
		Argomento argomento = new Argomento("avviso", g.toJson(avviso));
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(argomento);
		Argomento utentiDestinatari = new Argomento("destinatari", g.toJson(users));
		args.add(utentiDestinatari);
		this.request(new Request(Comando.CREA_AVVISO, args));
	}
	



}
