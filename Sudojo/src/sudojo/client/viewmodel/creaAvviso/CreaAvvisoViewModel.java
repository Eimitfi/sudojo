package sudojo.client.viewmodel.creaAvviso;

import java.util.ArrayList;
import java.util.Collection;

import sudojo.client.model.avviso.Avviso;
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
		for(Observer o : this.observers)
			o.onChange(this);
		
	}
	
	@Override
	public boolean creaAvviso(Avviso avviso, Collection<String> users) {
		// TODO Auto-generated method stub
		return false;
	}

}
