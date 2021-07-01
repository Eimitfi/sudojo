package sudojo.client.viewmodel.getAvviso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import sudojo.client.model.avviso.Avviso;
import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class GetAvvisoViewModel extends AbstractViewModel implements GetAvvisoViewModelInterface{
	private Collection<Observer<Subject>> observers;
	
	public GetAvvisoViewModel() {
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
	public List<Avviso> getAvvisi() {
		// TODO Auto-generated method stub
		return null;
	}

}
