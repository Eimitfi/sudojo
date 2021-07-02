package sudojo.client.viewmodel.affiliato;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import sudojo.client.model.gestioneAffiliato.Affiliato;
import sudojo.client.model.net.Argomento;
import sudojo.client.model.net.Comando;
import sudojo.client.model.net.Request;
import sudojo.client.model.net.RequestInterface;
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
	public void cancellaAffiliato(Affiliato affiliato) throws IOException {
		Argomento argomento = new Argomento("affiliato", affiliato.getCredenziali().getUsername());
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		RequestInterface richiesta = new Request(Comando.CANCELLA_AFFILIATO, args);
		this.request(richiesta);
	 
	}
	
	

}
