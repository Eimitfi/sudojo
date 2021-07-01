package sudojo.client.viewmodel.affiliato;

import java.util.ArrayList;
import java.util.List;

import sudojo.client.model.gestioneAffiliato.Affiliato;
import sudojo.client.model.gestioneAffiliato.Persona;
import sudojo.client.model.net.Argomento;

public class Util {

	public List<Argomento> makeArgsFromAff(Affiliato a) {
		ArrayList<Argomento> result = new ArrayList<Argomento>();
		if (a.getGenitore1() != null) {

			result.addAll(this.makeArgsFromPersona(a.getGenitore1(), "Genitore1"));
			if (a.getGenitore2() != null)
				result.addAll(this.makeArgsFromPersona(a.getGenitore2(), "Genitore2"));
		}
		result.addAll(this.makeArgsFromPersona(a, "Affiliato"));
		if (a.getCarica() != null) {
			Argomento carica = new Argomento("carica", a.getCarica().toString());
			result.add(carica);
		}
		if (a.getCredenziali() != null) {
			Argomento pswd = new Argomento("pswd", a.getCredenziali().getPassword());
			result.add(pswd);

			Argomento usern = new Argomento("username", a.getCredenziali().getUsername());
			result.add(usern);
		}

		return result;
	}

	public List<Argomento> makeArgsFromPersona(Persona a, String str) {
		ArrayList<Argomento> result = new ArrayList<Argomento>();
		if (a.getResidenza() != null) {
			Argomento residenza = new Argomento("residenza" + str, a.getResidenza());
			result.add(residenza);
		}
		if (a.getCF() != null) {
			Argomento cf = new Argomento("cf" + str, a.getCF());
			result.add(cf);
		}
		if (a.getCognome() != null) {
			Argomento cognome = new Argomento("cognome" + str, a.getCognome());
			result.add(cognome);
		}
		if (a.getEmail() != null) {
			Argomento email = new Argomento("email" + str, a.getEmail());
			result.add(email);
		}
		if (a.getLuogoNascita() != null) {
			Argomento luogoNascita = new Argomento("luogoNascita" + str, a.getLuogoNascita());
			result.add(luogoNascita);
		}
		if (a.getNome() != null) {
			Argomento nome = new Argomento("nome" + str, a.getNome());
			result.add(nome);
		}
		if (a.getNumTelefono() != null) {
			Argomento tel = new Argomento("telefono" + str, a.getNumTelefono());
			result.add(tel);
		}
		if (a.getDataNascita() != null) {

			Argomento dataNascita = new Argomento("dataNascita" + str, a.getDataNascita().toString());
			result.add(dataNascita);
		}

		return result;

	}

}
