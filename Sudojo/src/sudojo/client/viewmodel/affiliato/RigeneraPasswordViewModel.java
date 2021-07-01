package sudojo.client.viewmodel.affiliato;

import java.util.ArrayList;
import java.util.Collection;

import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class RigeneraPasswordViewModel extends AbstractViewModel implements RigeneraPasswordViewModelInterface{
	private Collection<Observer<Subject>> observers;
	
	public RigeneraPasswordViewModel() {
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
	public String rigeneraPassword(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
