package sudojo.client.viewmodel.budopass;

import java.util.ArrayList;
import java.util.Collection;

import sudojo.client.model.budopass.Budopass;
import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class GetBudopassViewModel extends AbstractViewModel implements GetBudopassViewModelInterface{

	private Collection<Observer<Subject>> observers;
	
	public GetBudopassViewModel() {
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
	public Budopass getBudopass(String user) {
		// TODO Auto-generated method stub
		return null;
	}

}
