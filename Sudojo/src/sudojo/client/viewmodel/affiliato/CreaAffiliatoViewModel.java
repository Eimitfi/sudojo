package sudojo.client.viewmodel.affiliato;

import java.util.ArrayList;
import java.util.Collection;

import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class CreaAffiliatoViewModel extends AbstractViewModel implements CreaAffiliatoViewModelInterface{
	
	private Collection<Observer<Subject>> observers;
	
	public CreaAffiliatoViewModel() {
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
	public Credenziali creaAffiliato(Affiliato affiliato) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Credenziali creaAffiliato(Affiliato affialito, PersonaEsterna genitore) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Credenziali creaAffialito(Affiliato affiliato, PersonaEsterna genitore1, PersonaEsterna genitore2) {
		// TODO Auto-generated method stub
		return null;
	}

}
