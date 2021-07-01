package sudojo.client.viewmodel.pagamenti;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import sudojo.client.model.net.Argomento;
import sudojo.client.model.net.Comando;
import sudojo.client.model.net.HTTPSClient;
import sudojo.client.model.net.Request;
import sudojo.client.model.pagamento.Pagamento;
import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class GetPagamentiViewModel extends AbstractViewModel implements GetPagamentiViewModelInterface{
	private Collection<Observer<Subject>> observers;
	
	public GetPagamentiViewModel() throws MalformedURLException {
		this.observers = new ArrayList<Observer<Subject>>();
		this.setClient(new HTTPSClient("localhost"));
		
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
	public void getAllPagamenti() throws IOException {
		Request request = new Request(Comando.ALL_PAGAMENTI, null);
		//this.setResponse(this.getClient().richiedi(request));
		this.request(request);


	}

	@Override
	public void getPagamentiByIscritto(String iscritto) throws IOException {
		ArrayList<Argomento> argomenti = new ArrayList<Argomento>();
		Argomento arg = new Argomento("iscritto", iscritto);
		argomenti.add(arg);
		Request request = new Request(Comando.PAGAMENTI_BY_ISCRITTO, argomenti);
		this.request(request);
	}

}
