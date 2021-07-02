package sudojo.client.viewmodel.affiliato;

import java.io.IOException;
import java.util.ArrayList; 
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;

import sudojo.client.model.gestioneAffiliato.Affiliato;
import sudojo.client.model.gestioneAffiliato.PersonaEsterna;
import sudojo.client.model.net.Argomento;
import sudojo.client.model.net.Comando;
import sudojo.client.model.net.Request;
import sudojo.client.viewmodel.AbstractViewModel;
import sudojo.client.viewmodel.Observer;
import sudojo.client.viewmodel.Subject;

public class ModificaAffiliatoViewModel extends AbstractViewModel implements ModificaAffiliatoViewModelInterface{

	private Collection<Observer<Subject>> observers;
	
	public ModificaAffiliatoViewModel() {
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
	
	private void modifica(Affiliato affiliato) throws IOException {
//		Util util = new Util();
//		List<Argomento> args = util.makeArgsFromAff(affiliato);
		Gson g = new Gson();
		ArrayList<Argomento> args = new ArrayList<Argomento>();
		args.add(new Argomento("affiliato", g.toJson(affiliato)));
		//List<Argomento> args = this.makeArgsFromAff(affiliato);
		this.request(new Request(Comando.MODIFICA_AFFILIATO, args));
	}

	@Override
	public void modificaAffiliato(Affiliato affiliato) throws IOException {
		// TODO Auto-generated method stub
		affiliato.setGenitore1(null);
		affiliato.setGenitore2(null);
		this.modifica(affiliato);
		
	}

	@Override
	public void modificaAffiliato(Affiliato affiliato, PersonaEsterna genitore) throws IOException {
		// TODO Auto-generated method stub
		affiliato.setGenitore1(genitore);
		affiliato.setGenitore2(null);
		this.modifica(affiliato);
		
	}

	@Override
	public void modificaAffialito(Affiliato affiliato, PersonaEsterna genitore1, PersonaEsterna genitore2) throws IOException {
		// TODO Auto-generated method stub
		affiliato.setGenitore1(genitore1);
		affiliato.setGenitore2(genitore2);
		this.modifica(affiliato);
		
	}



}
