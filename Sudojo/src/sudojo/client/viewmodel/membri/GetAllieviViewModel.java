package sudojo.client.viewmodel.membri;

import java.util.ArrayList;
import java.util.Collection;

import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class GetAllieviViewModel extends AbstractViewModel implements GetAllieviViewModelInterface{
	private Collection<Observer<Subject>> observers;
	
	public GetAllieviViewModel() {
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
	public ElencoAllievi getAllievi() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
