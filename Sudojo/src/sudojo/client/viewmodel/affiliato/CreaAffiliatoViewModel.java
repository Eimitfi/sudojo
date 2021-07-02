package sudojo.client.viewmodel.affiliato;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;

import sudojo.client.model.gestioneAffiliato.Affiliato;
import sudojo.client.model.gestioneAffiliato.Credenziali;
import sudojo.client.model.gestioneAffiliato.Persona;
import sudojo.client.model.gestioneAffiliato.PersonaEsterna;
import sudojo.client.model.net.Argomento;
import sudojo.client.model.net.Comando;
import sudojo.client.model.net.Request;
import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class CreaAffiliatoViewModel extends AbstractViewModel implements CreaAffiliatoViewModelInterface {

	private Collection<Observer<Subject>> observers;

	public CreaAffiliatoViewModel() {
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
		for (Observer<Subject> o : this.observers)
			o.onChange(this);

	}

	

	
	
	private void crea(Affiliato affiliato) throws IOException {
		Gson g = new Gson();
//		Util util = new Util();
//		List<Argomento> args = util.makeArgsFromAff(affiliato);
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(new Argomento("affiliato", g.toJson(affiliato)));
		//List<Argomento> args = this.makeArgsFromAff(affiliato);
		this.request(new Request(Comando.CREA_AFFILIATO, args));
		
	}

	@Override
	public void creaAffiliato(Affiliato affiliato) throws IOException {
		affiliato.setGenitore1(null);
		affiliato.setGenitore2(null);
		this.crea(affiliato);
		
		 
	}

	@Override
	public void creaAffiliato(Affiliato affiliato, PersonaEsterna genitore) throws IOException {
		affiliato.setGenitore1(genitore);
		affiliato.setGenitore2(null);
		this.crea(affiliato);
	}

	@Override
	public void creaAffialito(Affiliato affiliato, PersonaEsterna genitore1, PersonaEsterna genitore2) throws IOException {
		affiliato.setGenitore1(genitore1);
		affiliato.setGenitore2(genitore2);
		this.crea(affiliato);
	}

}
