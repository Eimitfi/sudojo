package sudojo.client.viewmodel.creaDocumento;

import java.util.ArrayList;
import java.util.Collection;

import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class CreaDocumentoViewModel extends AbstractViewModel implements CreaDocumentoViewModelInterface 
{
	private Collection<Observer<Subject>> observers;
	
	public CreaDocumentoViewModel() {
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
	public boolean creaDocumento(Documento doc) {
		// TODO Auto-generated method stub
		return false;
	}

}
