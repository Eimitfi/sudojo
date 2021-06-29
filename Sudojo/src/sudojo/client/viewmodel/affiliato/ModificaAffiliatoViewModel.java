package sudojo.client.viewmodel.affiliato;

import java.util.ArrayList;
import java.util.Collection;

import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class ModificaAffiliatoViewModel extends AbstractViewModel implements ModificaAffiliatoViewModelInterface{

	private Collection<Observer<Subject>> observers;
	
	public ModificaAffiliatoViewModel() {
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
	public boolean modificaAffiliato(Affiliato affiliato) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificaAffiliato(Affiliato affialito, PersonaEsterna genitore) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificaAffialito(Affiliato affiliato, PersonaEsterna genitore1, PersonaEsterna genitore2) {
		// TODO Auto-generated method stub
		return false;
	}

}
