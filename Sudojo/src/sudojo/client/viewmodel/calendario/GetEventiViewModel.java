package sudojo.client.viewmodel.calendario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class GetEventiViewModel extends AbstractViewModel implements GetEventiViewModelInterface {
	private Collection<Observer<Subject>> observers;
	
	public GetEventiViewModel() {
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
	public List<Evento> getEventi() {
		// TODO Auto-generated method stub
		return null;
	}

}
