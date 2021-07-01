package sudojo.client.viewmodel.affiliato;

import java.io.IOException;

import sudojo.client.model.gestioneAffiliato.Affiliato;
import sudojo.client.model.gestioneAffiliato.PersonaEsterna;

public interface ModificaAffiliatoViewModelInterface {
	public void modificaAffiliato(Affiliato affiliato) throws IOException;
	public void modificaAffiliato(Affiliato affiliato, PersonaEsterna genitore) throws IOException;
	public void modificaAffialito(Affiliato affiliato, PersonaEsterna genitore1, PersonaEsterna genitore2) throws IOException;
	

}
