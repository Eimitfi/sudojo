package sudojo.client.viewmodel.ricevute;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;

import sudojo.client.model.net.Argomento;
import sudojo.client.model.net.Comando;
import sudojo.client.model.pagamento.Pagamento;
import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class RicevuteViewModel extends AbstractViewModel implements RicevuteViewModelInterface {
	private Collection<Observer<Subject>> observers;
	
	public RicevuteViewModel() {
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
	public void generaRicevute(List<Pagamento> pagamenti) throws IOException {
		// TODO Auto-generated method stub
		Gson g = new Gson();
		Argomento argomento = new Argomento("pagamenti", g.toJson(pagamenti));
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(argomento);
		this.request(new Request(Comando.CREA_RICEVUTE, args));
		
	}
	



}
