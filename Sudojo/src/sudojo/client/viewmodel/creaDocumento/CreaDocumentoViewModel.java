package sudojo.client.viewmodel.creaDocumento;

import java.io.IOException;
import java.util.ArrayList; 
import java.util.Collection;

import com.google.gson.Gson;

import sudojo.client.model.documento.Documento;
import sudojo.client.model.net.Argomento;
import sudojo.client.model.net.Comando;
import sudojo.client.model.net.Request;
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
		for(Observer<Subject> o : this.observers)
			o.onChange(this);
		
	}

	@Override
	public void creaDocumento(Documento doc) throws IOException {
		// TODO Auto-generated method stub
		Gson g = new Gson();
		Argomento argomento = new Argomento("documento", g.toJson(doc));
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(argomento);
		this.request(new Request(Comando.CREA_DOC, args));
		
	}
	


}
