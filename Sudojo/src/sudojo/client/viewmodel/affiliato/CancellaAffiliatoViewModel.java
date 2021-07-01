package sudojo.client.viewmodel.affiliato;

import java.util.ArrayList;
import java.util.Collection;

import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class CancellaAffiliatoViewModel extends AbstractViewModel implements CancellaAffiliatoViewModelInterface{

	private Collection<Observer<Subject>> observers;
	
	public CancellaAffiliatoViewModel() {
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
	public boolean cancellaAffiliato(Affiliato affiliato) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
