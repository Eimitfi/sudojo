package sudojo.client.viewmodel.affiliato;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

	private List<Argomento> makeArgsFromPersona(Persona a, String str) {
		ArrayList<Argomento> result = new ArrayList<Argomento>();

		Argomento residenza = new Argomento("residenza" + str, a.getResidenza());
		result.add(residenza);
		Argomento cf = new Argomento("cf" + str, a.getCF());
		result.add(cf);
		Argomento cognome = new Argomento("cognome" + str, a.getCognome());
		result.add(cognome);
		Argomento email = new Argomento("email" + str, a.getEmail());
		result.add(email);
		Argomento luogoNascita = new Argomento("luogoNascita" + str, a.getLuogoNascita());
		result.add(luogoNascita);
		Argomento nome = new Argomento("nome" + str, a.getNome());
		result.add(nome);
		Argomento tel = new Argomento("telefono" + str, a.getNumTelefono());
		result.add(tel);

		Argomento dataNascita = new Argomento("dataNascita" + str, a.getDataNascita().toString());
		result.add(dataNascita);

		return result;

	}

	private List<Argomento> makeArgsFromAff(Affiliato a){
		ArrayList<Argomento> result = new ArrayList<Argomento>();
		if(a.getGenitore1() != null) {
			
		result.addAll(this.makeArgsFromPersona(a.getGenitore1(), "Genitore1"));
		if(a.getGenitore2() != null)result.addAll(this.makeArgsFromPersona(a.getGenitore2(), "Genitore2"));
		}
		result.addAll(this.makeArgsFromPersona(a, "Affiliato"));
		
		Argomento carica = new Argomento("carica", a.getCarica().toString());
		result.add(carica);
		Argomento pswd = new Argomento("pswd", a.getCredenziali().getPassword());
		result.add(pswd);
		Argomento usern = new Argomento("username", a.getCredenziali().getUsername());
		result.add(usern);
		
		
		return result;
	}
	
	private void crea(Affiliato affiliato) throws IOException {
		List<Argomento> args = this.makeArgsFromAff(affiliato);
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
