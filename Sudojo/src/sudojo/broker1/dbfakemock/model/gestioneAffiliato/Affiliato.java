package sudojo.broker1.dbfakemock.model.gestioneAffiliato;

import java.util.Date;

public class Affiliato extends Persona {
	
	private Credenziali credenziali;
	private Carica carica;
	private PersonaEsterna genitore1;
	private PersonaEsterna genitore2;
	
	
	
	public Credenziali getCredenziali() {
		return credenziali;
	}



	public void setCredenziali(Credenziali credenziali) {
		this.credenziali = credenziali;
	}



	public Carica getCarica() {
		return carica;
	}



	public void setCarica(Carica carica) {
		this.carica = carica;
	}



	public PersonaEsterna getGenitore1() {
		return genitore1;
	}



	public void setGenitore1(PersonaEsterna genitore1) {
		this.genitore1 = genitore1;
	}



	public PersonaEsterna getGenitore2() {
		return genitore2;
	}



	public void setGenitore2(PersonaEsterna genitore2) {
		this.genitore2 = genitore2;
	}



	public Affiliato(String nome, String cognome, String residenza, String numTelefono, String luogoNascita,
			Date dataNascita, String email, String cF,Credenziali credenziali, Carica carica,PersonaEsterna genitore1,PersonaEsterna genitore2) {
		super(nome, cognome, residenza, numTelefono, luogoNascita, dataNascita, email, cF);
		this.credenziali = credenziali;
		this.carica = carica;
		this.genitore1 = genitore1;
		this.genitore2 = genitore2;
	}

}
