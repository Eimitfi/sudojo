package sudojo.client.viewmodel.budopass;

import java.util.ArrayList;
import java.util.Collection;

import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class AggiornaBudopassViewModel extends AbstractViewModel implements AggiornaBudopassViewModelInterface{

	private Collection<Observer<Subject>> observers;
	
	public AggiornaBudopassViewModel() {
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
	public boolean aggiornaBudopass(String user, Seminario s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean aggiornaBudopass(String user, Grado g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean aggiornaBudopass(String user, Competizione c, Posizione p) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
