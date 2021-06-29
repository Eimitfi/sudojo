package sudojo.client.viewmodel.membri;

import java.util.ArrayList;
import java.util.Collection;

import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class GetAffiliatiViewModel extends AbstractViewModel implements GetAffiliatiViewModelInterface{
	private Collection<Observer<Subject>> observers;
	
	public GetAffiliatiViewModel() {
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
	public ElencoAffiliati getAffiliati() {
		// TODO Auto-generated method stub
		return null;
	}

}
