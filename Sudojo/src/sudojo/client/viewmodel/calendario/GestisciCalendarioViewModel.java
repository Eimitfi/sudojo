package sudojo.client.viewmodel.calendario;

import java.util.ArrayList;
import java.util.Collection;

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
		for(Observer o : this.observers)
			o.onChange(this);
		
	}
	
	@Override
	public boolean cancellaEvento(Evento evento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificaEvento(Evento evento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean creaEvento(Evento evento) {
		// TODO Auto-generated method stub
		return false;
	}

}
