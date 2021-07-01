package sudojo.client.viewmodel.presenza;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class GetPresenzeViewModel extends AbstractViewModel implements GetPresenzeViewModelInterface{
	private Collection<Observer<Subject>> observers;
	
	public GetPresenzeViewModel() {
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
	public List<Presenza> getPresenze() {
		// TODO Auto-generated method stub
		return null;
	}

}
