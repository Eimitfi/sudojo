package sudojo.client.viewmodel.affiliato;

import java.io.IOException;

import sudojo.client.model.gestioneAffiliato.Affiliato;

import sudojo.client.model.gestioneAffiliato.PersonaEsterna;

public interface CreaAffiliatoViewModelInterface {
	public void creaAffiliato(Affiliato affiliato) throws IOException;
	public void creaAffiliato(Affiliato affiliato, PersonaEsterna genitore) throws IOException;
	public void creaAffialito(Affiliato affiliato, PersonaEsterna genitore1, PersonaEsterna genitore2) throws IOException;
	

}
