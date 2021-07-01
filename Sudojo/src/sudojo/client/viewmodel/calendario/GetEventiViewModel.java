package sudojo.client.viewmodel.calendario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import sudojo.client.model.gestioneCalendario.Evento;
import sudojo.client.model.net.Comando;
import sudojo.client.model.net.Request;
import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class GetEventiViewModel extends AbstractViewModel implements GetEventiViewModelInterface {
	private Collection<Observer<Subject>> observers;
	
	public GetEventiViewModel() {
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
	public void getEventi() throws IOException {
		// TODO Auto-generated method stub
		this.request(new Request(Comando.GET_EVENTI, null));
		
	}
	



}
